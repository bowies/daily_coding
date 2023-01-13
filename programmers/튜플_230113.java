package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class 튜플_230113 {
    public static void main(String[] args) {
        튜플_230113 t = new 튜플_230113();
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        System.out.println(Arrays.toString(t.solution(s)));
        System.out.println(Arrays.toString(t.bestSolution(s)));
    }

    
    public int[] bestSolution(String s) {
        Set<String> set = new HashSet<>();
        
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");

        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});

        int[] answer = new int[arr.length];
        
        int idx = 0;
        
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)){
                    answer[idx++] = Integer.parseInt(s2);
                    break;
                } 
            }
        }
        //set.add ㄷㄷ...
        //위처럼 break 까지 넣어주면 더 효율적
        //set이라서 어차피 중복 안되니까 이게 더 좋은 코드.

        return answer;
    }

    
    public int[] solution(String s) {
        //셀수있는 수량의 순서있는 열거 또는 어떤 순서를 따르는 요소들의 모음을 튜플(tuple)이라고 합니다. 
        //n개의 요소를 가진 튜플을 n-튜플(n-tuple)이라고 하며, 다음과 같이 표현할 수 있습니다.
        
        ArrayList <Integer> 튜플 = new ArrayList<>();
        String [] 배열 = s.split("},");

        for(int i = 0; i < 배열.length; i++){
            배열[i] = 배열[i].replace("{", "");
            배열[i] = 배열[i].replace("}", "");
            //System.out.println(배열[i]);
        }


        Arrays.sort(배열,new Comparator<String>(){
            public int compare(String 배열1, String 배열2){         
                //배열 길이대로 정렬해놓음       
                return Integer.compare(배열1.length(), 배열2.length());
            }
        });

        
        for(String str : 배열){
            //String -> int 해서 검색
            String [] temp = str.split(",");
            
            for(int i = 0 ; i < temp.length;i++){
                int n = Integer.parseInt(temp[i]);
                if(!튜플.contains(n)){
                    //튜플에 없으면 순차적으로 넣는다.
                    튜플.add(n);
                }
            }
        }

        //array로 바꿔서 전달해준다.
        int[] answer = 튜플.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}
