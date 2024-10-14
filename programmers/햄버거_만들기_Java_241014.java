package programmers;

import java.util.Stack;

class 햄버거_만들기_Java_241014 {
    
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i : ingredient) {
            stack.push(i); // 스택에 재료를 쌓음
            
            // 스택의 마지막 4개가 [빵, 야채, 고기, 빵]인지 확인
            if (stack.size() >= 4) {
                int size = stack.size();
                if (stack.get(size - 4) == 1 && 
                    stack.get(size - 3) == 2 &&
                    stack.get(size - 2) == 3 &&
                    stack.get(size - 1) == 1) {
                    
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
