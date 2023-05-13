package programmers;

class 양꼬치_230513 {
    public int solution(int n, int k) {
        int answer = 0;
        int 양꼬치 = 12000;
        int 음료수 = 2000;
        
        answer = 양꼬치*n + 음료수*(k - n/10) ;
        
        
        return answer;
    }
}