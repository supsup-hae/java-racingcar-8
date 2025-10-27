package racingcar.factory;

import racingcar.controller.RacingCarController;
import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.parser.CarNameExtractor;
import racingcar.service.RacingCarService;
import racingcar.service.RacingCarServiceImpl;
import racingcar.view.input.ConsoleInputView;
import racingcar.view.input.InputView;
import racingcar.view.output.ConsoleOutputView;
import racingcar.view.output.OutputView;

public class RacingCarFactory {
    private RacingCarFactory() {
    }

    public static RacingCarController createController() {
        InputView<String> inputView = new ConsoleInputView();
        OutputView<String> outputView = new ConsoleOutputView();
        CarNameExtractor carNameExtractor = new CarNameExtractor();
        VehicleFactory<CarName, Car> carFactory = new CarFactory();
        RacingCarService service = new RacingCarServiceImpl(carNameExtractor, carFactory);
        return new RacingCarController(inputView, outputView, service);
    }
}
