import java.util.Arrays;

public class 배열의_유사도_230612 {
    public int solution(String[] s1, String[] s2) {
        return (int) Arrays.stream(s1)
                .distinct()
                .filter(Arrays.asList(s2)::contains)
                .count();
    }

    
    public int same_solution(String[] s1, String[] s2) {
        int answer = 0;
        
        for(int i = 0; i < s1.length; i++){
            for(int j = 0; j < s2.length; j++){
                if(s1[i].equals(s2[j])){
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}
