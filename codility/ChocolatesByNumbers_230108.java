public class ChocolatesByNumbers_230108 {
    public static void main(String[] args) {
        ChocolatesByNumbers_230108 c = new ChocolatesByNumbers_230108();
        int N = 10;
        int M = 4;
        System.out.println(c.solution(N, M));

    }
    

    public int solution(int N, int M) {
        //유클리드 호제법을 이용해서 푼다.
        //N~M까지 최대 공약수를 구한 뒤에
        //N을 최대공약수로 나누면 초콜릿 개수가 반환된다
        return N / gcd(M, N);      
    }
      
      
      private int gcd(int n1, int n2) {
        if (n1 % n2 == 0) {
          return n2;
        } else {
          return gcd(n2, n1 % n2);
        }
      }

}
