# The Great Refactoring

> **Warning:** this is an experimental branch - this code may or may not _ever_ make it into production.

## Overview

The goal here is to split up the functionality for Ersatz into:
 
1. a "core" library which could be used on its own (without a DSL) - this core library will be written in Java 8
2. a "java" DSL library which will provide the functional extensions for configuration using Java 8
    * I am somewhat on the fence about whether this should be separate or just part of the core, but I am leaning towards separate for consistency.
3. a "groovy" DSL library which will provide the Groovy DSL (as it is now)
3. a "kotlin" DSL library which will provide a Kotlin DSL configuration interface.

The DSL projects will each depend on the core, so there is still only a single dependency required. Also, the goal would be to have the shadow jars 
also provide the core as a bundled dependency (without remapping).

## Work

The core project has been created from the original project (currently still Groovy), what needs to be done:

1. refactor the configuration so that it is not so coupled with the server itself
    * the goal will be to allow the configuration of a server via direct configuration using simple Java configuration objects.
    * the DSLs will then provide a language-specific means of creating the configuration object in a DSL-friendly manner specific to that language.
2. the current java and groovy DSL support will need to be pulled out into separate projects
3. add a Kotlin DSL implementation

* Consider and document how other JVM languages could provide DSL support (e.g. Clojure or Scala).
* Make sure everything is supported as before (build, coverage, docs, site, etc).