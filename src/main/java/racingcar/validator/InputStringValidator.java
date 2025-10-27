package racingcar.validator;

import racingcar.enums.ErrorMessage;
import racingcar.exception.RacingCarException;

public class InputStringValidator implements Validator<String> {
    private static final InputStringValidator INSTANCE = new InputStringValidator();

    private InputStringValidator() {
    }

    public static InputStringValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public void validate(String input) {
        validateNotNull(input);
        validateNotEmpty(input);
        validateNotBlank(input);
        validateDelimiter(input);
        validateCommaFormat(input);
    }

    private void validateNotNull(String input) {
        if (input == null) {
            throw new RacingCarException(ErrorMessage.INPUT_NULL);
        }
    }

    private void validateNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new RacingCarException(ErrorMessage.INPUT_EMPTY);
        }
    }

    private void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new RacingCarException(ErrorMessage.INPUT_BLANK);
        }
    }

    private void validateDelimiter(String input) {
        if (input.matches(".*[;:|/\\\\].*")) {
            throw new RacingCarException(ErrorMessage.INVALID_DELIMITER);
        }
    }

    private void validateCommaFormat(String input) {
        if (input.contains(",,")) {
            throw new RacingCarException(ErrorMessage.CONSECUTIVE_COMMAS);
        }
        if (input.startsWith(",")) {
            throw new RacingCarException(ErrorMessage.STARTS_WITH_COMMA);
        }
        if (input.endsWith(",")) {
            throw new RacingCarException(ErrorMessage.ENDS_WITH_COMMA);
        }
    }
}
