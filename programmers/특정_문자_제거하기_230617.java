import java.util.stream.Collectors;

class 특정_문자_제거하기_230617 {
    public String solution(String my_string, String letter) {
        String answer = my_string.replace(letter, "");
        return answer;
    }
    
    public String solution_stream(String my_string, String letter) {
        String answer = my_string.chars()
                .filter(c -> c != letter.charAt(0))
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        
        return answer;
    }
}
