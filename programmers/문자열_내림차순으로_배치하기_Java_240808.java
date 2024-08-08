package programmers;

class _2의_영역_Java_240408 {
    public int[] solution(int[] arr) {
        int 시작인덱스 = -1;
        int 종료인덱스 = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                if (시작인덱스 == -1) {
                    시작인덱스 = i;
                }
                종료인덱스 = i;
            }
        }
        
        if (시작인덱스 == -1) {
            //2가 아예 없으면 return
            return new int[]{-1};
        }
        
        int[] answer = new int[종료인덱스 - 시작인덱스 + 1];

        for (int i = 시작인덱스; i <= 종료인덱스; i++) {
            answer[i - 시작인덱스] = arr[i];
        }
        
        return answer;
    }
}
