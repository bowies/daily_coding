package programmers;

import java.util.Arrays;

public class 단속카메라_230211 {
    public static void main(String[] args) {
        int [][] 경로 = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(solution(경로));

    }

    public static int solution(int[][] routes) {


        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        int answer = 0;
        int last_camera = Integer.MIN_VALUE;
        for (int[] a : routes) {
            if (last_camera < a[0]) {
                answer++;
                last_camera = a[1];
            }
            ///카메라 위치를 처음 조정 하고 나서
            // route 의 시작 위치보다 작을 경우에는
            // 새로운 카메라를 나갈 때 설치하며 ++한다
        }
        return answer;
    }
}
