package programmers;
import java.util.Arrays;

class 컨트롤_제트_Java_240801 {
    public int solution(String s) {
        int answer = 0;

        String [] arr = s.split(" ");

        for(int i = 0; i < arr.length; i++){
            if(arr[i].equalsIgnoreCase("Z")){
                answer = answer - Integer.parseInt(arr[i-1]);
            }else{
                answer += Integer.parseInt(arr[i]);
            }
        }

        return answer;
    }


    public int solution_stream(String s) {
        int[] answer = {0};

        Arrays.stream(s.split(" ")).forEach(str -> {
            if (str.equalsIgnoreCase("Z")) {
                answer[0] -= answer[1];
            } else {
                answer[1] = Integer.parseInt(str);
                answer[0] += answer[1];
            }
        });

        return answer[0];
    }
}