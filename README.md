### What is this?

This is an empty Scala project, with the following dependencies already configured:

* Scala 2.10-SNAPSHOT
* Akka 2.0
* Sbt-Idea (plugin for automatically generating IntelliJ project structure)
* Eclipse  (plugin for automatically generating Eclipse  project structure)

### Basic usage

Launch SBT:

```
% sbt -210
```

And then:

```
> update 
> gen-idea no-classifiers   (* for IntelliJ *)
> eclipse 					(* for Eclipse  *)
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
