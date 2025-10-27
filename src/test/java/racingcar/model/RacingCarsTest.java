package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.generator.NumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingCars 테스트")
class RacingCarsTest {

    @ParameterizedTest
    @DisplayName("우승자 결정된다")
    @CsvSource({
            "5, 3, 2, 1",
            "5, 5, 2, 2",
            "4, 4, 4, 3",
            "0, 0, 0, 3"
    })
    void getWinners_ReturnsCorrectWinners(int pos1, int pos2, int pos3, int expectedCount) {
        // given
        Car car1 = createCarWithPosition("pobi", pos1);
        Car car2 = createCarWithPosition("crong", pos2);
        Car car3 = createCarWithPosition("honux", pos3);
        RacingCars racingCars = RacingCars.of(Arrays.asList(car1, car2, car3));

        // when
        List<Car> winners = racingCars.getWinners();

        // then
        assertThat(winners).hasSize(expectedCount);
    }

    @Test
    @DisplayName("조건을 만족하면 모든 자동차가 이동한다")
    void moveAll_AllCarsMoveWhenConditionsMet() {
        // given
        Car car1 = Car.of(CarName.of("pobi"));
        Car car2 = Car.of(CarName.of("crong"));
        RacingCars racingCars = RacingCars.of(Arrays.asList(car1, car2));
        NumberGenerator<Integer> alwaysMove = () -> 4;

        // when
        racingCars.moveAll(alwaysMove);

        // then
        assertThat(car1.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("조건을 만족하지 않으면 자동차가 정지한다")
    void moveAll_CarsStayWhenConditionsNotMet() {
        // given
        Car car1 = Car.of(CarName.of("pobi"));
        Car car2 = Car.of(CarName.of("crong"));
        RacingCars racingCars = RacingCars.of(Arrays.asList(car1, car2));
        NumberGenerator<Integer> neverMove = () -> 3;

        // when
        racingCars.moveAll(neverMove);

        // then
        assertThat(car1.getPosition()).isZero();
        assertThat(car2.getPosition()).isZero();
    }

    @Test
    @DisplayName("여러 라운드를 거치면 위치가 누적된다")
    void moveAll_MultipleRounds_PositionAccumulates() {
        // given
        Car car = Car.of(CarName.of("pobi"));
        RacingCars racingCars = RacingCars.of(Arrays.asList(car));
        NumberGenerator<Integer> alwaysMove = () -> 4;

        // when
        racingCars.moveAll(alwaysMove);
        racingCars.moveAll(alwaysMove);
        racingCars.moveAll(alwaysMove);

        // then
        assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    @DisplayName("getCarList는 방어적 복사본을 반환한다")
    void getCarList_ReturnsDefensiveCopy() {
        // given
        Car car = Car.of(CarName.of("pobi"));
        RacingCars racingCars = RacingCars.of(Arrays.asList(car));

        // when
        List<Car> carList1 = racingCars.getCarList();
        List<Car> carList2 = racingCars.getCarList();

        // then
        assertThat(carList1).isNotSameAs(carList2);
        assertThat(carList1).isEqualTo(carList2);
    }

    private Car createCarWithPosition(String name, int position) {
        Car car = Car.of(CarName.of(name));
        NumberGenerator<Integer> alwaysMove = () -> 4;
        for (int i = 0; i < position; i++) {
            car.move(alwaysMove);
        }
        return car;
    }
}