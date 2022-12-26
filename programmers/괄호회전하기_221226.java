package programmers;

import java.util.Stack;

public class 괄호회전하기_221226 {
    public static void main(String[] args) {
        String s = "()(";
        System.out.println("ㅇㅅㅇ" + solution(s));
    }
    public static int solution(String s) {
        int answer = 0;

        for(int i = 0; i < s.length(); i++){
            System.out.println(i);
            answer = answer + bracelet(s.substring(i, s.length()) + s.substring(0, i));
        }

        return answer;
    }

    public static int bracelet(String temp){
        int answer = 1;
        char [] arr = temp.toCharArray();
        Stack <Character> stack = new Stack<>();
        int counter = 0;

        for(int i = 0; i < temp.length(); i++){
            switch(arr[i]){
                case '(':
                    counter--;
                    stack.add('(');
                    break;
                case '{':
                    counter--;
                    stack.add('{');
                    break;
                case '[':
                    counter--;
                    stack.add('[');
                    break;
                case ')':
                    counter++;
                    if(stack.isEmpty() == true){
                        return 0;
                    }else{
                        if(stack.peek() != '('){
                            return 0;
                        }else{
                            stack.pop();
                        }
                    }
                    break;
                case '}':
                    counter++;
                    if(stack.isEmpty() == true){
                        return 0;
                    }else{
                        if(stack.peek() != '{'){
                            return 0;
                        }else{
                            stack.pop();
                        }
                    }
                    break;
                case ']':
                    counter++;
                    if(stack.isEmpty() == true){
                        return 0;
                    }else{
                        if(stack.peek() != '['){
                            return 0;
                        }else{
                            stack.pop();
                        }
                    }
                    break;            
            }

        }
        if(counter < 0){
            return 0;
        }
        return answer;
    }
}
