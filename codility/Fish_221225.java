import java.util.Stack;

public class Fish_221225 {
    /*
     
     */
    public static void main(String[] args) {
        int [] A = {4,3,2,1,5};
        int [] B = {0,1,0,0,0};

        /*
         * 4 : 살아남음
         * 3 : 아직 살아있음
         * 2 : 3을 만나서 몰살
         * 1 : 3을 만나서 몰살
         * 5 : 3은 5를 만나서 몰살 
         * -> 이게 물고기 마리 수가 아니라 살아남은 개수만 세면 되는 게 포인트였음
         */

        int ans = solution(A, B);
        System.out.println(ans);
    }
    public static int solution(int[] A, int[] B) {
        int answer = 0;
        //0 : 상류로 가는 것
        //1 : 하류로 가는 것

        Stack <Integer> stack = new Stack<>();
        int temp = 0;
        int fishCount = 0;

        for(int i = 0; i < A.length; i++){
            if(B[i] == 1){
                //1이 적으니까 밑으로 가는 애만 저장한다.
                //System.out.println("물고기 저장" + A[i]);
                stack.push(A[i]); //물고기 밑으로 가는 애 저장
            }else{
                while(stack.size() != 0){
                    temp = stack.peek();
                    if(temp > A[i]){
                        //크면 통과
                        //System.out.println("크니까 통과" + A[i]);
                        break;
                    }else{
                        //작으면 꺼냄
                        //System.out.println("작으니까 꺼냄"); //마리수가 아님!
                        stack.pop();
                    }
                }
                if(stack.isEmpty()){
                    fishCount++;
                }
                
            }

        }
        answer = fishCount + stack.size();
        return answer;
    }
}
