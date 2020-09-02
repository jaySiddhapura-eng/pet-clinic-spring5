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
       │       └── CGI.springframework.petclinic.model
       │           ├── Owner   (C)
       │           ├── Person  (C)
       │           ├── Pet     (C)
       │           ├── PetType (C)
       │           └── Vet     (C)
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

   



