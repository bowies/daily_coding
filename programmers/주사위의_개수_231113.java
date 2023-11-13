package programmers;


import java.util.Arrays;

public class 주사위의_개수_231113 {
    
    public int solution(int[] box, int n) {
        
        int answer = 0;
        int 가로 = box[0]/n;
        int 세로 = box[1]/n;
        int 높이 = box[2]/n;
        
        answer = 가로*세로*높이;
        // answer = (box[0] / n) * (box[1] / n) * (box[2] / n); 
        // 이것과 같음

        return answer;
    }


}
