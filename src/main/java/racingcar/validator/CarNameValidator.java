package racingcar.validator;

import racingcar.enums.ErrorMessage;
import racingcar.exception.RacingCarException;
import racingcar.model.CarName;

public class CarNameValidator implements Validator<CarName> {
    private static final CarNameValidator INSTANCE = new CarNameValidator();
    public static final int MAXIMUM_LENGTH = 5;

    private CarNameValidator() {
    }

    public static CarNameValidator getInstance() {
        return INSTANCE;
    }


    @Override
    public void validate(CarName carName) {
        if (carName == null) {
            throw new RacingCarException(ErrorMessage.CAR_NAME_NULL);
        }

        String name = carName.getName();

        if (name == null) {
            throw new RacingCarException(ErrorMessage.CAR_NAME_NULL);
        }else if (name.isEmpty()) {
            throw new RacingCarException(ErrorMessage.CAR_NAME_EMPTY);
        }else if (name.isBlank()) {
            throw new RacingCarException(ErrorMessage.CAR_NAME_BLANK);
        }else if (name.length() > MAXIMUM_LENGTH) {
            throw new RacingCarException(ErrorMessage.CAR_NAME_TOO_LONG);
        }
    }
}
