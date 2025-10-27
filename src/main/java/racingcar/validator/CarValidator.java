package racingcar.validator;

import racingcar.enums.ErrorMessage;
import racingcar.exception.RacingCarException;
import racingcar.model.Car;

public class CarValidator implements Validator<Car> {
    private static final CarValidator INSTANCE = new CarValidator();

    private CarValidator() {
    }

    public static CarValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public void validate(Car car) {
        if (car == null) {
            throw new RacingCarException(ErrorMessage.CAR_NULL);
        }else if (car.getPosition() < 0) {
            throw new RacingCarException(ErrorMessage.CAR_POSITION_NEGATIVE);
        }
    }
}
