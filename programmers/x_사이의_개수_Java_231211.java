package programmers;

import java.util.Arrays;

class x_사이의_개수_Java_231211 {
    /*
        문자열 myString이 주어집니다.
        myString을 문자 "x"를 기준으로 나눴을 때 나눠진 문자열 각각의 길이를
        순서대로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
     */
    public int[] solution(String myString) {
        String[] arr = myString.split("x");
        int[] answer = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i].length();
        }

        if (myString.endsWith("x")) {
            int[] temp = new int[answer.length + 1];
            System.arraycopy(answer, 0, temp, 0, answer.length);
            temp[temp.length - 1] = 0;
            answer = temp;
        }

        return answer;
    }


    public int[] solution2(String myString) {
        String[] arr = myString.split("x");

        int[] answer = Arrays.stream(arr)
                .mapToInt(String::length)
                .toArray();

        if (myString.endsWith("x")) {
            int[] temp = Arrays.copyOf(answer, answer.length + 1);
            temp[temp.length - 1] = 0;
            answer = temp;
        }

        return answer;
    }

    public int[] solution3(String myString) {
        String[] arr = (myString + "x").split("x", -1);
        return Arrays.stream(arr).mapToInt(String::length).toArray();
    }

    public int[] solution_stream(String myString) {
        return Arrays.stream(myString.split("x", myString.length()))
                .mapToInt(x -> x.length())
                .toArray();
    }
}