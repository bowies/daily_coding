package programmers;

class 공원_산책_Java_240526 {
    public int[] solution(String[] park, String[] routes) {
        int 세로길이 = park.length;
        int 가로길이 = park[0].length();
        int[] 위치 = new int[2]; // [행, 열]

        // 시작 위치 찾기
        for (int i = 0; i < 세로길이; i++) {
            for (int j = 0; j < 가로길이; j++) {
                if (park[i].charAt(j) == 'S') {
                    위치[0] = i;
                    위치[1] = j;
                    break;
                }
            }
        }

        int[][] 방향들 = {
            {'N', -1, 0}, // 북쪽
            {'S', 1, 0},  // 남쪽
            {'W', 0, -1}, // 서쪽
            {'E', 0, 1}   // 동쪽
        };

        for (String 경로 : routes) {
            char 방향 = 경로.charAt(0);
            int 거리 = Character.getNumericValue(경로.charAt(2));
            
            int[] 이동 = new int[2];
            for (int[] d : 방향들) {
                if (d[0] == 방향) {
                    이동[0] = d[1];
                    이동[1] = d[2];
                    break;
                }
            }
            
            int 신규행 = 위치[0] + 이동[0] * 거리;
            int 신규열 = 위치[1] + 이동[1] * 거리;
            

            if (신규행 >= 0 && 신규행 < 세로길이 && 신규열 >= 0 && 신규열 < 가로길이) {
                boolean 장애물있음 = false;
                for (int 단계 = 1; 단계 <= 거리; 단계++) {
                    int 확인행 = 위치[0] + 이동[0] * 단계;
                    int 확인열 = 위치[1] + 이동[1] * 단계;
                    if (park[확인행].charAt(확인열) == 'X') {
                        장애물있음 = true;
                        break;
                    }
                }
                if (!장애물있음) {
                    위치[0] = 신규행;
                    위치[1] = 신규열;
                }
            }
        }
        
        return 위치;
    }
}
