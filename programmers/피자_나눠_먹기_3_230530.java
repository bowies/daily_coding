package programmers;

class 피자_나눠_먹기_3_230530 {
 
    public int solution(int slice, int n) {
        int answer = 0;
        if(n%slice==0){
            answer = n/slice;
        }else{
            answer = n/slice+1;
        }
        return answer;
    }
     
    public int solution_upgrade(int slice, int n) {
        return (int) Math.ceil((double) n / slice);
        //나눗셈 대신 올림 함수를 사용할 수 있다.
        //n을 slice로 나눌 때, 나머지가 있는 경우 하나를 더 추가로 먹어야 한다.
        //이를 계산하기 위해 n/slice+1을 사용하고 있었는데, 
        //사실 Math.ceil 메서드를 사용하여 올림 하면 된다.
    }
    
}
