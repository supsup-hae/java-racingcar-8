package racingcar.enums;

public enum ErrorMessage {
    // CarName 관련 에러
    CAR_NAME_NULL("자동차 이름은 null일 수 없습니다."),
    CAR_NAME_EMPTY("자동차 이름은 빈 문자열일 수 없습니다."),
    CAR_NAME_BLANK("자동차 이름은 공백만으로 구성될 수 없습니다."),
    CAR_NAME_TOO_LONG("자동차 이름은 5자를 초과할 수 없습니다."),
    
    // 입력 관련 에러
    INPUT_NULL("입력값은 null일 수 없습니다."),
    INPUT_EMPTY("입력값은 빈 문자열일 수 없습니다."),
    INPUT_BLANK("입력값은 공백만으로 구성될 수 없습니다."),
    
    // 구분자 관련 에러
    INVALID_DELIMITER("쉼표(,)만 구분자로 사용할 수 있습니다."),
    CONSECUTIVE_COMMAS("연속된 쉼표는 사용할 수 없습니다."),
    STARTS_WITH_COMMA("입력값이 쉼표로 시작할 수 없습니다."),
    ENDS_WITH_COMMA("입력값이 쉼표로 끝날 수 없습니다."),
    
    // 시도 횟수 관련 에러
    ATTEMPTS_NOT_POSITIVE("시도 횟수는 양수여야 합니다."),
    ATTEMPTS_INVALID_FORMAT("시도 횟수는 숫자여야 합니다."),
    
    // Car 관련 에러
    CAR_NULL("자동차는 null일 수 없습니다."),
    CAR_POSITION_NEGATIVE("자동차 위치는 음수일 수 없습니다."),
    
    // RacingCars 관련 에러
    RACING_CARS_NULL("자동차 리스트는 null일 수 없습니다."),
    RACING_CARS_EMPTY("자동차 리스트는 비어있을 수 없습니다."),
    RACING_CARS_CONTAINS_NULL("자동차 리스트에 null이 포함될 수 없습니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
