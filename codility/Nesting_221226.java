package codility;

import java.util.Stack;

public class Nesting_221226 {
    public static void main(String[] args) {
        String S = "()";
        solution(S);
        System.out.println();

    }

    public static int solution(String S) {
        Stack <Character> stack = new Stack<>();
        char [] arr = S.toCharArray();

        for(int i = 0; i < S.length(); i++){
            if(arr[i] == '('){
                stack.add('(');
            }else if(stack.size() == 0 || stack.pop() == arr[i]){
                return 0;
            }
        }

        int answer = 1;
        if(stack.size() > 0){
            answer = 0;
        }
        return answer;
    }
}
