package hw.CsvAnalyze;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvAnalyze {
    static void main() throws IOException {
        Path input = Paths.get("items.csv");
        Path output = Paths.get("report.txt");
        CsvParser<Order> parser = new CsvParser<>();
        OrderParser orderParser = new OrderParser();

        List<Order> orders = parser.parse(input, orderParser);

        Map <String, List<Order>> grouped = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct));

        Map<String, Integer> totalByProduct = grouped.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .mapToInt(Order::getQuantity).sum()
                ));
        List<Map.Entry<String, Integer>> top3 = totalByProduct.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Parsed orders:");
        orders.forEach(System.out::println);
        try (BufferedWriter writer = Files.newBufferedWriter(output)) {
            for (var entry : top3) {
                writer.write(String.format("Item: %s, Num of orders: %d%n",
                        entry.getKey(), entry.getValue()));
            }
        }
        System.out.println("Report path: " + output.toAbsolutePath());


    }
}
