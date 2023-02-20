package programmers;

public class 징검다리_건너기_230220 {
    public static void main(String[] args) {
        int [] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3; //한 번에 뛸 수 있는 것
        System.out.println(solution(stones,k));
    }
    static int solution(int[] stones, int k) {
        int answer = 0;
        int 최소 = 1;
        int 최대 = 200000000;

        //이분탐색 ...
        while(최소<=최대){
            int 중간값 = (최소+최대)/2;
            if(건너지는지체크(stones, k, 중간값)){
                //중간값으로 건널 수 있으면 최소값을 중간 쪽으로 옮김
                최소 = 중간값+1;
                answer = Math.max(answer, 중간값);
            }
            else{
                //중간값으로 못 건널 경우 최대값을 중간 쪽으로 옮김
                최대 = 중간값-1;
            }
        }
        return answer;
    }
    static Boolean 건너지는지체크(int[] stones, int k, int 중간값){
        int 한번에건너기 = 0;

        for(int i: stones){
            if(i - 중간값 < 0)  {
                //i - 중간값 해서 장차 못 밟을 연속 칸을 계산해 둔다
                한번에건너기++;
            }else{
                한번에건너기 = 0;
            }

            if(한번에건너기 == k){
                //한번에건너기가 k면 그냥 못 건넘...
                return false;
            }

        }
        return true;
    }

    /*
    javascript 코드 중 stack 형식으로 사용한 것 공부하려고 가져왔음.


    function solution(stones, k) {
            stones.push(Infinity);
            let stack = [{count: Infinity, idx: -1}];
            let answer = Infinity;
            for (let i = 0; i < stones.length; i++) {
                const right = { count: stones[i], idx: i };
                while (stack[stack.length - 1].count < right.count) {
                    const mid = stack.pop();
                    const left = stack[stack.length - 1];
                    if (right.idx - left.idx > k) {
                        answer = Math.min(answer, mid.count);
                    }
                }
                stack.push(right);
            }
            return answer;
        }

     */

}
