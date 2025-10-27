package racingcar.view.output;

public class ConsoleOutputView implements OutputView<String> {

    @Override
    public void print(String output) {
        System.out.print(output);
    }
}