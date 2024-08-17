package programmers;


class 문자열_계산하기_Java_240817 {
    public int solution(String my_string) {
        String[] arr = my_string.split(" ");
        
        int answer = Integer.parseInt(arr[0]);
        
        for (int i = 1; i < arr.length; i += 2) {
            String operator = arr[i];
            int current = Integer.parseInt(arr[i + 1]);
            
            if (operator.equals("+")) {
                answer += current;
            } else if (operator.equals("-")) {
                answer -= current;
            }
        }
        
        return answer;
    }
}