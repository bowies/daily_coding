package programmers;

class _3진법_뒤집기_Java_240827 {

    
    public int solution_best(int n) {
        String answer = "";

        while(n > 0){
            answer = (n % 3) + answer;
            n /= 3;
        }
        answer = new StringBuilder(answer).reverse().toString();


        return Integer.parseInt(answer,3); //진법 변환!
    }


    public int solution(int n) {
        StringBuilder _3진법_ = new StringBuilder();
        while (n > 0) {
            _3진법_.append(n % 3);
            n /= 3;
        }
        
        int answer = 0;
        int _10진법으로돌리기_ = 1;
        
        for (int i = _3진법_.length() - 1; i >= 0; i--) {
            answer += (_3진법_.charAt(i) - '0') * _10진법으로돌리기_;
            /*
                첫 번째 자리(0)의 값: 0 * 3^0 = 0
                두 번째 자리(1)의 값: 1 * 3^1 = 3
                세 번째 자리(2)의 값: 2 * 3^2 = 18
            */
            _10진법으로돌리기_ *= 3;
        }
        
        return answer;
    }
}
