package programmers;

class  PCCE_기출문제_9번_지폐_접기_Java_241003 {

    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        // 지폐가 지갑에 들어갈 때까지 반복
        while ((bill[0] > wallet[0] || bill[1] > wallet[1]) && (bill[1] > wallet[0] || bill[0] > wallet[1])) {
            // 지폐의 긴 쪽을 반으로 접는다
            if (bill[0] > bill[1]) {
                bill[0] /= 2;  // 긴 쪽을 반으로 접음
            } else {
                bill[1] /= 2;  // 긴 쪽을 반으로 접음
            }
            answer++;  // 접을 때마다 횟수 증가
        }


        return answer;
    }
}