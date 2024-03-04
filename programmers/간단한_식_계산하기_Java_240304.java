package programmers;

class 간단한_식_계산하기_Java_240304 {
    public int solution(String binomial) {
        String[] parts = binomial.split(" ");

        int a = Integer.parseInt(parts[0]);
        String op = parts[1];
        int b = Integer.parseInt(parts[2]);

        int answer = 0;
        switch (op) {
            case "+":
                answer = a + b;
                break;
            case "-":
                answer = a - b;
                break;
            case "*":
                answer = a * b;
                break;
        }

        return answer;
    }
}
