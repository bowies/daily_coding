package programmers;

import java.util.Stack;

class 다른_사람의_풀이_Java_240612 {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int [] answer = new int[len];
        Stack <Integer> stack = new Stack<>();
        
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}
