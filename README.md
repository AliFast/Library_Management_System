# Library_Management_System

Problem (Error) : 
					1) EJB object in controller classes is Null. Unhandeled exception. I have tried fixing but failed I do not understand why
					   its always Null. Although I have used the same method I used with Servlets that worked.
					2) Persistence Context Object (EntityManager object) used to communicate with database is also Null. Unhandled Exception.
					   I have tried fixing but failed. My Last try included making a Singleton class named PersistenceObject (service package) to get 
					   EntityManager object but it was still null.
					   

Application was working fine before adding EJB specifications. I have its copy but not uploading it.


JAR Files : 
            mail.jar,
            AbsoluteLayout.jar
            
Settings :
          make a java application project and add ejb specification from facets. (eclipse)
          do not forget to create a database for the LMS. And set up glassfish. It should work with other applications servers as well.
          I have used EclipseLink Implementation of JPA . Although no implementation specific methods were used. So it should work with
          Hibernate or anyother JPA specific implentation as well.
          
Details of Application: 
						services package has class files (EJB classes with stateless Local bean) specific for communication with database.
						validation package has files specific to user input validation and to check whether the given unique values exist 
						in Database or not. modal package has Entity classes and uses Single table per hierachy approach for inheritence.
						Controller package gets user input values and uses EJB object to call service package EJB classes. userInterface
						package has UI classes which uses Swing to implement UI. META-INF has persistence settings that i was using.
