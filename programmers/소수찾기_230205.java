package programmers;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기_230205 {
    public static void main(String[] args) {
        String numbers = "17";
        System.out.println(solution(numbers));
    }


    public static int solution(String numbers) {
        int 정답 = 0;
        Set<Integer> set = new HashSet<>();
        int 길이 = numbers.length();

        dfs(numbers, new boolean[길이], 0, new StringBuilder(), set);

        for (int i : set){
            if (i < 2) {
                continue;
            }
            boolean 소수확인 = true;

            for(int j = 2; j < i; j++){
                if (i % j == 0) {
                    소수확인 = false;
                    break;
                }
            }
            if (소수확인){
                정답++;
            }
        }

        return 정답;
    }

    public static void dfs(String numbers, boolean[] visited, int 깊이, StringBuilder s, Set set){
        int 길이 = visited.length;
        for(int i = 0; i < 길이; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            s.append(numbers.charAt(i));
            set.add(Integer.parseInt(s.toString()));

            dfs(numbers, visited, 깊이+1, s, set);

            s.deleteCharAt(s.length()-1);
            visited[i] = false;
        }

    }
}
