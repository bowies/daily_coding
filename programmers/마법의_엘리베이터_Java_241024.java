package programmers;

class 마법의_엘리베이터_Java_241024 {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int remainder = storey % 10;  
            
            if (remainder > 5 || (remainder == 5 && (storey / 10) % 10 >= 5)) {
                // 5보다 크거나, 5인데 다음 자리수가 5 이상이면 올림
                answer += (10 - remainder);
                storey += 10 - remainder;  
            } else {
                // 내림
                answer += remainder;
            }
            
            storey /= 10;  
        }
        
        return answer;
    }
}
