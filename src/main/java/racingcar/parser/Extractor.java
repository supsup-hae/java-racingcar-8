package racingcar.parser;

@FunctionalInterface
public interface Extractor<T, R> {
    R extract(T t);
}
