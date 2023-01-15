public class CountDistinctSlices_230115 {
    public static void main(String[] args) {
        CountDistinctSlices_230115 c = new CountDistinctSlices_230115();
        int M = 6;
        int [] A = {3,4,5,5,2};

        System.out.println(c.solution(M, A));
    }

    
    public int solution(int M, int[] A) {
        int answer = 0;
        //정수 M과 음이 아닌 정수 N개로 구성된 A
        int N = A.length;
        //A의 모든 정수는 M보다 작거나 같다.
        //중복되는 숫자가 없는 자른 도막을 찾으면 됨

        //그러니까 잘라서 같은 값이 있는지 확인하고...
        //같은 값이 존재하면, <<<가 >>>를 만나기 전까지는 false로 바꿔주고, 다시 true로 해가면 됨
        

        boolean [] 확인용 = new boolean [M+1];
        int 왼쪽 = 0;
        int 오른쪽 = 0;
        
        while(왼쪽 < N && 오른쪽 < N){
            if(확인용[A[오른쪽]] == true){
                //확인용[A[오른쪽]]가 true면 현재 있는 애니까
                //왼쪽 값이 오른쪽이랑 같을때까지 다른애들을 false 화 해줌
                //System.out.println(확인용[A[왼쪽]] +"ㅇㅅㅇ" + 왼쪽);
                
                확인용[A[왼쪽]] = false;
                왼쪽++;
            }else{
                //하나만 있을때는 최종 값을 true로 바꾸고, answer + 1해준다음에 오른쪽을 넘겨줌
                //System.out.println("ㅎㅅㅎ" + 오른쪽);

                확인용[A[오른쪽]] = true;
                answer = answer + (오른쪽 - 왼쪽 + 1);
                오른쪽++;
            }

            if(answer > 1000000000){
                return 1000000000;
            }
        }


        return answer;
    }
}
