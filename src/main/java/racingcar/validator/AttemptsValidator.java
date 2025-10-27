package racingcar.validator;

import racingcar.enums.ErrorMessage;
import racingcar.exception.RacingCarException;

public class AttemptsValidator implements Validator<String> {
    private static final AttemptsValidator INSTANCE = new AttemptsValidator();

    private AttemptsValidator() {
    }

    public static AttemptsValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public void validate(String input) {
        int attempts = parseAttempts(input);
        validatePositive(attempts);
    }

    private int parseAttempts(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RacingCarException(ErrorMessage.ATTEMPTS_INVALID_FORMAT);
        }
    }

    private void validatePositive(int attempts) {
        if (attempts <= 0) {
            throw new RacingCarException(ErrorMessage.ATTEMPTS_NOT_POSITIVE);
        }
    }

    public int parseAndValidate(String input) {
        validate(input);
        return Integer.parseInt(input);
    }
}
