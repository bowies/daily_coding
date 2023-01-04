package programmers;

import java.util.Arrays;

public class 전화번호목록_230104 {
    public static void main(String[] args) {
        String [] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);

        //예전에는 이중 for문도 안 걸리다가, 지금은 걸림!
        for (int i = 0; i < phone_book.length - 1; i++){        
            if (phone_book[i + 1].startsWith(phone_book[i])){
                return false;
            }
        }
        /* 
        //뒤쪽 값만 조사해도 sort 했으므로 효율성 괜찮음!
        for(int i = 0; i < phone_book.length; i++){
            for(int j = 0; j < phone_book.length; j++){
                if(phone_book[j].startsWith(phone_book[i]) && i != j){
                    return false;
                }
            }            
        }
        */

        return answer;
    }
}
