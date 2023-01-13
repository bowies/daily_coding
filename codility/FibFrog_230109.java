public class FibFrog_230109 {
    public static void main(String[] args) {
        FibFrog_230109 f = new FibFrog_230109();
        int [] A = {0,0,0,1,1,0,1,0,0,0,0};
        System.out.println(f.solution(A));
    }   
    
    
    public int solution(int[] A) {

        //1이 발판이라고 생각하면 됨
        //N을 찾아야 하는데 -1에서 시작하고, 1이 나오면 밟아지면 됨

        int len = A.length;

        int[] fibonacci = new int[len+2];
        fibonacci[0] = 1;
        fibonacci[1] = 2;

        //피보나치 수열을 미리 계산해놔야 함
        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];            
            if (fibonacci[i] == len+1){
                return 1;
            }
        }

        int[] arr = new int[len+1];
        //-1부터 시작하라니까...
        for (int i = -1; i <= len; i++) {
            //현재가 -1이거나, 밟아지는 곳일때 try
            if (i == -1 || arr[i] > 0) {
                //현재 위치에서 닿는 전체 발판들 표시
                for (int j = 0; (i + fibonacci[j]) <= len; j++) {
                    //점프한다니까 체크함
                    int jump = i + fibonacci[j];

                    if (jump == len+1 - 1 || A[jump] == 1) {
                        //현재가 맨 처음이면, 1번만에 이동 가능
                        if (i == -1){
                            arr[jump] = 1;
                        }else if (arr[jump] <= 0){
                            //발판이 아니면 arr[i] + 1 시켜줌
                            arr[jump] = arr[i] + 1;
                        }else{
                            //System.out.println(arr[jump] + "ㅇㅅㅇ " + arr[i]+1);
                            arr[jump] = Math.min(arr[jump], arr[i] + 1);
                        } 
                    }
                }
            }
        }

        /*
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println(arr.length);
        */
        return arr[len] <= 0 ? -1 : arr[len];
    }
}
