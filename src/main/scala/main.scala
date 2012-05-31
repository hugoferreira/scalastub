import akka.actor._
import akka.pattern.ask
import akka.util.Timeout
import akka.util.duration._
import scalaz._
import Scalaz._

final case class Ping(msg: String)
final case class Pong(msg: String)

class Ponger extends Actor {
  def receive = {
    case Ping(msg) ⇒
      println("[Ponger] Received Ping: " + msg)
      sender ! Pong(msg)
  }
}

class Pinger(a: ActorRef) extends Actor {
  var i = 0
  implicit val timeout = Timeout(20 seconds)

  context.setReceiveTimeout(1 second)

  def receive = {
    case ReceiveTimeout ⇒
      i += 1
      println("[Pinger] Pinging: " + i)
      a ? Ping(i.toString)
      println("[Pinger] Received Pong")
  }
}

class Supervisor extends Actor {
  import akka.actor.SupervisorStrategy._

  override val supervisorStrategy =
   OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1 minute) {
     case _: Exception => Restart
   }

  val ponger   = context.actorOf(Props(new Ponger), name = "ponger")
  val pinger   = context.actorOf(Props(new Pinger(ponger)), name = "pinger")

  // Deploy a scheduled assassination
  context.system.scheduler.schedule(5 seconds, 5 seconds, ponger, Kill)

  def receive = {
   case _ ⇒ { }
  }
}

object Main extends App {
  val system = ActorSystem("MySystem")
  val supervisor = system.actorOf(Props[Supervisor], name = "supervisor")
}