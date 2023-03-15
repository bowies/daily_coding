package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 섬_연결하기_230315 {

    /*
    n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때,
    최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 solution을 완성하세요.

    다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 봅니다.
    예를 들어 A 섬과 B 섬 사이에 다리가 있고, B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.

    제한사항

    섬의 개수 n은 1 이상 100 이하입니다.
    costs의 길이는 ((n-1) * n) / 2이하입니다.
    임의의 i에 대해, costs[i][0] 와 costs[i] [1]에는 다리가 연결되는 두 섬의 번호가 들어있고,
    costs[i] [2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.
    같은 연결은 두 번 주어지지 않습니다. 또한 순서가 바뀌더라도 같은 연결로 봅니다.
    즉 0과 1 사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.
    모든 섬 사이의 다리 건설 비용이 주어지지 않습니다. 이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.
    연결할 수 없는 섬은 주어지지 않습니다.
    입출력 예

    n	costs	return
    4	[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]	4
    입출력 예 설명

    costs를 그림으로 표현하면 다음과 같으며, 이때 초록색 경로로 연결하는 것이 가장 적은 비용으로 모두를 통행할 수 있도록 만드는 방법입니다.

    image.png
     */
    public int solution(int n, int[][] costs) {
        //4 - 0, 1, 1
        //왔다갔다 해도 됨 -> 람다로 짠 코드가 멋지다

        int answer = 0;
        int[] 섬 = new int[n];

        //맨 처음에는 부모를 나 자신으로 둠
        for (int i = 0; i < n; i++) {
            섬[i] = i;
        }

        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        //이거 오름차순으로 설정해야 함 = 어차피 어디 써도 뭐...

        for (int i = 0; i < costs.length; i++) {
            //섬이 다른지 확인 필요
            if (섬확인(섬, costs[i][0]) != 섬확인(섬, costs[i][1])) {
                연결안되있으니까연결하기(섬, costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }

        return answer;
    }

    private int 섬확인(int[] 섬, int i) {
        if (섬[i]== i) {
            return i;
        }
        return 섬확인(섬, 섬[i]);
    }

    private void 연결안되있으니까연결하기(int[] 섬, int 섬1정보, int 섬2정보){
        int 섬1 = 섬확인(섬, 섬1정보);
        int 섬2 = 섬확인(섬, 섬2정보);
        섬[섬1] = 섬2;  //섬1 연결부위를 섬2로 바꿔줘버림
    }





    //-----------------------------------------------------------------------------------------


    public int solution_thanks(int n, int[][] costs) {
        // kruskal algorithm
        int answer = 0;
        int[][] link = new int[n][n];
        int minCost = costs[0][2];
        int minIsland1 = costs[0][0], minIsland2 = costs[0][1];

        List<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < n; i++)
            visited.add(false);

        for (int[] cost : costs) {
            link[cost[0]][cost[1]] = cost[2];
            link[cost[1]][cost[0]] = cost[2];

            if (cost[2] < minCost) { // select first island
                minCost = cost[2];
                minIsland1 = cost[0];
                minIsland2 = cost[1];
            }
        }

        while (visited.contains(false)) {
            answer += minCost;
            visited.set(minIsland1, true);
            visited.set(minIsland2, true);
            minCost = (int) 1e9;

            for (int i = 0; i < n; i++) {
                if (visited.get(i)) {
                    for (int j = 0; j < n; j++) {
                        if (link[i][j] != 0 && !visited.get(j) && minCost > link[i][j]) {
                            minCost = link[i][j];
                            minIsland1 = i;
                            minIsland2 = j;
                        }
                    }
                }
            }
        }

        return answer;
    }

}