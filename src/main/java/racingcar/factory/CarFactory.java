package racingcar.factory;

import racingcar.model.Car;
import racingcar.model.CarName;

public class CarFactory implements VehicleFactory<CarName, Car> {

    @Override
    public Car create(CarName carName) {
        return Car.of(carName);
    }

}
