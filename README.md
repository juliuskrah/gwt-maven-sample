# GWT Maven Sample
This project uses the [codehaus.mojo](https://gwt-maven-plugin.github.io/gwt-maven-plugin/) maven plugin to integrate maven with [GWT](http://www.gwtproject.org/). [Spring](http://spring.io/) has been added to provide [DI](https://en.wikipedia.org/wiki/Dependency_injection) for the project. A reporting feature has been added just for kicks ([JasperReports](http://community.jaspersoft.com/project/jasperreports-library)).

## Pre-requisites
- Java 7+
- Maven 3.3.3+
- GWT 2.7.0+

## Getting the dependencies
The latest version of Spring4GWT can be found [here](https://code.google.com/archive/p/spring4gwt/downloads)

---
To install the dependency in your local maven repository, run 
> mvn install:install-file -Dfile=&lt;path-to-file&gt; -DgroupId=_org.spring4gwt_ 
-DartifactId=_spring4gwt_ -Dversion=_0.0.1_ -Dpackaging=_jar_

where &lt;`path-to-file`&gt; is the relative or absolute path to the location of the _spring4gwt.jar_.
> example when you downloaded the jar file to your download directory, your &lt;`path-to-file`&gt; is `/home/user/download/`, then the
`-Dfile` option will be `-Dfile=/home/user/download/spring4gwt-0.0.1.jar`

## Running the application
With version 2.7.0 of the `gwt-maven-plugin`, the application starts in
 [Super Dev Mode](http://www.gwtproject.org/articles/superdevmode.html)

### Running the super mode
To run the application in `super dev mode`, run
> mvn war:exploded gwt:run

The `war:exploded` goal is to ensure all libraries are copied to the `/WEB-INF/lib/` directory. Just running
`mvn gwt:run` _won't_ do that.

This will open the GWT Development Mode. Visit [http://127.0.0.1:8888/JasperGWT.html](http://127.0.0.1:8888/JasperGWT.html) in your browser

Happy coding
