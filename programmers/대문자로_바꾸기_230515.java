package programmers;

import java.util.Locale;

class 대문자로_바꾸기_230515 {
    public String solution(String myString) {
        String answer = myString.toUpperCase(Locale.ROOT);
        //myString.toUpperCase();
        return answer;
    }

    //`myString.toUpperCase(Locale.ROOT)`과 `myString.toUpperCase()`은
    // 둘 다 문자열을 대문자로 변환하는 데 사용되는 Java String 메서드이다.
    //하지만 `myString.toUpperCase(Locale.ROOT)`은 로케일을 명시 적으로 지정하여 대문자 변환이 수행되는 것을 보장한다.
    // 대문자 변환은 지역에 따라 다르게 처리될 수 있으므로 예기치 않은 결과가 발생할 수 있다.
    // 이를 방지하기 위해 `toUpperCase(Locale.ROOT)` 메서드는 항상 표준 로케일을 사용한다.
    //반면, `myString.toUpperCase()` 메서드는 로케일을 지정하지 않고 기본 로케일을 사용하여 대문자 변환을 수행한다.
    // 이 경우에는 기본 로케일이 올바른 로케일인 경우에는 상관없지만,
    // 로케일에 따라 다르게 처리될 수 있으므로 `toUpperCase(Locale.ROOT)` 메서드를 사용하는 것이 더 안전하다.
}