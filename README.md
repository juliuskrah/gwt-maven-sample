# GWT Maven Sample
This project uses the [codehaus.mojo](https://gwt-maven-plugin.github.io/gwt-maven-plugin/) maven plugin to integrate maven with [GWT](http://www.gwtproject.org/). [Spring](http://spring.io/) has been added to provide [DI](https://en.wikipedia.org/wiki/Dependency_injection) for the project. A reporting feature has been added just for kicks ([JasperReports](http://community.jaspersoft.com/project/jasperreports-library)).

## Pre-requisites
- Java 6+
- Maven 3.3.3+
- GWT 2.6.0+

## Running the application
The application can be run one of two ways
- [Classic Dev Mode](http://www.gwtproject.org/doc/latest/DevGuideCompilingAndDebugging.html)
- [Super Dev Mode](http://www.gwtproject.org/articles/superdevmode.html)

### Runnning the classic mode
Don't use this mode. It's a legacy mode with support for older browsers. To run the `classic mode` run 
> mvn gwt:run

### Running the super mode
The recommended way to run the application is with the `super dev mode`. This mode runs two servers. The `code server` which compiles your java code and the `applicationn server` that serves your javascript content.
To run the application in `super dev mode`, run
> mvn process-classes gwt:run-codeserver

This starts the `code server`. Visit [http://localhost:9876](http://localhost:9876) in your browser. Drag and drop the `Dev Mode On` and `Dev Mode off` bookmarklets to your browser's bookmark bar.
Open another shell window and run
> mvn gwt:run

This will open the GWT Development Mode. Visit [http://127.0.0.1:8888/JasperGWT.html](http://127.0.0.1:8888/JasperGWT.html) in your browser and click the `Dev Mode On` bookmarklet. This will compile your java code into javascript

Happy coding
