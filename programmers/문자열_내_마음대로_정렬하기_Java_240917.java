package programmers;
import java.util.Arrays;
import java.util.Comparator;

class 문자열 내 마음대로 정렬하기 {
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // n번째 문자가 다르면 해당 문자를 기준으로 정렬
                if (s1.charAt(n) != s2.charAt(n)) {
                    return Character.compare(s1.charAt(n), s2.charAt(n));
                }
                // n번째 문자가 같으면 사전순으로 정렬
                return s1.compareTo(s2);
            }
        });
        
        return strings;
    }
}
