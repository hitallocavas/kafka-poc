package config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

import static java.util.Objects.isNull;
import static environment.kafka.KafkaVariables.*;

public class OrderPropertiesConfig {
    private static Properties properties;

    private OrderPropertiesConfig(){}

    public static Properties getProperties() {
        if (isNull(properties)) {
            properties = new Properties();
            properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, getBootstrapServer());
            properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        }
        return properties;
    }
}
