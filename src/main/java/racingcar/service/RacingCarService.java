package racingcar.service;

import racingcar.model.RacingCars;

public interface RacingCarService {
    RacingCars initGameInfo(String input);

    void startStage(RacingCars racingCars);

    String getWinnerResult(RacingCars racingCars);
}
