
Address_Rest_API


environment:

Spring boot
Rest
Maven
Mongodb


	•	This application  handles CRUD operations of  user addresses
	•	developed using spring boot
	•	Mongodb database is used . Repository interface is used for managing CRUD operations
	•	Spring controller methods( REST) are developed for CRUD operations of addresses
	•	Logging is done using  org.slf4j.Logger
	•	Validation of requests is implemented
	•	Localization  is implemented
	•	Externalized configuration is done using property resource
	•	 Exception handling using controller advice and exception handler
	   
	

You can run the example application by using the following command:

    mvn clean spring-boot:run
    
    Future enhancements
    1) spring security configuration
    2) include tests
    3)implemntation  using cassandra db
