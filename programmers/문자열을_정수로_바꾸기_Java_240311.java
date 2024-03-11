package programmers;

class 문자열을_정수로_바꾸기_Java_240311 {
    public int solution(String s) {
        int 부호 = 1;
        int answer = 0;
        
        // 문자열의 첫 번째 문자가 부호인 경우 처리
        if (s.charAt(0) == '-') {
            부호 = -1;
        } else if (s.charAt(0) == '+') {
            // '+'는 양수 부호이므로 별도의 처리 필요 없음
        } else {
            // 부호가 없는 경우, 문자열의 첫 번째부터 숫자로 변환 시작
            answer = s.charAt(0) - '0';
        }
        
        for (int i = 1; i < s.length(); i++) {
            // 문자열의 부호 이후부터 숫자로 변환하여 결과에 더해줌
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                // 현재 문자가 숫자인 경우, 결과에 10을 곱하고 현재 숫자를 더함
                answer = answer * 10 + (c - '0');
            }
        }
        
        // 부호를 곱하여 최종 결과 반환
        return 부호 * answer;
    }
}
