package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("CarName 테스트")
class CarNameTest {

    @Test
    @DisplayName("같은 이름을 가진 CarName은 같은 객체이다")
    void equals_SameName_ReturnsTrue() {
        // given
        CarName name1 = CarName.of("pobi");
        CarName name2 = CarName.of("pobi");

        // when & then
        assertThat(name1).isEqualTo(name2);
    }

    @Test
    @DisplayName("다른 이름을 가진 CarName은 다른 개체이다.")
    void equals_DifferentName_ReturnsFalse() {
        // given
        CarName name1 = CarName.of("pobi");
        CarName name2 = CarName.of("crong");

        // when & then
        assertThat(name1).isNotEqualTo(name2);
    }

    @Test
    @DisplayName("같은 이름을 가진 CarName은 같은 hashCode를 반환한다")
    void hashCode_SameName_ReturnsSameHashCode() {
        // given
        CarName name1 = CarName.of("pobi");
        CarName name2 = CarName.of("pobi");

        // when & then
        assertThat(name1.hashCode()).hasSameHashCodeAs(name2.hashCode());
    }

    @Test
    @DisplayName("CarName의 값을 조회할 수 있다")
    void getValue_ReturnsName() {
        // given
        CarName name = CarName.of("pobi");

        // when
        String value = name.getName();

        // then
        assertThat(value).isEqualTo("pobi");
    }

    @Test
    @DisplayName("CarName은 불변 객체다 - 값 조회 후에도 원본과 동일하다")
    void carName_IsImmutable() {
        // given
        String originalName = "pobi";
        CarName name = CarName.of(originalName);

        // when
        String referencedName = name.getName();

        // then
        assertThat(referencedName).isEqualTo(originalName);
    }
}
