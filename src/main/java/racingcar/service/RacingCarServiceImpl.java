package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.factory.VehicleFactory;
import racingcar.generator.NumberGenerator;
import racingcar.generator.RandomNumberGenerator;
import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.model.RacingCars;
import racingcar.parser.CarNameExtractor;

public class RacingCarServiceImpl implements RacingCarService {
    public static final String OUTPUT_DELIMITER = ", ";
    private final CarNameExtractor carNameExtractor;
    private final VehicleFactory<CarName, Car> carFactory;
    private final NumberGenerator<Integer> numberGenerator;

    public RacingCarServiceImpl(CarNameExtractor carNameExtractor, 
                                VehicleFactory<CarName, Car> carFactory) {
        this.carNameExtractor = carNameExtractor;
        this.carFactory = carFactory;
        this.numberGenerator = new RandomNumberGenerator();  // 한 번만 생성
    }

    @Override
    public RacingCars initGameInfo(String input) {
        List<String> carNames = carNameExtractor.extract(input);

        List<Car> cars = carNames.stream()
                .map(CarName::of)
                .map(carFactory::create)
                .toList();

        return RacingCars.of(cars);
    }

    @Override
    public void startStage(RacingCars racingCars) {
        racingCars.moveAll(numberGenerator);
    }

    @Override
    public String getWinnerResult(RacingCars racingCars) {
        List<Car> winners = racingCars.getWinners();
        return winners.stream()
                .map(car -> car.getCarName().getName())
                .collect(Collectors.joining(OUTPUT_DELIMITER));
    }
}
