import java.util.Arrays;

class 최댓값_만들기_1_230531 {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        answer = numbers[numbers.length-2]*numbers[numbers.length-1]; 
        return answer;
    }

}