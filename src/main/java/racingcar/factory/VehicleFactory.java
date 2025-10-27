package racingcar.factory;

public interface VehicleFactory<T,R> {
    R create(T t);
}
