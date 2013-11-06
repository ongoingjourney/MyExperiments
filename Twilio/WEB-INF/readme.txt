1) To deploy this on tomcat.
	a) Move src/resources/applicationContext.xml into WEB-INF
	b) Under $CATALINA_HOME/webapps, your directory structure should be
		Twilio
		|
		----WEB-INF
			|
			----applicationContext.xml
			----twilio-servlet.xml
			----web.xml
			----classes
				|
				----com
					|
					----(follow directory structure of sources file. But it should include bytecode, not .java)
			----lib
				|
				----spring-beans-4.0.0.M2.jar
				----spring-beans-4.0.0.M2.jar
				----spring-context-4.0.0.M2.jar
				----spring-context-support-4.0.0.M2.jar
				----spring-core-4.0.0.M2.jar
				----spring-expression-4.0.0.M2.jar
				----spring-jdbc-4.0.0.M2.jar
				----spring-tx-4.0.0.M2.jar
				----spring-web-4.0.0.M2.jar
				----spring-webmvc-4.0.0.M2.jar
				----spring-webmvc-portlet-4.0.0.M2.jar
				
			
2) Start tomcat with $CATALINA_HOME/bin/catalina.sh run
3) Currently supported 
	GET request - http://localhost:8080/Twilio/twilio/getResponse
	POST reqest - curl -X POST http://localhost:8080/Twilio/twilio/getResponseWithPost