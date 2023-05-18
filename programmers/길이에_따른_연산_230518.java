import java.util.Arrays;

class 길이에_따른_연산_230518 {
    public int solution(int[] num_list) {
        int answer = 0;
        
        if (num_list.length >= 11) {
            answer = Arrays.stream(num_list).sum();
        } else {
            answer = Arrays.stream(num_list).reduce(1, (a, b) -> a * b);
        }
        
        return answer;
    }
    
    
    public int solution2(int[] num_list) {
        int answer = (num_list.length >= 11) ? Arrays.stream(num_list).sum() : Arrays.stream(num_list).reduce(1, (a, b) -> a * b);
        return answer;
    }
}
