package producer;

import config.OrderPropertiesConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

import static environment.kafka.KafkaVariables.getOrderTopic;

public class NewOrderProducer extends Producer<String, String>{
    public void sendOrder(String key, String value) throws ExecutionException, InterruptedException {
        System.out.println("Sending new order with key " + key);
        this.send(key, value, getOrderTopic(), OrderPropertiesConfig.getProperties());
    }
}
