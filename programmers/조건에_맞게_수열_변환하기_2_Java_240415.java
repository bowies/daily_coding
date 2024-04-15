package programmers;

class 조건에_맞게_수열_변환하기_2_Java_240415 {
    public int solution(int[] arr) {
        int answer = 0;

        while (true) {
            int[] 다음상태배열 = new int[arr.length];
            boolean 배열상태확인용 = true; 

            // 배열의 각 원소에 대해 변환 규칙 적용
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) {
                    다음상태배열[i] = arr[i] / 2;
                } else if (arr[i] < 50 && arr[i] % 2 != 0) { 
                    다음상태배열[i] = arr[i] * 2 + 1; 
                } else { 
                    다음상태배열[i] = arr[i]; 
                }

                // 현재 원소와 변환된 원소가 다른 경우, 배열상태확인용을 false로 설정
                if (다음상태배열[i] != arr[i]) {
                    배열상태확인용 = false;
                }
            }

            if (배열상태확인용) {
                break;
            }
            answer++;
            arr = 다음상태배열.clone(); // 현재 배열을 변환된 배열로 업데이트
        }

        return answer;
    }
}
