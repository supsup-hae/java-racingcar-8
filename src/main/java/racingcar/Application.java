package racingcar;

import racingcar.controller.Controller;
import racingcar.factory.RacingCarFactory;

public class Application {
    public static void main(String[] args) {
        Controller controller = RacingCarFactory.createController();
        controller.run();
    }
}
