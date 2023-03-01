package programmers;

public class 스티커_모으기_230301 {
    public static void main(String[] args) {
        int [] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
        System.out.println(solution(sticker));
    }

    public static int solution(int[] sticker) {

        if(sticker.length == 1){
            //1장일 때
            return sticker[0];
        } else if(sticker.length == 2){
            //2장일 때
            return Math.max(sticker[0], sticker[1]);
        } else {
            //그 외
            return Math.max(dp(0, sticker.length - 2, sticker), dp(1, sticker.length - 1, sticker));
        }
    }

    private static int dp(int from, int to, int[] sticker) {
        int[] sumArr = new int[sticker.length - 1];
        sumArr[0] = sticker[from];
        sumArr[1] = Math.max(sticker[from + 1], sticker[from]);
        for (int i = from + 2, sumIndex = 2; i <= to; i++, sumIndex++) {
            sumArr[sumIndex] = Math.max((sticker[i] + sumArr[sumIndex - 2]), sumArr[sumIndex - 1]);
        }
        return sumArr[sumArr.length - 1];
    }

    /*
    public static int solution(int sticker[]) {
        
        //스티커 떼낸 거의 합 = ? 이러다가 검색해 봄
        int answer = 0;
        int length = sticker.length;

        if (length == 1){
            //1장일 때
            return sticker[0];
        }

        int [] arr = new int[length];

        // 첫 번째 스티커를 뗐을때
        arr[0] = sticker[0];
        arr[1] = arr[0];
        for (int i = 2; i < length - 1; i++) {
            arr[i] = Math.max(arr[i - 2] + sticker[i], arr[i - 1]);
        }
        answer = arr[length - 2];


        // 첫 번째 스티커를 안뗐을때
        arr[0] = 0;
        arr[1] = sticker[1];
        for (int i = 2; i < length; i++) {
            arr[i] = Math.max(arr[i - 2] + sticker[i], arr[i - 1]);
        }
        answer = Math.max(answer, arr[length - 1]);
        return answer;
    }

     */
}
