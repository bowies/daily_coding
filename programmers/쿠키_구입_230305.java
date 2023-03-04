package programmers;

public class 쿠키_구입_230305 {
    public static void main(String[] args) {
    /*
        과자바구니를 1번부터 N번까지 내놨음
        첫째아들 : l~m번 바구니
        둘째아들 : m+1 ~ r번 바구니
        를 사줄건데 과자 수가 같아야 한다.
        조건에 맞게 과자를 살 때, 한명의 아들에게 줄 수 있는 가장 많은 과자 수가 몇갠지 세보자.
        조건에 맞지 않으면 아예 안 삼
     */
        int [] 과자 = {1,1,2,3};
        System.out.println(solution(과자));
    }


    public static int solution(int[] cookie) {
        int answer = 0;

        //i가 중간값인 것으로 생각할 것.
        for(int i = 0; i < cookie.length - 1; i++){

            int 왼쪽 = i;
            int 오른쪽 = i + 1;
            int 왼쪽쿠키개수 = cookie[i];
            int 오른쪽쿠키개수 = cookie[i+1];

            while(true){
                //2번 과정
                if(왼쪽쿠키개수 == 오른쪽쿠키개수){
                    answer = Math.max(answer, 오른쪽쿠키개수);
                    if(++오른쪽 < cookie.length){
                        오른쪽쿠키개수 += cookie[오른쪽];
                    }else{
                        break;
                    }
                }
                else if(왼쪽쿠키개수 > 오른쪽쿠키개수){
                    if(++오른쪽 < cookie.length){
                        오른쪽쿠키개수 += cookie[오른쪽];
                    }else{
                        break;
                    }
                }
                else{
                    if(--왼쪽 >= 0){
                        왼쪽쿠키개수 += cookie[왼쪽];
                    }else{
                        break;
                    }
                }
            }
        }
        return answer;
    }

}

/*
//이렇게 푼 사람이 많다. ↓
class Solution {
    public int solution(int[] cookie) {
        int answer = -1;
        int max = 0;

        if(cookie.length < 2) return 0;
        if(cookie.length == 2) {
            if(cookie[0] == cookie[1]) return cookie[0];
            else return 0;
        }

        for(int i = 0; i < cookie.length - 1; i++) {

            int frontSum = cookie[i];
            int indexOfFrontSum = i;

            int backSum = cookie[i+1];
            int indexOfBackSum = i+1;

            while(true) {

                if(frontSum == backSum) max = Math.max(frontSum, max);

                if(indexOfFrontSum > 0 && frontSum <= backSum) {
                    indexOfFrontSum--;
                    frontSum += cookie[indexOfFrontSum];
                }

                else if(indexOfBackSum < cookie.length - 1 && frontSum >= backSum) {
                    indexOfBackSum++;
                    backSum += cookie[indexOfBackSum];
                }

                else break;
            }

        }

        answer = max;
        return answer;
    }
}

 */