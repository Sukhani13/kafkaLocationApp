<h1>Basic Project for implementing Kafka with Spring Boot</h1>

<h4>ecommerce-driver sends location update to ecommerce-user using Kafka through a POST request with endpoint <b>localhost:8082/location</b> for directly sending message to Kafka topic and <b>localhost:8082/locationApi</b> for 
  using Kafka Consumer API for sending message to Kafka topic.</h4>

First setup the Kafka Server.
To start the Kafka server and setup the topic, simply go to Kafka folder and run the following commands in different terminal windows:
</br>
  1. bin/zookeeper-server-start.sh config/zookeeper.properties
  2. bin/kafka-server-start.sh config/server.properties
  3. bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092
</br>
And then you are ready to run the project :)
