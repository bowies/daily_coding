package programmers;

class n의배수_230514 {
    public int solution(int num, int n) {
        int answer = 0;
        if (num%n == 0){
           answer = 1; 
        }
        return answer;
    }
}