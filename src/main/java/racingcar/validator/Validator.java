package racingcar.validator;

@FunctionalInterface
public interface Validator<T> {
    void validate(T t);
}
