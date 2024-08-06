package programmers;

class 약수의_개수와_덧셈_Java_240803 {


    public int solution_good(int left, int right) {
        int answer = 0;

        for (int i=left;i<=right;i++) {
            //제곱수인 경우 약수의 개수가 홀수
            if (i % Math.sqrt(i) == 0) {
                answer -= i;
            }
            //제곱수가 아닌 경우 약수의 개수가 짝수
            else {
                answer += i;
            }
        }

        return answer;
    }



    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            if (divisors(i) % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }

    private int divisors(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (i != n / i) {
                    count++;
                }
            }
        }
        return count;
    }

}