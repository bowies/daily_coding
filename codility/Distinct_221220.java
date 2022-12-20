package codility;

import java.util.Arrays;

public class Distinct_221220 {

    /*
    함수 작성

    class Solution { public int solution(int[] A); }

    N개의 정수로 구성된 배열 A가 주어지면 배열 A의 개별 값 수를 반환합니다.

    예를 들어 다음과 같은 6개의 요소로 구성된 배열 A가 있다고 가정합니다.

    A[0] = 2 A[1] = 1 A[2] = 1
    A[3] = 2 A[4] = 3 A[5] = 1
    함수는 3을 반환해야 합니다. 배열 A에 3개의 고유한 값, 즉 1, 2 및 3이 나타나기 때문입니다.

    다음 가정에 대한 효율적인 알고리즘을 작성 하십시오.

    N은 [ 0 .. 100,000 ] 범위 내의 정수 이고;
    배열 A의 각 요소는 [ −1,000,000 .. 1,000,000 ] 범위 내의 정수 입니다.
    Codility Limited의 저작권 2009–2022. 판권 소유. 무단 복사, 출판 또는 공개를 금지합니다.

     */
    public static void main(String[] args) {
        int [] A = {2,1,1,2,3,1};
    }
    public static int solution(int[] A) {
        //이건 그냥 stream 쓰면 되는 것 같은데...?
        //문제 읽고 20초만에 품

        int [] answer = Arrays.stream(A).distinct().toArray();

        return answer.length;
    }


}
