package programmers;

class 문자열_여러_번_뒤집기_Java_240218 {
    public String solution(String my_string, int[][] queries) {
        char[] arr = my_string.toCharArray(); 

        // 쿼리를 처리
        for (int[] i : queries) {
            int start = i[0];
            int end = i[1];
            문자열_뒤집기(arr, start, end);
        }

        return new String(arr);
    }

    private void 문자열_뒤집기(char[] arr, int start, int end) {
        while (start < end) {
            char c = arr[start];
            arr[start] = arr[end];
            arr[end] = c;
            start++;
            end--;
        }
    }
}
