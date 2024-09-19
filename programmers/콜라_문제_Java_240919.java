package programmers;

class 콜라_문제_Java_240919 {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= a) {
            int newCola = (n / a) * b; // a개의 빈병 → b개의 콜라
            answer += newCola;
            
            n = (n % a) + newCola; //남은거 : 교환 후 남은거 + 받은 콜라 병의 빈 병
        }
        
        return answer;
    }
}
