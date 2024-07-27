package programmers;
class 숨어있는_숫자의_덧셈_2_240726_Java {
    public int solution(String my_string) {
        int answer = 0;
        int current = 0;
        boolean flag = false;

        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);

            if (Character.isDigit(c)) {
                current = current * 10 + (c - '0');
                flag = true;
            } else {
                if (flag) {
                    answer += current;
                    current = 0;
                }
                flag = false;
            }
        }

        if (flag) {
            answer += current;
        }

        return answer;
    }
}
