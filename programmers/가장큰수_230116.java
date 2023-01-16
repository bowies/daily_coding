package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수_230116 {
    public static void main(String[] args) {
        //int [] numbers = {6, 10, 2};
        int [] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }

    
    public static String solution(int[] numbers) {
        StringBuffer answer = new StringBuffer();

        String [] arr = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }

        //Arrays.sort(arr, Comparator.reverseOrder()); //이거 안됨! - Integer로 교환하지 말고 String으로만 풀어도 됨
        
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                //System.out.println("ㅇㅅㅇ " + str2+str1 + "ㅎㅅㅎ" + str1+str2); //둘 중에 더 큰거로 정렬
                return (str2+str1).compareTo(str1+str2);
                
            }
        });
        
       for(String str : arr){
            System.out.println(str);
       }

        if(arr[0].equals("0")){
            //처음이 0이면 0
            return "0";
        }else{
            for(String str : arr){
                answer.append(str);
            }
        }
  

        return answer.toString();
    }
}
