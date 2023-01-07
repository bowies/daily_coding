package programmers;

import java.util.ArrayList;

public class 뉴스클러스터링_230107 {
    public static void main(String[] args) {
        뉴스클러스터링_230107 nws = new 뉴스클러스터링_230107();
        
        String str1 = "FRANCE";
        String str2 = "french";
        System.out.println(nws.solution(str1, str2));
    }

    
    public int solution(String str1, String str2) {
        int answer = 0;

        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        
        ArrayList<String> 교집합 = new ArrayList<>();
        ArrayList<String> 합집합 = new ArrayList<>();

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase(); //둘다 대문자로 바꿈

        for(int i = 0; i<str1.length()-1;i++){
            
            char first = str1.charAt(i);
            char second = str1.charAt(i+1);
            if(first >='A' && first <='Z' && second >='A' && second <='Z'){
                arr1.add(first +""+second);
            }
        }

        for(int i = 0; i<str2.length()-1;i++){
            char first = str2.charAt(i);
            char second = str2.charAt(i+1);
            if(first >='A' && first <='Z' && second >='A' && second <='Z'){
                arr2.add(first +""+second);
            }
        }

        //문자열 길이가 다른 경우 때문에  한번에 그거 하면 안됨 ㅠ

        for(String s : arr1){
            if(arr2.remove(s)){
                교집합.add(s);
            }
            합집합.add(s);
        }

        합집합.addAll(arr2);

        double 교집합길이 = 교집합.size();
        double 합집합길이 = 합집합.size();

        if(합집합길이 == 0){
            return 65536;
        }
        answer = (int)(교집합길이/합집합길이* 65536) ;

        return answer;
    }
}
