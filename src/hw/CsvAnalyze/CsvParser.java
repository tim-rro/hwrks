package hw.CsvAnalyze;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvParser<T>{
    public List<T> parse(Path path, Function<String, Optional<T>> mapper) throws IOException{
        try(Stream<String> lines  = Files.lines(path)){
            return lines
                    .map(mapper)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
        }
    }
}
