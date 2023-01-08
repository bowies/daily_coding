package programmers;

public class 배열자르기_230108 {
    public static void main(String[] args) {
        int n = 3;
        long left = 2;
        long right = 5;
        solution(n, left, right);
    }

    
    public static int[] solution(int n, long left, long right) {
        
        int [] answer = new int[(int) (right-left+1)];

        /*
         * 00 01 02     1 2 3       
         * 10 11 12     2 2 3       1 2 3 2 2 3 3 3 3       02 10 11 12 -> 3  2 2  3
         * 20 21 22     3 3 3       
         */
  
        
        int [] ans = new int[2];
        for(int i = 0; i < answer.length; i++){
            ans[0] = (int)((i + left) / n) + 1; // row용
            ans[1] = (int)((i + left) % n) + 1; // col용
            //overflow가 나니까 필요한 값만 오려서 계산해야 한다.
            answer[i] = Math.max(ans[0], ans[1]);
            //System.out.println(answer[i] + "ㅇㅅㅇ" + ans[0] + "ㅇㅅㅇ" + ans[1]);
            /*
                2ㅇㅅㅇ0ㅇㅅㅇ2
                1ㅇㅅㅇ1ㅇㅅㅇ0
                1ㅇㅅㅇ1ㅇㅅㅇ1
                2ㅇㅅㅇ1ㅇㅅㅇ2
                에다가 +1 더하면 3 2 2 3 도출 가능-> Math.max 써서 해결함 
                left 쓰는 것이 포인트이다.
             * 
             */
        }
        

        return answer;

        /*
        int [] test = LongStream.rangeClosed(0, n*n-1).mapToInt(i -> (int) (Math.max(i / n, i % n) + 1)).toArray();
        for(int i : test){
            System.out.print(i + " ");
            //1 2 3 2 2 3 3 3 3 
            //전체를 다 만들어줌
        }
        System.out.println();
        int [] test1 = LongStream.rangeClosed(left, right).mapToInt(i -> (int) (Math.max(i / n, i % n) + 1)).toArray();

        for(int i : test1){
            System.out.print(i + " ");
            //3 2 2 3
        }

        return LongStream.rangeClosed(left, right).mapToInt(value -> (int) (Math.max(value / n, value % n) + 1)).toArray();
        //답안 중에 대단한 것이 있어서 공부하려고 가져옴...
        //intstream 대신 longstream을 써서 rangeclosed 함수를 사용함 -> 인자값 생성해 주는 것
        //그러고 나서는 mapToInt 써서 Math.max(value / n, value % n) + 1)
        //stream 써서 한줄로 짠 것 respect...★
        */
    }

}
