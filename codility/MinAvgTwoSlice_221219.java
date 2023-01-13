public class MinAvgTwoSlice_221219 {
    public static void main(String[] args) {

        int [] A = {4,2,2,5,1,5,8};
        solution(A);

    }


    public static int solution(int[] A) {
        
        //전체 탐색을 할 필요 없이
        //3개 / 2개 만 비교하면 정답 확인 가능 (신비한 수학의 세계)
        //https://oh-sh-2134.tistory.com/19?category=884153 ← 여기 참조!
        //https://cheolhojung.github.io/posts/algorithm/Codility-MinAvgTwoSlice.html ← 여기도 참조!

        /*
         1. a <= b일 때, a와 b의 평균은 a 이상이 된다. 
         (a = b 일 때, a와 b의 평균은 a, 즉 두 수가 같은 경우는 a 혹은 b가 된다) 

         2. 마찬가지로, (a + b) <= (c + d)일 때, (a, b)와 (c, d)의 평균은 (a + b) 이상이 된다.

         3. 결국, 원소가 4개(a, b, c, d)인 그룹은 (a, b)와 (c, d)를 나누었을 때, 각각의 평균의 작은 값 이상이 된다
         (2개인 그룹이 작은 값이 되므로 4개의 그룹은 고려할 필요가 없어진다.)
         
         4. 예외로 원소가 3개인 그룹에서 2개인 그룹과 1개인 그룹의 경우를 확인해야 하지만, 
         문제에서 주어진 조건에 의하면 그룹의 원소는 최소 2개 이상이므로 2개와 3개인 그룹만 비교한다. 
         (최소 2개를 나눈 값으로 문제 풀이를 해야 하니까...)
          
         */
        
        
        //전체 탐색하면 시간 복잡도 굉장해짐... 
        //for >>> for <<< 이걸로 풀면 시간 복잡도 X!


        int answer = 0;

        double minValue = (A[0] + A[1]) / 2.0;
        double average = 0.0;

        for(int i = 2; i < A.length; i++){
            average = (A[i-2] + A[i-1] + A[i]) / 3.0;
            if(minValue > average){
                minValue = average;
                answer = i - 2 ;
            }

            average = (A[i-1] + A[i]) / 2.0;
            if(minValue > average){
                minValue = average;
                answer = i - 1;
            }
        }
        System.out.println(answer);


        return answer;
    }
}
