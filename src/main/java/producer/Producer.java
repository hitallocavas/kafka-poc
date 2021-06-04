package producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

class Producer<KEY_TYPE, VALUE_TYPE> {

    public static final String PONTO_E_VIRGULA = ";";
    private final Callback callback = ((data, e) -> {
        if (nonNull(e)) {
            e.printStackTrace();
        } else {
            List<String> logEntries = Arrays.asList(
                    "timestamp=", Long.toString(data.timestamp()), PONTO_E_VIRGULA,
                    "topic=", data.topic(), PONTO_E_VIRGULA,
                    "offset=", Long.toString(data.offset()), PONTO_E_VIRGULA,
                    "partition=", Integer.toString(data.partition()));
            System.out.println("Objeto foi enviado com sucesso! \nDados:");
            System.out.println(String.join("", logEntries));
        }
    });

    void send(KEY_TYPE key, VALUE_TYPE value, String topic, Properties properties) throws ExecutionException, InterruptedException {
        var producer = new KafkaProducer<KEY_TYPE, VALUE_TYPE>(properties);
        var recorder = new ProducerRecord<>(topic, key, value);
        producer.send(recorder, callback).get();
    }
}
