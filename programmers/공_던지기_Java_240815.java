package programmers;



class 공_던지기_Java_240815 {
    public int solution(int[] numbers, int k) {
        int start = 0; 
        int count = 1; // 던지기 횟수
        
        while (count < k) {
            start = (start + 2) % numbers.length;
            count++;
        }
        
        return numbers[start];
    }
}
