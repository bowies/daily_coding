class 외계_행성의_나이_Java_240208 {
    public String solution(int age) {
        StringBuilder answer = new StringBuilder();
        String temp = Integer.toString(age);

        for (int i = 0; i < temp.length(); i++) {
            char ch = temp.charAt(i);
            int offset = ch >= '0' && ch <= '9' ? 'a' - '0' : 49;
            answer.append((char)(ch + offset));
        }
        
        return answer.toString();
    }
    public String solution_stream(int age) {
	
        return String.valueOf(age).chars().mapToObj(operand -> String.valueOf((char) (49 + operand))).collect(Collectors.joining());
    }
}
