package programmers;

class 문자_리스트를_문자열로_변환하기_Java_240205 {
    public String solution(String[] arr) {
        StringBuilder answer = new StringBuilder();

        for (String s : arr) {
            answer.append(s);
        }

        return answer.toString();
    }
}