import akka.actor._
import akka.pattern.ask
import akka.util.Timeout
import akka.util.duration._

final case class Ping(msg: String)
final case class Pong(msg: String)

class Ponger extends Actor {
  def receive = {
    case Ping(msg) =>
      println("[Ponger] Received Ping: " + msg)
      sender ! Pong(msg)
  }
}

class Pinger(a: ActorRef) extends Actor {
  var i = 0
  implicit val timeout = Timeout(20 seconds)

  context.setReceiveTimeout(1 second)

  def receive = {
    case ReceiveTimeout =>
      i += 1
      println("[Pinger] Pinging: " + i)
      a ? Ping(i.toString)
      println("[Pinger] Received Pong")
  }
}

class Assassin(a: ActorRef, timeOut: Long) extends Actor {
  context.setReceiveTimeout(timeOut milliseconds)

  def receive = {
    case ReceiveTimeout =>
      println("[Assassin] Deploying PoisonPill")
      a ! Kill
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
 val assassin = context.actorOf(Props(new Assassin(ponger, 5000)), name = "assassin")

 def receive = {
   case _ => { }
 }
}

object Main extends App {
  val system = ActorSystem("MySystem")
  val supervisor = system.actorOf(Props[Supervisor], name = "supervisor")
}