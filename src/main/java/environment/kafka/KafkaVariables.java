package environment.kafka;

import java.util.Map;

public class KafkaVariables {
    private static final Map<String, String> environments = System.getenv();

    public static String getBootstrapServer(){
        return environments.get("BOOTSTRAP_SERVER");
    }

    public static String getOrderTopic(){
        return environments.get("ORDER_TOPIC");
    }

    public static String getFraudGroup() { return environments.get("FRAUD_GROUP"); }
}
