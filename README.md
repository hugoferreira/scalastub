### What is this?

This is an empty Scala project, with the following dependencies already configured:

* Scala 2.9.2
* Akka 2.0.1
* ScalaZ 7 (SNAPSHOT)
* ScalaCheck 1.9
* Specs2 1.10
* Sbt-Idea (plugin for automatically generating IntelliJ project structure)
* Eclipse  (plugin for automatically generating Eclipse  project structure)
* Ensime-sbt-cmd (plugin for automatically generating Ensime project file)
* SBT from sbt-extras (automatically fetches sbt)

### Basic usage

Launch SBT:

```
% ./sbt
```

And then:

```
> update 
> gen-idea  (* for IntelliJ *)
> eclipse 	(* for Eclipse  *)
> ensime generate (* for Ensime *)
```

To run using SBT only:

```
> compile
> run						(* run also compiles if necessary *)
```

To continuously compile:

```
> ~compile
```

To continuously run tests:

```
> ~test
```

For a more powerful templating solutions, see [Giter8](https://github.com/n8han/giter8).
