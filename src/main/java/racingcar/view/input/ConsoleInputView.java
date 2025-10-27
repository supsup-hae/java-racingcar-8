package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView<String>{
    @Override
    public String read() {
        return Console.readLine();
    }
}
