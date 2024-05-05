package programmers;

import java.util.ArrayList;

class 배열_만들기_2_Java_240505 {
    public int[] solution(int l, int r) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i = l; i <= r; i++) {
            // 현재 정수가 0과 5로만 이루어진 정수인지 확인
            if (정수확인(i)) {
                // 0과 5로만 이루어진 정수라면 결과 리스트에 추가
                answer.add(i);
            }
        }
        
        // 결과 리스트가 비어있는 경우
        if (answer.isEmpty()) {
            // -1이 담긴 배열을 반환
            return new int[]{-1};
        } else {
            // 결과 리스트를 배열로 변환
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    private boolean 정수확인(int i) {
        while (i > 0) {
            int 현재_자리수 = i % 10;
            if (현재_자리수 != 0 && 현재_자리수 != 5) {
                return false;
            }
            i /= 10; //다음 자릿수 확인용
        }
        return true;
    }
}
