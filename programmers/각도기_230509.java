package programmers;

public class 각도기_230509 {

    public int solution(int angle) {
        int answer = 0;
       if(angle == 90){
           answer = 2;
       }else if(angle < 90){
           answer = 1;
       }else if(angle == 180){
           answer = 4;
       }else{
           answer = 3;
       }
        return answer;
    }


    public int sol2(int angle){
        return angle == 180 ? 4 : angle < 90 ? 1 : angle == 90 ? 2 : angle > 90 ? 3 : 0;
    }
}