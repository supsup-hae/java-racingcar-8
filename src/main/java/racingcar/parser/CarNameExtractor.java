package racingcar.parser;

import java.util.Arrays;
import java.util.List;
import racingcar.validator.InputStringValidator;

public class CarNameExtractor implements Extractor<String, List<String>>{
    private static final String DEFAULT_DELIMITER = ",";

    @Override
    public List<String> extract(String input) {
        InputStringValidator.getInstance().validate(input);

        return Arrays.stream(input.split(DEFAULT_DELIMITER))
                .map(String::trim)
                .toList();
    }
}
