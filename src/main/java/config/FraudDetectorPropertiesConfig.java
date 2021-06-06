package config;

import consumer.FraudDetectorConsumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.UUID;

import static environment.kafka.KafkaVariables.getBootstrapServer;
import static environment.kafka.KafkaVariables.getFraudGroup;
import static java.util.Objects.isNull;

public class FraudDetectorPropertiesConfig {
    private static Properties properties;

    private FraudDetectorPropertiesConfig(){}

    public static Properties getProperties() {
        if (isNull(properties)) {
            properties = new Properties();
            properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, getBootstrapServer());
            properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, UUID.randomUUID().toString());
            properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
            properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");        }
        return properties;
    }
}
