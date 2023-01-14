import java.util.HashSet;
import java.util.Set;

public class AbsDistinct_230114 {
    public static void main(String[] args) {
        AbsDistinct_230114 a = new AbsDistinct_230114();
        int [] A = {-5, -3, -1, 0, 3, 6};
        System.out.println(a.solution(A));

    }

    
    public int solution(int[] A) {
        //N개의 숫자로 구성된 비어 있지 않은 배열 A가 제공됩니다. 
        //배열은 내림차순으로 정렬됩니다. 
        //이 배열 의 절대 고유 개수 는 배열 요소 중 고유 절대값의 개수입니다.
        int answer = 0;
		Set<Integer> set = new HashSet<Integer>();

        for(int i : A){
            set.add(Math.abs(i));
        }
        answer = set.size();

        return answer;
    }
}
