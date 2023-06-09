package programmers;

class 점의_위치_구하기_230610 {
    public int solution(int[] dot) {
        int answer = 0;
        int xpointer = dot[0];
        int ypointer = dot[1];
        
        if(xpointer > 0){
            if(ypointer > 0){
                answer = 1;
            }else{
                answer = 4;
            }
        }else{
            if(ypointer > 0){
                answer = 2;
            }else{
                answer = 3;
            }
        }
        return answer;
    }

    public int solution2(int[] dot) {
        int xpointer = dot[0];
        int ypointer = dot[1];

        if (xpointer > 0 && ypointer > 0) {
            return 1;
        } else if (xpointer < 0 && ypointer > 0) {
            return 2;
        } else if (xpointer < 0 && ypointer < 0) {
            return 3;
        } else if (xpointer > 0 && ypointer < 0) {
            return 4;
        } else {
            return 0; // 점이 원점인 경우
        }
    }

    public int solution3(int [] dot){
        int x = dot[0];
        int y = dot[1];

        if (x > 0)
            return y > 0 ? 1 : 4;
        else
            return y > 0 ? 2 : 3;

    }
}