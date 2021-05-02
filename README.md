# weatherApi
Spring Boot Applicattion

Rest service exposed to get the weather fore cast based on city, country and latitude,longitude

Three services exposed

Get Country list -> List the ISO 3166 country list fetched and saved as Json.
Search by city -> Fetch the weather cast with city and country as input
Search by country -> Fetch the weather cast with langitude & latitude.
Cache Enabled for all the services.

Running the application

1.Run Spring Boot app with java -jar command

To run Spring Boot app from a command line in a Terminal window use java -jar command. This is provided the Spring Boot app was packaged as an executable jar file.

      java -jar target/app-0.0.1-SNAPSHOT.jar
      
2.Run Spring Boot app using Maven

Also we can use Maven plugin to run your Spring Boot app. Use the below command to run Spring Boot app with Maven plugin:

      mvn spring-boot:run
