package programmers;

class k의_개수_Java_230801 {
    /*
    문제 설명
        1부터 13까지의 수에서, 1은 1, 10, 11, 12, 13 이렇게 총 6번 등장합니다.
        정수 i, j, k가 매개변수로 주어질 때, i부터 j까지 k가 몇 번 등장하는지 return 하도록 solution 함수를 완성해주세요.

    제한사항
        1 ≤ i < j ≤ 100,000
        0 ≤ k ≤ 9

    입출력 예
        i	j	k	result
        1	13	1	6
        10	50	5	5
        3	10	2	0

    입출력 예 설명
        입출력 예 #1
            본문과 동일합니다.
        입출력 예 #2
            10부터 50까지 5는 15, 25, 35, 45, 50 총 5번 등장합니다. 따라서 5를 return 합니다.
        입출력 예 #3
            3부터 10까지 2는 한 번도 등장하지 않으므로 0을 return 합니다.

     */

    // 첫 번째 솔루션: 문자열로 변환하여 문자를 접근하는 방법
    public int solution(int i, int j, int k) {
        int answer = 0;

        for (int n = i; n <= j; n++) {
            // 숫자를 문자열로 변환
            String temp = String.valueOf(n);

            // 문자열의 각 자릿수를 순회하며 k와 일치하는지 확인
            for (int m = 0; m < temp.length(); m++) {
                if (temp.charAt(m) == k + '0') {
                    answer++;
                }
            }
        }

        return answer;
    }

    // 두 번째 솔루션: 수학적 연산으로 각 자릿수를 추출하여 k와 일치하는지 확인
    public int solution2(int i, int j, int k) {
        int answer = 0;

        while (i <= j) {
            int n = i;
            while (n > 0) {
                // 수학적 연산을 통해 숫자의 각 자릿수를 추출
                int temp = n % 10;
                if (temp == k) {
                    answer++;
                }
                n /= 10;
            }
            i++;
        }

        return answer;
    }

    // 최적화된 솔루션: 문자열을 사용하지 않고 각 숫자를 문자열로 변환하여 처리
    public int solution_best(int i, int j, int k) {
        String temp = "";

        // i부터 j까지의 범위의 모든 숫자를 문자열로 이어붙임
        for(int n = i; n <= j; n++) {
            temp += n + "";
        }

        // 문자열에서 k와 일치하는 문자를 제거하고 남은 길이를 구하여 등장 횟수를 계산
        return temp.length() - temp.replace(k + "", "").length();
    }

}