package programmers;

class 특정한_문자를_대문자로_바꾸기_Java_230826 {
    /*
        영소문자로 이루어진 문자열 my_string과
        영소문자 1글자로 이루어진 문자열 alp가 매개변수로 주어질 때,
        my_string에서 alp에 해당하는 모든 글자를 대문자로 바꾼 문자열을 return 하는 solution 함수를 작성해 주세요.
     */
    public String solution(String my_string, String alp) {
        String answer = alp.toUpperCase();
        return my_string.replaceAll(alp, answer);
    }

    public String solution2(String my_string, String alp) {
        return my_string.replace(alp, alp.toUpperCase());
    }
    public String solution3(String my_string, String alp) {
        String answer = "";

        for (int i = 0; i < my_string.length(); i++) {
            if (my_string.charAt(i) == alp.charAt(0)) {
                answer += Character.toUpperCase(my_string.charAt(i));
            } else {
                answer += my_string.charAt(i);
            }
        }

        return answer;
    }
}