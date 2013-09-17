Layered architecture

client -> service ->DB
service = security + controller + service + DAO

DAO - Advantages
	Application is independent of Data access tech
	Offers loose coupling with other layer
	Testabality using mock objects.  
	
Service Layer -> DAO interfaces -> DAO Implenentation -> DB


Best practices
	DAO classes should adhere to interfaces
	Interfaces will onl expose functionality needed by the serice layer.
	Keep the db related confi outside the code as configurable items in xml or properties

Problems with JDBC(that's solved by spring jdbc)
	Poor exception handling. These are checked exception.
	 
Data access templates in Spring
	JDBCTemplate			: JDBC
	SQLMapClientTemplate	: iBatis
	

JDBC Template depends on 
	Data Source to get connection etc
	DAO Impl to do the busines logic.
	

JDBC Configuration steps
	Choosing Data Source(pick one)
		Data sources by JDBC API
			DriverManagerDataSrouce
			SingleSonnectionDataSource
		Data sources looked up by JNDI
		Data sources that pool connections
		
	Configure Data Source
	
	Configure JDBC template
	
	Register DAO Impl












 
