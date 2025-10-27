package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.generator.NumberGenerator;
import racingcar.validator.RacingCarsValidator;

public class RacingCars {
    private final List<Car> carList;

    private RacingCars(List<Car> carList) {
        this.carList = new ArrayList<>(carList);
    }

    public static RacingCars of(List<Car> carList) {
        RacingCars racingCars = new RacingCars(carList);
        RacingCarsValidator.getInstance().validate(racingCars);
        return racingCars;
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

    public void moveAll(NumberGenerator<Integer> numberGenerator) {
        carList.forEach(car -> car.move(numberGenerator));
    }

    public List<Car> getWinners() {
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

}
