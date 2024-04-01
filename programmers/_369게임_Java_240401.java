package programmers;

class _369게임_Java_240401 {
    public int solution(int order) {
        int answer = 0;
        String ord = String.valueOf(order);

        for (int i = 0; i < ord.length(); i++) {
            char chr = ord.charAt(i);
            if (chr == '3' || chr == '6' || chr == '9') {
                answer++;
            }
        }
        return answer;
    }
}
