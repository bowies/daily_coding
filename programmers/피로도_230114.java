package programmers;

public class 피로도_230114 {
    public static void main(String[] args) {
        int k = 80;
        int [][] dungeons = {{80,20},{50,40},{30,10}};
        System.out.println(solution(k, dungeons));
        //System.out.println(solution2(k, dungeons));
    }
    
    static boolean[] visited;  
    static int answer = 0;  
  
    public static int solution(int k, int[][] dungeons) {  
        visited = new boolean[dungeons.length];  
        dfs(0, k, dungeons);  
        return answer;  
    }  
      
    private static void dfs(int depth, int 피로도, int[][] dungeons){  
        for (int i = 0; i < dungeons.length; i++){  
            if (visited[i] || dungeons[i][0] > 피로도) { 
                //0 : 필요 피로도 
                continue;
            }  
            visited[i] = true;
            dfs(depth + 1, 피로도 - dungeons[i][1], dungeons);   //1 : 소모 피로도
            visited[i] = false; 
        }  
        answer = Math.max(answer, depth);  
    }  


}
