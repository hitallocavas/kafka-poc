package consumer;

import static environment.kafka.KafkaVariables.getOrderTopic;
import static config.FraudDetectorPropertiesConfig.getProperties;

public class FraudDetectorConsumer extends Consumer<String, String>{
    public void fraudDetector() throws InterruptedException {
        this.consume(getOrderTopic(), getProperties());
    }
}
