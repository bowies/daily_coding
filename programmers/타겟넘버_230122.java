package programmers;

public class 타겟넘버_230122 {
    public static void main(String[] args) {
        int [] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }

    static int answer = 0;

    public static int solution(int[] numbers, int target) {

        dfs(numbers, target, 0, 0);

        return answer;
    }

    
    // 깊이 우선 탐색
    public static void dfs(int[] numbers, int target, int 깊이, int 총합){
        if(깊이 == numbers.length){
            //깊이를 배열 길이 끝까지 탐색 (마지막 노드)
            if(target == 총합){
                answer++;
            }
        } else {
            
            int 더하기 = 총합 + numbers[깊이]; //총합 : 노드 값 더하고 다음 깊이 탐색
            int 빼기 = 총합 - numbers[깊이]; // 총합 : 노드 값 빼고 다음 깊이 탐색

            dfs(numbers, target, 깊이 + 1, 더하기); 
            dfs(numbers, target, 깊이 + 1, 빼기); 
        }
    }

}
