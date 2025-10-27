package racingcar.model;

import racingcar.generator.NumberGenerator;

public interface Vehicle {
    void move(NumberGenerator<Integer> numberGenerator);
}
