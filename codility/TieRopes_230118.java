class TieRopes_230118{
    public static void main(String[] args) {
        int K = 4;
        int [] A = {1,2,3,4,1,1,3};
        System.out.println(solution(K, A));
    }
    
    public static int solution(int K, int[] A) {
  
        int answer = 0;
        int length = 0;

        for (int i : A) {
            length += i;
            System.out.println(length + " ㅇㅅㅇ" + i);
            if (length >= K) {
                System.out.println("\t" + length + " ㅎㅅㅎ" + i);
                answer++;
                length = 0;
            }
        }
        return answer;

    }
}