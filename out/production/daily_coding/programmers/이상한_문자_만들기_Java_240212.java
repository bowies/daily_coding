import java.util.Arrays;
import java.util.stream.Collectors;

class 이상한_문자_만들기_Java_240212 {
    public String solution(String s) {
        int[] idx = {0};
        return Arrays.stream(s.split(""))
                     .map(str -> {
                         if (str.equals(" ")) {
                             idx[0] = 1;
                         }
                         return idx[0]++ % 2 == 0 ? str.toUpperCase() : str.toLowerCase();
                     })
                     .collect(Collectors.joining());
    }

    public String solution2(String s) {
        String answer = "";
        String [] arr = s.split("");
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(" ")) {
                idx = 1;
            }

            answer += idx % 2 == 0 ? arr[i].toUpperCase() : arr[i].toLowerCase();
            idx++;
        }

        return answer;
    }
}
