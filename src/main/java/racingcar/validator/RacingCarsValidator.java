package racingcar.validator;

import java.util.List;
import racingcar.enums.ErrorMessage;
import racingcar.exception.RacingCarException;
import racingcar.model.Car;
import racingcar.model.RacingCars;

public class RacingCarsValidator implements Validator<RacingCars> {
    private static final RacingCarsValidator INSTANCE = new RacingCarsValidator();

    private RacingCarsValidator() {
    }

    public static RacingCarsValidator getInstance() {
        return INSTANCE;
    }


    @Override
    public void validate(RacingCars racingCars) {
        if (racingCars == null) {
            throw new RacingCarException(ErrorMessage.RACING_CARS_NULL);
        }

        List<Car> carList = racingCars.getCarList();

        if (carList == null) {
            throw new RacingCarException(ErrorMessage.RACING_CARS_NULL);
        }else if (carList.isEmpty()) {
            throw new RacingCarException(ErrorMessage.RACING_CARS_EMPTY);
        }else if (carList.contains(null)) {
            throw new RacingCarException(ErrorMessage.RACING_CARS_CONTAINS_NULL);
        }
    }
}
