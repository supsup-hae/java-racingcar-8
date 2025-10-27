package racingcar.enums;

public enum Message {
    INIT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"),
    ATTEMPTS("시도할 횟수는 몇 회인가요?\n"),
    PROGRESS("실행 결과\n"),
    RESULT("최종 우승자 : "),
    ;

    private final String value;

    private Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
