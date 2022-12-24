package codility;

import java.util.Stack;

public class Brackets_221224 {
    public static void main(String[] args) {
        //String S = "{[()()]}";
        String S = "";
        solution(S);
    }

    public static int solution(String S) {
        // Implement your solution here
        if(S.length() <= 0){
            return 1;
        }
        Stack<Character> stack = new Stack<>();
        
        char chr = S.charAt(0);
        if(chr == ')' || chr == ']' || chr == '}'){
            //시작이 잘못되었으면 종료
            return 0;
        }

        for(char c : S.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);;;
            }else{
                if(stack.empty()){
                    //비었으면 종료
                    return 0;
                }else{
                    chr = stack.pop();

                    if(c == ')' && chr != '('){
                        //System.out.println(c + " !!");
                        return 0;
                    }else if(c == ']' && chr != '['){
                        //System.out.println(c + " !!!");
                        return 0;
                    }else if(c == '}' && chr != '{'){
                        //System.out.println(c + " !!!!");
                        return 0;
                    }

                }


            }

        }

        return stack.isEmpty() ? 1 : 0;

    }

}
