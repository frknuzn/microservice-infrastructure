# Microservice Example Infrastructure

This project is a sample application for Microservice Architecture.

Microservices is a very big and detailed topic. I am sharing with you this repo I made from what I learned to improve myself.

Technologies Used

•	Java 11 </br>
•	Spring Boot </br>
•	Spring Cloud </br>
•	Spring Data JPA </br>
•	Netflix Eureka </br>
•	Zipkin </br>
•	Prometheus </br>
•	Kafka </br>
•	Micrometer </br>
•	Lombok </br>
•	H2 </br>
•	Docker </br>
•	Grafana

How does it work?

•	You should download kafka on your computer
https://kafka.apache.org/ 
•	Find the Kafka folder and enter it
•	Run the code suitable for your operating system
•	Find the Kafka folder and enter it
•	Run the code suitable for your operating system
  Mac OS
    ./zookeeper-server-start.sh ../config/zookeeper.properties

    ./kafka-server-start.sh ../config/server.properties

  Windows
    zookeeper-server-start.bat ..\..\config\zookeeper.properties

    kafka-server-start.bat ..\..\config\server.properties
    
•	you have to follow this order to run the project correctly
configserver -> eurekaserver -> gatewayserver -> Accounts -> Phones
•	Go to the downloaded project file and run the code " mvn spring-boot:run "


•	You can test it by making a post request to this address http://localhost:8080/myAccount 
post data {"phone":{"accountId":3,"phoneBrandName":"Android","phoneSerialNumber":"123CCCOSXXXX"}}

•	You can check the data you sent from this address http://localhost:9000/h2-console/

Monitoring

•	Go to the watch folder and switch to terminal
Run Prometheus and Grafana with the docker-compose up command

•	Login to grafana at http://localhost:3000/login
  user: admin password: password
•	Click the "Add your first data source" button
•	On the screen that opens, select prometheus
•	On the screen that opens, enter http://prometheus:9090 from the url section and click Save & Test

•	We create a dahshboard

![1](https://user-images.githubusercontent.com/19998326/130111410-d43e0a46-6912-4dd8-8d55-ad66337e1daf.png)

•	We enter this url on the screen that comes up and click on the load button https://grafana.com/grafana/dashboards/11378

•	On the next screen, we make sure that our settings are as in the screenshot below and click the import button.

![2](https://user-images.githubusercontent.com/19998326/130112121-ba952848-dca6-4dd6-947b-b57027b3f086.png)

And our dashboard is ready :)

![3](https://user-images.githubusercontent.com/19998326/130112273-f70b5944-6ea9-4841-8348-3911c8efd3f5.png)


I hope everything will be fine. Have a nice day :)



Sources I have read and watched
https://medium.com/javarevisited/hands-on-hexagonal-architecture-with-spring-boot-ca61f88bed8b </br>
https://www.udemy.com/course/microservices-ddd/ </br>
https://www.udemy.com/course/apache-kafka-for-developers-using-springboot/ </br>
https://www.udemy.com/course/master-microservices-with-spring-docker-kubernetes/ </br>
https://12factor.net/
