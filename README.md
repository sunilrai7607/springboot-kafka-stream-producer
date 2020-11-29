## Spring boot with Kafka

### Cloud Stream
Spring Cloud Stream is a framework for building highly scalable event-driven microservices connected with shared messaging systems.

#### Binder Implementations
Spring Cloud Stream supports a variety of binder implementations, and the following table includes the link to the GitHub projects.
* RabbitMQ
* Apache Kafka
* Kafka Streams
* Amazon Kinesis
* Google PubSub (partner maintained)
* Solace PubSub+ (partner maintained)
* Azure Event Hubs (partner maintained)
* Apache RocketMQ (partner maintained)

Connect to kafka binder or broker, Default configuration read from application.yml
```java
@Configuration
@Slf4j
@EnableBinding(Source.class)
public class KafkaConfig {

}
```

application.yml configuration
```yaml
spring:
  cloud:
    stream:
      default-binder: kafka
      kafka:
        binder:
          configuration:
            key.serializer: org.apache.kafka.common.serialization.StringSerializer
            value.serializer: org.apache.kafka.common.serialization.ByteArraySerializer
            key.deserializer: org.apache.kafka.common.serialization.StringDeserializer
            value.deserializer: org.apache.kafka.common.serialization.ByteArrayDeserializer
          broker:
            - kafka-broker:7092
      bindings:
        input:
          binder: kafka
          destination: test
          content-type: text/plain
          group: input-group-1
        output:
          binder: kafka
          destination: test
          group: output-group-1
          content-type: text/plain
```