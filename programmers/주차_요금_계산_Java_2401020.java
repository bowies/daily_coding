package programmers;
import java.util.*;

class 주차_요금_계산_Java_2401020 {

    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> 누적시간 = new HashMap<>();
        Map<String, Integer> 입차시간 = new HashMap<>();
        Set<String> 차량번호목록 = new TreeSet<>();

        for (String record : records) {
            String[] splitRecord = record.split(" ");
            String 시각 = splitRecord[0];
            String 차량번호 = splitRecord[1];
            String 내역 = splitRecord[2];

            차량번호목록.add(차량번호);

            int 시간 = 시간변환(시각); // 시각을 분으로 변환

            if (내역.equals("IN")) {
                // 입차 기록
                입차시간.put(차량번호, 시간);
            } else {
                // 출차 기록
                int 입차한시간 = 입차시간.remove(차량번호);
                int 주차시간 = 시간 - 입차한시간;
                누적시간.put(차량번호, 누적시간.getOrDefault(차량번호, 0) + 주차시간);
            }
        }

        // 23:59에 출차된 것으로 간주되는 차량 처리
        for (String 차량번호 : 입차시간.keySet()) {
            int 입차한시간 = 입차시간.get(차량번호);
            int 주차시간 = 1439 - 입차한시간; // 23:59 = 1439분
            누적시간.put(차량번호, 누적시간.getOrDefault(차량번호, 0) + 주차시간);
        }

        // 요금 계산
        List<Integer> 요금목록 = new ArrayList<>();
        for (String 차량번호 : 차량번호목록) {
            int 총주차시간 = 누적시간.get(차량번호);
            요금목록.add(요금계산(fees, 총주차시간));
        }

        return 요금목록.stream().mapToInt(i -> i).toArray();
    }

    private int 시간변환(String 시각) {
        String[] split = 시각.split(":");
        int 시 = Integer.parseInt(split[0]);
        int 분 = Integer.parseInt(split[1]);
        return 시 * 60 + 분;
    }

    private int 요금계산(int[] fees, int 총주차시간) {
        int 기본시간 = fees[0];
        int 기본요금 = fees[1];
        int 단위시간 = fees[2];
        int 단위요금 = fees[3];

        if (총주차시간 <= 기본시간) {
            return 기본요금;
        } else {
            int 초과시간 = 총주차시간 - 기본시간;
            return 기본요금 + (int) Math.ceil((double) 초과시간 / 단위시간) * 단위요금;
        }
    }
}