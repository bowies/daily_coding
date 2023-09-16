package programmers;

import java.util.stream.Collectors;

class 대문자와_소문자_Java_230916 {
    /*
        문자열 my_string이 매개변수로 주어질 때,
        대문자는 소문자로 소문자는 대문자로 변환한 문자열을 return하도록 solution 함수를 완성해주세요.
     */
    public String solution(String my_string) {
        String answer = "";

        for(int i = 0; i < my_string.length(); i++) {
            char temp = my_string.charAt(i);
            if(temp >= 'a' && temp <= 'z') {
                answer += (char)(temp - 32);
            } else if(temp >= 'A' && temp <= 'Z') {
                answer += (char)(temp + 32);
            } else {
                answer += temp;
            }
        }
        return answer;
    }
    public String solution2(String my_string) {
        StringBuilder answerBuilder = new StringBuilder(my_string.length());

        for (int i = 0; i < my_string.length(); i++) {
            char temp = my_string.charAt(i);

            if (Character.isLowerCase(temp)) {
                answerBuilder.append(Character.toUpperCase(temp));
            } else if (Character.isUpperCase(temp)) {
                answerBuilder.append(Character.toLowerCase(temp));
            } else {
                answerBuilder.append(temp);
            }
        }

        return answerBuilder.toString();
    }


    public String solution_stream(String myString) {
        // 1. 문자열을 문자(int) 스트림으로 변환합니다.
        //    각 문자에 대한 유니코드 코드 포인트 값을 갖게 됩니다.
        return myString.chars()
                // 2. 각 코드 포인트를 문자로 다시 변환하고,
                //    해당 문자가 소문자인 경우 대문자로 변환하거나 대문자인 경우 소문자로 변환합니다.
                .mapToObj(operand -> String.valueOf((char) (Character.isLowerCase(operand) ? Character.toUpperCase(operand) : Character.toLowerCase(operand))))
                // 3. 스트림의 각 문자열 요소를 하나의 문자열로 결합합니다.
                //    Collectors.joining()은 스트림의 요소를 연결하여 하나의 문자열로 만들어줍니다.
                .collect(Collectors.joining());
    }

}