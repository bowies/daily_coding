import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

public class FirstUnique_230126 {
    public static void main(String[] args) {
        System.out.println("sout + Ctrl + Space");
        System.out.println("so + tab");

        //생각보다 이거 실행하는데 속도가 느림...
        //파일명 바꾸기 - shift + f6

        int [] A = {4,10,5,4,2,10};
        //int [] A = {6,4,4,6};
        System.out.println(solution(A));

    }

    public static int solution(int [] A){

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : A) {
            int 임시값 = map.getOrDefault(i, 0);
            map.put(i, ++임시값);
        }

        for (int i : A) {
            if (map.get(i) == 1) {
                return i;
            }
        }
        return -1;
    }
    public static int solution2(int[] A) {
        int 정답 = -1;
        int 최대값 = Arrays.stream(A).max().getAsInt();
        int [] 임시배열 = new int[최대값+1];

        for(int i : A){
            임시배열[i]++;
        }

        /*
        OptionalInt 고유숫자확인 = Arrays.stream(임시배열).filter(s-> s==1).findAny();

        if(고유숫자확인 == OptionalInt.empty()){
            return 정답;
        }
        */

        for(int i = 0; i < A.length; i++){
            if(임시배열[A[i]] == 1){
                정답 = A[i];
                break;
            }
        }

        return 정답;
    }
}
