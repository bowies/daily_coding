package programmers;

import java.util.*;

class 과제_진행하기_Java_230919 {
    /*
    과제를 받은 루는 다음과 같은 순서대로 과제를 하려고 계획을 세웠습니다.

        과제는 시작하기로 한 시각이 되면 시작합니다.
        새로운 과제를 시작할 시각이 되었을 때, 기존에 진행 중이던 과제가 있다면 진행 중이던 과제를 멈추고 새로운 과제를 시작합니다.
        진행중이던 과제를 끝냈을 때, 잠시 멈춘 과제가 있다면, 멈춰둔 과제를 이어서 진행합니다.
            만약, 과제를 끝낸 시각에 새로 시작해야 되는 과제와 잠시 멈춰둔 과제가 모두 있다면, 새로 시작해야 하는 과제부터 진행합니다.
        멈춰둔 과제가 여러 개일 경우, 가장 최근에 멈춘 과제부터 시작합니다.

    과제 계획을 담은 이차원 문자열 배열 plans가 매개변수로 주어질 때, 과제를 끝낸 순서대로 이름을 배열에 담아 return 하는 solution 함수를 완성해주세요.

    제한사항
        3 ≤ plans의 길이 ≤ 1,000
            plans의 원소는 [name, start, playtime]의 구조로 이루어져 있습니다.
                name : 과제의 이름을 의미합니다.
                    2 ≤ name의 길이 ≤ 10
                    name은 알파벳 소문자로만 이루어져 있습니다.
                    name이 중복되는 원소는 없습니다.
                start : 과제의 시작 시각을 나타냅니다.
                    "hh:mm"의 형태로 "00:00" ~ "23:59" 사이의 시간값만 들어가 있습니다.
                    모든 과제의 시작 시각은 달라서 겹칠 일이 없습니다.
                    과제는 "00:00" ... "23:59" 순으로 시작하면 됩니다. 즉, 시와 분의 값이 작을수록 더 빨리 시작한 과제입니다.
                playtime : 과제를 마치는데 걸리는 시간을 의미하며, 단위는 분입니다.
                    1 ≤ playtime ≤ 100
                    playtime은 0으로 시작하지 않습니다.
            배열은 시간순으로 정렬되어 있지 않을 수 있습니다.
        진행중이던 과제가 끝나는 시각과 새로운 과제를 시작해야하는 시각이 같은 경우 진행중이던 과제는 끝난 것으로 판단합니다.
     */
    public List<String> solution(String[][] plans) {
        List<String> answer = new ArrayList<>();

        // 과제 정보를 저장하는 Node 객체 배열
        과제노드[] 과제정보 = new 과제노드[plans.length];

        // 과제 정보를 Node 객체로 변환하여 배열에 저장
        for (int i = 0; i < plans.length; i++) {
            String[] time = plans[i][1].split(":");
            과제정보[i] = new 과제노드(i, Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]), Integer.parseInt(plans[i][2]));
        }

        // 시작 시간을 기준으로 과제를 정렬
        Arrays.sort(과제정보, (i, j) -> i.시작시간 - j.시작시간);

        // 아직 끝나지 않은 과제를 저장하는 스택
        Stack<과제노드> 끝나지않은과제 = new Stack<>();

        for (int i = 0; i < 과제정보.length - 1; i++) {
            int 현재과제 = 과제정보[i].시작시간 + 과제정보[i].수행시간; // 현재 과제가 끝나는 시간
            int 다음과제 = 과제정보[i + 1].시작시간; // 다음 과제의 시작 시간

            if (현재과제 <= 다음과제) {
                // 현재 과제가 다음 과제보다 빨리 끝날 경우, 현재 과제를 끝내고 기록
                answer.add(plans[과제정보[i].index][0]);

                int 남은시간 = 다음과제 - 현재과제; // 현재 과제가 끝낸 후 남은 시간
                while (남은시간 > 0 && !끝나지않은과제.isEmpty()) {
                    int 뺀시간 = 끝나지않은과제.peek().수행시간 - 남은시간;
                    끝나지않은과제.peek().수행시간 = Math.max(0, 뺀시간);
                    if (뺀시간 <= 0) {
                        남은시간 = -1 * 뺀시간;
                        answer.add(plans[끝나지않은과제.pop().index][0]); // 남은 시간이 없으면 과제 끝내고 기록
                    } else {
                        남은시간 = 0;
                    }
                }
            } else {
                // 현재 과제가 다음 과제보다 늦게 끝날 경우, 현재 과제를 멈추고 스택에 저장
                과제정보[i].수행시간 = (현재과제 - 다음과제);
                끝나지않은과제.push(과제정보[i]);
            }
        }
        // 마지막 과제 처리
        answer.add(plans[과제정보[과제정보.length - 1].index][0]);

        // 스택에 남은 과제 처리
        while (!끝나지않은과제.isEmpty()) {
            answer.add(plans[끝나지않은과제.pop().index][0]);
        }

        return answer;
    }

    static class 과제노드 {
        int index;
        int 시작시간;
        int 수행시간;

        public 과제노드(int index, int 시작시간, int 수행시간) {
            this.index = index;
            this.시작시간 = 시작시간;
            this.수행시간 = 수행시간;
        }

    }
}


//소스 출처 : https://velog.io/@fufru/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EA%B3%BC%EC%A0%9C-%EC%A7%84%ED%96%89%ED%95%98%EA%B8%B0