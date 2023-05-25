package programmers;
import java.util.stream.IntStream;

class 나머지가_1이_되는_수_찾기_230525 {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 2; i <= 1000000; i++){
            if(n%i == 1){
                answer = i;
                break;
            }
        }
        return answer;
    }

    //그냥 return 해도 되는 것.

    public int solution2(int n) {
         return IntStream.rangeClosed(2, 1000000)
                .filter(answer -> n % answer == 1) 
                .findFirst() 
                .orElse(0); 
    }
}