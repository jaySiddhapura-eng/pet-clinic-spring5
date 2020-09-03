# Pet Clinic application using Spring

## Dependencies

1. Spring Boot Devtools 
2. Lombok
3. Spring web
4. Thymeleaf
5. H2 Database
6. Spring data JPA
7. MySQL Driver
8. Actuator

## Modularization of Project 

1. Main concept is to breakdown the main project into multiple sub projects, and link them as dependency
2. In Maven, the preferred approach is to structure the project as multi module project and delegate the rest to Maven
3. In this case parent project works as a container for base maven configuration

## Parent POM

1. The pom.xml file of the parent project will have list of child module projects, and parent pom.xml will act as an aggregator
2. The parent POM defines the packaging **POM** instead of packaging **JAR**
3. The child module which will act as a dependency for another module will have packaging JAR

## Child modules / Projects

1. The child modules are independent maven projects that share properties from the parent project.
2. Each child module can built and run individually
3. When parent project get built, if all the child configurations are correct then child modules will go through all the maven building phases automatically

## Project Directory with Multiple modules

~~~powershell
spring-5-pet-clinic-project-master
    ├── .idea
    ├── .mvn
    ├── ----------------------------------
    ├── pet-clinic-data.......[Module 1]
    │   ├── pom.xml...[module1 pom]
    │   ├── src
    │   └── target
    ├── -----------------------------------
    ├── pet-clinic-web........[Module 2]
    │   ├── pom.xml...[module2 pom]
    │   ├── src
    │   └── target
    ├── -----------------------------------
    └── pom.xml.......[parent pom]
~~~

## Relation between child Modules

1. ```pet-clinic-data``` acts as  dependency to the ```pet-clinic-web```

2. Therefore ```pet-clinic-data``` need to be compiled in jar and this jar will be given to the ```pet-clinic-web``` as a dependency

3. ```pom.xml``` of pet-clinic-data

   ~~~xml
   <parent>
       <artifactId>pet-clinic</artifactId>
       <groupId>CGI.springframework</groupId>
       <version>0.0.3</version>
   </parent>
   
   <modelVersion>4.0.0</modelVersion>
   <artifactId>pet-clinic-data</artifactId>
   
   <dependencies>
       <!--module specific dependencies-->
   </dependencies>
   
   <build>
       <plugins>
               <plugin>
                   <groupId>org.springframework.boot</groupId>
                   <artifactId>spring-boot-maven-plugin</artifactId>
                   <executions>
                       <!--------building the executable--------->
                       <execution>
                           <goals>
                               <goal>repackage</goal>
                           </goals>
                           <configuration>
                               <skip>true</skip>
                           </configuration>
                       </execution>
                       <!----------------------------------------->
                   </executions>
               </plugin>
           </plugins>
   </build>
   ~~~

4. ```pom.xml``` of pet-clinic-web

   ~~~xml
   <parent>
       <artifactId>pet-clinic</artifactId>
       <groupId>CGI.springframework</groupId>
       <version>0.0.3</version>
   </parent>
   
   <modelVersion>4.0.0</modelVersion>
   <artifactId>pet-clinic-web</artifactId>
   
   <dependencies>
       <!--module specific dependencies-->
   </dependencies>
   
   <build>
      <plugins>
          <plugin>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-maven-plugin</artifactId>
          </plugin>
      </plugins>
   </build>
   ~~~

5. ```pom.xml``` of parent project / module

   ~~~xml
   <modelVersion>4.0.0</modelVersion>
   <packaging>pom</packaging>
   
   <modules>
      <module>pet-clinic-data</module>
      <module>pet-clinic-web</module>
   </modules>
   
   <parent>
   	<groupId>org.springframework.boot</groupId>
   	<artifactId>spring-boot-starter-parent</artifactId>
   	<version>2.3.3.RELEASE</version>
   	<relativePath /> <!-- lookup parent from repository -->
   </parent>
   
   <groupId>CGI.springframework</groupId>
   <artifactId>pet-clinic</artifactId>
   <version>0.0.3</version>
   <name>pet-clinic</name>
   <description>spring demo project</description>
   
   <dependencies>
       <!--common dependencies for both the moudles-->
   </dependencies>
   
   <!--maven release plugin configuration-->
   <build>
   	<plugins>
            <!------------------------------------------------------------->
   		<plugin>
   			<groupId>org.springframework.boot</groupId>
   			<artifactId>spring-boot-maven-plugin</artifactId>
   		</plugin>
   		<!------------------------------------------------------------->
   		<plugin>
   			<groupId>org.apache.maven.plugins</groupId>
   			<artifactId>maven-release-plugin</artifactId>
   			<version>3.0.0-M1</version>
   			<configuration>
   			<goals>install</goals>
   			<autoVersionSubmodules>true</autoVersionSubmodules>
   			</configuration>
   		</plugin>
   		<!------------------------------------------------------------->
   		<plugin>
   			<groupId>org.apache.maven.plugins</groupId>
   			<artifactId>maven-surefire-plugin</artifactId>
   			<version>2.22.0</version>
   			<configuration>
   				<argLine>
   						--illegal-access=permit
   				</argLine>
   			</configuration>
   		</plugin>
           <!------------------------------------------------------------->
   	</plugins>
   </build>
   
   <!--for release destination-->
   <scm>
   	<developerConnection>scm:git:repo link</developerConnection>
   	<tag>pet-clinic-0.0.3</tag>
   </scm>
   ~~~

## Creating data model

1. Location : pet-clinic-data module / project

   ~~~powershell
   pet-clinic-data.......[Module 1]
       ├── src
       │   └── java
       │       └── CGI.springframework.petclinic
       │           └── model
       │               ├── Person  (C)
       │               ├── Owner   (C)
       │               ├── Vet     (C)
       │               ├── Pet     (C)
       │               └── PetType (C)
       ├── target
       └── pom.xml
   ~~~

2. Person class

   ~~~java
   public class Person {
       private String firstName;
       private String lastName;
   
   	// gettter and setter for the properties
   }
   ~~~

3. Owner class

   ~~~java
   public class Owner extends Person {
   }
   ~~~

4. Vet class

   ~~~java
   public class Vet extends Person{
   }
   ~~~

5. PetType class

   ~~~java
   public class PetType {
       private String name;
       // getter and setter for the property
   }
   ~~~

6. Pet.class

   ~~~java
   public class Pet {
       private PetType petType;
       private Owner owner;
       private LocalDate birthDate;
   
   	// getter and setter for the properties
   }
   ~~~


## Create the Service Layer

1. Location of services

   ~~~powershell
    pet.clinic.data
       ├── src
       │   ├── main
       │   │   └── java
       │   │       └── CGI.springframework.petclinic
       │   │           └── Services
       │   │               ├── OwnerService
       │   │               ├── PetService
       │   │               └── VetService
       │   └── test
       └── pom.xml
   ~~~

2. ```OwnerService``` 

   ~~~java
   public interface OwnerService{
       // methods declaration
       Owner findByLastName(String lastName);
       Owner findById(Long id);
       Owner save(Owner owner);
       Set<Owner> findAll();
       void delete(Owner owner);
       void deleteById(Long id);
   }
   //whichever class implements this service must implements all the methods declared above
   ~~~

3. ```PetService```

   ~~~java
   public interface PetService{
       Pet findById(Long id);
       Pet save(Pet pet);
       Set<Pet> findAll();
       void delete(Pet pet);
       void deleteById(Long id);
   }
   ~~~

4. ```VetService```

   ~~~java
   public interface VetService{
       Vet findByLastName(String lastName);
       Vet findById(Long id);
       Vet save(Vet vet);
       Set<Vet> findAll();
       void delete(Vet vet);
       void deleteById(Long id);
   }
   ~~~

5. If we notice, we can see all three class has some of the similar methods such as ```findAll, findById, save, delete and deleteAll```

6. Although the methods are same but it handles different kind of data such as ```Vet, Pet, Owner``` according to the service

7. We can create an Parent interface which will be generic in nature, so that all the services can extend that interface regardless of the data the they handles

8. This parent interface will have all the common methods, which reduces the code duplication

9. Create the parent interface : ```CrudService``` interface

   ~~~java
   public interface CrudService <T, ID> {
       T findById(ID id);
       T save(T object);
       Set<T> findAll();
       void delete(T object);
       void deleteById(ID id);
   }
   // T and ID will be supplied from the interface which will extend this interface
   ~~~

10. Modifying the child services

11. ```OwnerService``` Interface

    ~~~java
    // Owner is the datatype which will apply to the methods of Crudservice
    public interface OwnerService extends CrudService <Owner, Long>{
        Owner findByLastName(String lastName);
        // other methods are already declared in the CrudService Interface
    }
    ~~~

12. ```PetService``` interface

    ~~~java
    // Pet is the datatype which will apply to the methods of CrudService 
    public interface PetService extends CrudService<Pet, Long> {
        // all the methods are already declared in the CrudService interface
    }
    ~~~

13. ```VetService``` interface

    ~~~java
    // Pet is the datatype which will apply to the methods of CrudService
    public interface VetService extends CrudService<Vet, Long>{
        Vet findByLastName(String lastName);
        // other methods are already declared in the CrudService Interface
    }
    ~~~

    

    

    

    

    

    

    

    

    

    

    

    

    

    

     



