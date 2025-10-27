package racingcar.exception;

import racingcar.enums.ErrorMessage;

public class RacingCarException extends IllegalArgumentException {
    
    public RacingCarException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
