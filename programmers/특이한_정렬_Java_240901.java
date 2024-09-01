package programmers;

import java.util.Arrays;

class 특이한_정렬_Java_240901 {
    public int[] solution(int[] numlist, int n) {
        Integer[] answer = Arrays.stream(numlist).boxed().toArray(Integer[]::new);
		//Comparator 사용을 위해 Integer 배열로 변환
        
        // 사용자 정의 Comparator를 사용하여 정렬
        Arrays.sort(answer, (i, j) -> {
            int i와의거리 = Math.abs(i - n);
            int j와의거리 = Math.abs(j - n);
            if (i와의거리 == j와의거리) {
				//거리가 같으면, 더 큰 수를 앞에 오게 한다.
                return j - i;
            } else {
                //거리가 다르면, 거리 기준으로 정렬한다.
                return i와의거리 - j와의거리;
            }
        });
        
		//mapToInt를 사용해서 다시 int 배열로 바꿔준다.
        return Arrays.stream(answer).mapToInt(Integer::intValue).toArray();
    }
}