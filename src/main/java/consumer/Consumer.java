package consumer;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import static java.util.Objects.nonNull;

class Consumer<KEY_TYPE, VALUE_TYPE> {
    void consume(String topic, Properties properties) throws InterruptedException {
        var consumer = new KafkaConsumer<KEY_TYPE, VALUE_TYPE>(properties);
        consumer.subscribe(Collections.singletonList(topic));
        var records = consumer.poll(Duration.ofMillis(100L));
        while (true) {
            if (records.isEmpty()) {
                System.out.println("Não encontrei registros");
            } else {
                for (var record : records) {
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("Key -> " + record.key());
                    System.out.println("Value -> " + record.value());
                    System.out.println("Partition -> " + record.partition());
                    System.out.println("Offset -> " + record.offset());
                }
            }
            Thread.sleep(Duration.ofSeconds(2).toMillis());
        }
    }
}
