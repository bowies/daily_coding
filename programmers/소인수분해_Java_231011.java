package programmers

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int[] solution(int n) {
        if (isPrime(n)) {
            int[] answer = {n};
            return answer;
        }

        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                arr.add(i);
                n /= i;
            }
        }

        // 중복 제거를 위해 Set을 사용
        HashSet<Integer> set = new HashSet<>(arr);

        // 중복이 제거된 소인수 배열을 생성
        int[] answer = new int[set.size()];
        int index = 0;
        for (int i : set) {
            answer[index] = i;
            index++;
        }

        // 정렬
        Arrays.sort(answer);

        return answer;
    }

    // 소수인지 확인하는 함수
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }



    
    public int[] solution_good(int n) {
        LinkedHashSet<Integer> primeNumbers = new LinkedHashSet<>();

        int i = 2;
        while (n != 0 && i <= n) {
            if (n % i == 0) {
                primeNumbers.add(i);
                n /= i;
            } else {
                i++;
            }
        }


        return primeNumbers.stream().mapToInt(Integer::intValue).toArray();
    }
}
