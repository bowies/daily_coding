package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 디스크_컨트롤러_230316 {


    /*
    하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다.
    디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다.
    가장 일반적인 방법은 요청이 들어온 순서대로 처리하는 것입니다.

    예를들어

    - 0ms 시점에 3ms가 소요되는 A작업 요청
    - 1ms 시점에 9ms가 소요되는 B작업 요청
    - 2ms 시점에 6ms가 소요되는 C작업 요청
    와 같은 요청이 들어왔습니다. 이를 그림으로 표현하면 아래와 같습니다.
    Screen Shot 2018-09-13 at 6.34.58 PM.png

    한 번에 하나의 요청만을 수행할 수 있기 때문에 각각의 작업을 요청받은 순서대로 처리하면 다음과 같이 처리 됩니다.
    Screen Shot 2018-09-13 at 6.38.52 PM.png

    - A: 3ms 시점에 작업 완료 (요청에서 종료까지 : 3ms)
    - B: 1ms부터 대기하다가, 3ms 시점에 작업을 시작해서 12ms 시점에 작업 완료(요청에서 종료까지 : 11ms)
    - C: 2ms부터 대기하다가, 12ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 16ms)
    이 때 각 작업의 요청부터 종료까지 걸린 시간의 평균은 10ms(= (3 + 11 + 16) / 3)가 됩니다.

    하지만 A → C → B 순서대로 처리하면
    Screen Shot 2018-09-13 at 6.41.42 PM.png

    - A: 3ms 시점에 작업 완료(요청에서 종료까지 : 3ms)
    - C: 2ms부터 대기하다가, 3ms 시점에 작업을 시작해서 9ms 시점에 작업 완료(요청에서 종료까지 : 7ms)
    - B: 1ms부터 대기하다가, 9ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 17ms)
    이렇게 A → C → B의 순서로 처리하면 각 작업의 요청부터 종료까지 걸린 시간의 평균은 9ms(= (3 + 7 + 17) / 3)가 됩니다.

    각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때, 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return 하도록 solution 함수를 작성해주세요. (단, 소수점 이하의 수는 버립니다)

    제한 사항
    jobs의 길이는 1 이상 500 이하입니다.
    jobs의 각 행은 하나의 작업에 대한 [작업이 요청되는 시점, 작업의 소요시간] 입니다.
    각 작업에 대해 작업이 요청되는 시간은 0 이상 1,000 이하입니다.
    각 작업에 대해 작업의 소요시간은 1 이상 1,000 이하입니다.
    하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.
    입출력 예
    jobs	return
    [[0, 3], [1, 9], [2, 6]]	9
    입출력 예 설명
    문제에 주어진 예와 같습니다.

    0ms 시점에 3ms 걸리는 작업 요청이 들어옵니다.
    1ms 시점에 9ms 걸리는 작업 요청이 들어옵니다.
    2ms 시점에 6ms 걸리는 작업 요청이 들어옵니다.
    문제가 잘 안풀린다면😢
     */






    public int solution(int[][] jobs) {

        //요청시간 별로 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        int answer = 0;
        int 수행완료시간 = 0;
        int 배열Index = 0;
        int counter = 0;


        PriorityQueue<int[]> 우선순위큐 = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        while (counter < jobs.length) {
            //전체 수행 필요

            while (배열Index < jobs.length && jobs[배열Index][0] <= 수행완료시간) {
                //수행완료시간 <- 에 해당되는 애들을 다 우선순위큐에다가 넣음
                우선순위큐.add(jobs[배열Index++]);
            }

            if (우선순위큐.isEmpty()) {
                //비어있음 => 우선순위큐에 수행완료시간에 해당되는 애가 없음
                //그러면 수행완료시간을 맨 처음으로 이동시킴 -> 정렬했으니까 그 다음 짧은 애부터 시작
                수행완료시간 = jobs[배열Index][0];
            } else {
                //있음 -> 정상 수행
                int [] arr = 우선순위큐.poll();
                answer += arr[1] + 수행완료시간 - arr[0];
                수행완료시간 += arr[1];
                counter++;
            }
        }

        return (int) Math.floor(answer / jobs.length);
    }






    public int solution_ORIGINAL(int[][] jobs) {
        int answer = 0;

        // 작업이 요청되는 시점 기준으로 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        // 작업의 소요시간 기준으로 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int jobs_index = 0; // 작업 배열 인덱스
        int finish_job = 0; // 처리 완료된 작업 개수
        int end_time = 0; // 작업 처리 완료 시간

        while(true) {
            if(finish_job == jobs.length) break; // 모든 작업을 처리했다면 종료

            // 이전 작업 처리 중 요청된 작업 add
            while(jobs_index < jobs.length && jobs[jobs_index][0] <= end_time) {
                pq.add(jobs[jobs_index++]);
            }

            if(!pq.isEmpty()) { // 이전 작업 처리 중 요청된 작업이 있는 경우
                int[] job = pq.poll();
                answer += end_time - job[0] + job[1]; // 작업 요청부터 종료까지 걸린 시간 추가
                end_time += job[1]; // 작업 처리 완료 시간 갱신
                finish_job++; // 처리 완료된 작업 개수 1 증가
            } else { // 이전 작업 처리 중 요청된 작업이 없는 경우
                end_time = jobs[jobs_index][0]; // 다음 작업 요청 시점으로 갱신
            }
        }

        return answer / jobs.length;
    }





}
