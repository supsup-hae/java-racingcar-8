package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.generator.NumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("")
class CarTest {

    @Test
    @DisplayName("Car의 초기 위치는 0")
    void createCar_InitialPosition_IsZero() {
        // given
        CarName name = CarName.of("pobi");

        // when
        Car car = Car.of(name);

        // then
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("자동차 이름을 조회 가능")
    void getName_ReturnsCarName() {
        // given
        CarName name = CarName.of("pobi");
        Car car = Car.of(name);

        // when
        CarName carName = car.getCarName();

        // then
        assertThat(carName.getName()).isEqualTo("pobi");
    }

    @ParameterizedTest
    @DisplayName("조건을 만족하면 (4 이상) 자동차의 위치가 증가한다")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void move_WhenConditionMet_PositionIncreases(int randomValue) {
        // given
        CarName name = CarName.of("pobi");
        Car car = Car.of(name);
        NumberGenerator<Integer> generator = () -> randomValue;

        // when
        car.move(generator);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("조건을 만족하지 않으면 (4 미만) 자동차의 위치가 유지된다")
    @ValueSource(ints = {0, 1, 2, 3})
    void move_WhenConditionNotMet_PositionStays(int randomValue) {
        // given
        CarName name = CarName.of("pobi");
        Car car = Car.of(name);
        NumberGenerator<Integer> generator = () -> randomValue;

        // when
        car.move(generator);

        // then
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("여러 번 이동하면 위치가 누적된다")
    void move_MultipleTimes_PositionAccumulates() {
        // given
        CarName name = CarName.of("pobi");
        Car car = Car.of(name);
        NumberGenerator<Integer> alwaysMove = () -> 4;

        // when
        car.move(alwaysMove);
        car.move(alwaysMove);
        car.move(alwaysMove);

        // then
        assertThat(car.getPosition()).isEqualTo(3);
    }
}