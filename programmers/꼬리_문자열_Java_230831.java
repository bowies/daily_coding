package programmers;

public class 꼬리_문자열_Java_230831 {
    public String solution(String [] str_list, String ex){
        StringBuilder answer = new StringBuilder();
        for(String str : str_list){
            answer.append(str.contains(ex) ? "" : str);
        }

        return answer.toString();
    }

    
    public String solution_stream(String[] str_list, String ex) {
        return Arrays.stream(str_list)
                .filter(str -> !str.contains(ex))
                .collect(Collectors.joining());
    }

}
