package programmers;

class 소수_찾기_Java_230728 {
    /*
        1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

        소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
        (1은 소수가 아닙니다.)

        제한 조건
        n은 2이상 1000000이하의 자연수입니다.
        입출력 예
        n	result
        10	4
        5	3
        입출력 예 설명
        입출력 예 #1
        1부터 10 사이의 소수는 [2,3,5,7] 4개가 존재하므로 4를 반환

        입출력 예 #2
        1부터 5 사이의 소수는 [2,3,5] 3개가 존재하므로 3를 반환
     */
    public int solution(int n) {
        boolean[] isPrime = new boolean[n + 1];
        int count = 0;

        // 모든 수를 소수로 가정하고 초기화
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // 에라토스테네스의 체 알고리즘
        // 에라토스테네스의 체 알고리즘은 2부터 시작하여 배수들을 지워가면서 소수를 찾는 방법
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 소수 개수 세기
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }


    public int solution_최적화(int n) {
        //주어진 n 이하의 소수를 찾는데, 이때 n이 최대 1,000,000 이하의 자연수라는 조건이 있으므로, 약간의 최적화를 추가
        if (n < 2) {
            return 0; // 1보다 작거나 같은 수는 소수가 없음
        }

        boolean[] isPrime = new boolean[n + 1];
        int count = 0;

        // 모든 수를 소수로 가정하고 초기화
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // 최적화 1: n의 제곱근까지만 반복
        int sqrtN = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrtN; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 소수 개수 세기
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }
    /*
        이 최적화에서 sqrtN은 n의 제곱근을 나타냅니다.
        에라토스테네스의 체 알고리즘에서, n보다 큰 수 중 소수가 존재한다면
        그 소수는 n의 제곱근보다 큰 수로 나타날 수 없습니다.
        따라서 반복문을 i <= sqrtN까지만 돌리면 충분하며,
        이렇게 하면 시간 복잡도가 줄어들어 좀 더 최적화된 소수 찾기 메소드가 됩니다.
     */

}