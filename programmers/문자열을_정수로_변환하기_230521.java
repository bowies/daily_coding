package programmers;

class 문자열을_정수로_변환하기_230521 {
    public int solution(String n_str) {
        int answer = Integer.parseInt(n_str);
        return answer;
    }

    public int solution2(String n_str) {
        int answer = 0;
        int len = n_str.length();
        for(int i = 0; i < len; i++) {
            answer += (n_str.charAt(i) - '0') * Math.pow(10, len - i - 1);
        }
        return answer;
    }
}