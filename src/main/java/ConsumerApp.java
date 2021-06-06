import consumer.FraudDetectorConsumer;
import producer.NewOrderProducer;

import java.util.concurrent.ExecutionException;

public class ConsumerApp {

    public static void main(String[] args) {
        var fraudDetector = new FraudDetectorConsumer();
        try {
            fraudDetector.fraudDetector();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
