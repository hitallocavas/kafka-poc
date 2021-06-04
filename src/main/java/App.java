import producer.NewOrderProducer;

import java.util.concurrent.ExecutionException;

public class App {

    public static void main(String[] args) {
        var newOrderProducer = new NewOrderProducer();
        try {
            newOrderProducer.sendOrder("ORDER", "ID:1,VALOR:123.5");
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
