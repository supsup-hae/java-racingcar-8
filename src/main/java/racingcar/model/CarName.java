package racingcar.model;

import java.util.Objects;
import racingcar.parser.CarNameExtractor;
import racingcar.validator.CarNameValidator;

public final class CarName {
    private final String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName of(String name) {
        CarName carName = new CarName(name);
        CarNameValidator.getInstance().validate(carName);
        return carName;
    }

    public static CarNameExtractor ofExtractor() {
        return new CarNameExtractor();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CarName carName)) {
            return false;
        }
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public String getName() {
        return name;
    }
}
