1) Configure DB - See JDBC settings in applicationContext.xml
2) To deploy this on tomcat.
	a) Move src/resources/applicationContext.xml into WEB-INF
	b) Under $CATALINA_HOME/webapps, your directory structure should be
		SpringDictionaryService
		|
		----WEB-INF
			|
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
				
			----applicationContext.xml
			----dictionary-servlet.xml
			----web.xml
			
			----applicationContext.xml
			
2) Start tomcat with $CATALINA_HOME/bin/catalina.sh run
3) Currently supported 
	http://localhost:8080/SpringDictionaryService/dictionary/putWord/{word}/{meaning}
	e.g - http://localhost:8080/SpringDictionaryService/dictionary/putWord/pen/toWrite
	
	http://localhost:8080/SpringDictionaryService/dictionary/getWord/{word}
	e.g - http://localhost:8080/SpringDictionaryService/dictionary/getWord/pen
	
		