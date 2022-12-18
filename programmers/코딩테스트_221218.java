package programmers;

public class 코딩테스트_221218 {
    /*
        class Solution {
        public static void main(String[] args) {
            int a = 3000;
            int b = 5000;
            int budget = 23000;
            
            int ans = solution(a, b, budget);
            System.out.println(ans);
        }
        public static int solution(int a, int b, int budget) {
            int answer = 0;

            int cnt = 0;
            while(true) {
                int calc = budget-(cnt*a);
                if(calc <= 0) {
                    if(calc == 0) {
                        answer++;
                    }
                    break;
                }else {
                    
                    if(calc%b == 0) {
                        answer++;
                    }
                }
                cnt++;
            }
            return answer;
        }
    }
     */
    /*
        효율성 때문에 2번 계속 푸는 중...
            
    
    */
    /*
        SELECT 
            ROUND(AVG(RATE), 2) as average
        FROM
            VIDEOS;
     */
    /*
        SELECT 
            BRANCH_ID, SUM(SALARY) AS TOTAL
        FROM
            EMPLOYEES
        WHERE
            BRANCH_ID
        GROUP BY
            BRANCH_ID
        ORDER BY
            BRANCH_ID ASC;    
     */
}
