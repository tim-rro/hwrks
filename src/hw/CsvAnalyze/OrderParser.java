package hw.CsvAnalyze;

import java.util.Optional;
import java.util.function.Function;

public class OrderParser implements Function<String, Optional<Order>> {
    @Override
    public Optional<Order> apply(String line) {
        line = line.replace("\uFEFF", "");
        try{
            String[] parts = line.split(",");
            if(parts.length != 3)
                return Optional.empty();
            int id = Integer.parseInt(parts[0].trim());
            String product = parts[1].trim();
            int quantity = Integer.parseInt(parts[2].trim());
            if(product.isEmpty())
                return Optional.empty();
            return Optional.of(new Order(id, product, quantity));
        }catch (Exception e){
            System.err.println("Error in the line: " + line);
            return Optional.empty();
        }
    }
}
