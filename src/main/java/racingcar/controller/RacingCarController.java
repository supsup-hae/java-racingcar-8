package racingcar.controller;

import racingcar.enums.Message;
import racingcar.model.RacingCars;
import racingcar.service.RacingCarService;
import racingcar.validator.AttemptsValidator;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class RacingCarController implements Controller {

    public static final String LINE_BREAK = "\n";
    private final InputView<String> inputView;
    private final OutputView<String> outputView;
    private final RacingCarService racingCarService;

    public RacingCarController(InputView<String> inputView, OutputView<String> outputView,
                               RacingCarService racingCarService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
    }

    @Override
    public void run() {
        outputView.print(Message.INIT.getValue());
        String input = inputView.read();
        RacingCars racingCars = racingCarService.initGameInfo(input);

        outputView.print(Message.ATTEMPTS.getValue());
        int attempts = AttemptsValidator.getInstance().parseAndValidate(inputView.read());

        outputView.print(Message.PROGRESS.getValue());
        for (int i = 0; i < attempts; i++) {
            racingCarService.startStage(racingCars);
            racingCars.getCarList().forEach(car ->
                    outputView.print(car.toString() + LINE_BREAK)
            );
            outputView.print(LINE_BREAK);
        }

        String result = racingCarService.getWinnerResult(racingCars);
        outputView.print(Message.RESULT.getValue() + result);
    }
}
