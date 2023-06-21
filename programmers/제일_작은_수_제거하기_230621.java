package programmers;
import java.util.Arrays;

class 제일_작은_수_제거하기_230621 {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int min = Arrays.stream(arr).min().getAsInt();
        int[] answer = new int[arr.length - 1];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != min) {
                answer[index++] = arr[i];
            }
        }
        /*
            Arrays.stream(arr).min().getAsInt()을 사용하여 배열에서 최소값을 구합니다.
            불필요한 변수 min 초기화를 제거하고, 최소값을 바로 사용합니다.
            불필요한 continue 문을 제거하고, 최소값이 아닐 때만 answer 배열에 값을 추가합니다.
            new int[]{-1}을 바로 반환하여 배열을 생성하고 초기화합니다.
         */
        return answer;
    }

    // stream 으로 하면 보기 좋음
    public int[] solution_stream(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int min = Arrays.stream(arr).min().getAsInt();
        int[] answer = Arrays.stream(arr).filter(num -> num != min).toArray();

        return answer;
    }
}
