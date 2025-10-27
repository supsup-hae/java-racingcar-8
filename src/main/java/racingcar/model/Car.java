package racingcar.model;

import racingcar.generator.NumberGenerator;
import racingcar.validator.CarValidator;

public class Car implements Vehicle {
    private static final int FORWARD_CONDITION = 4;
    public static final String PROGRESS_BAR = "-";
    private final CarName carName;
    private int position;

    private Car(CarName carName) {
        this.carName = carName;
        this.position = 0;
    }

    public static Car of(CarName carName) {
        Car car = new Car(carName);
        CarValidator.getInstance().validate(car);
        return new Car(carName);
    }

    private void forward() {
        this.position++;
    }

    public CarName getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public void move(NumberGenerator<Integer> numberGenerator) {
        int randomValue = numberGenerator.generate();
        if (randomValue >= FORWARD_CONDITION) {
            this.forward();
        }
    }

    @Override
    public String toString() {
        return this.carName.getName() + " : " + PROGRESS_BAR.repeat(this.position);
    }
}
