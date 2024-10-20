package programmers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class PCCP_기출문제_1번_동영상_재생기_Java_240924 {
    public String solution(String 동영상길이, String 현재위치, String 오프닝시작, String 오프닝끝, String[] 명령어들) {
        String[] 동영상길이분할 = 동영상길이.split(":");
        LocalTime 동영상길이시간 = 시간변환(동영상길이분할);

        String[] 현재위치분할 = 현재위치.split(":");
        LocalTime 현재위치시간 = 시간변환(현재위치분할);

        String[] 오프닝시작분할 = 오프닝시작.split(":");
        LocalTime 오프닝시작시간 = 시간변환(오프닝시작분할);

        String[] 오프닝끝분할 = 오프닝끝.split(":");
        LocalTime 오프닝끝시간 = 시간변환(오프닝끝분할);

        for (String 명령어 : 명령어들) {
            switch (명령어) {
                case "next" -> {
                    현재위치시간 = 다음(현재위치시간, 오프닝시작시간, 오프닝끝시간, 동영상길이시간);
                }
                case "prev" -> {
                    현재위치시간 = 이전(현재위치시간, 오프닝시작시간, 오프닝끝시간);
                }
            }
        }
        DateTimeFormatter 포맷터 = DateTimeFormatter.ofPattern("mm:ss");
        return 현재위치시간.format(포맷터);
    }

    private LocalTime 이전(LocalTime 현재위치시간, LocalTime 오프닝시작시간, LocalTime 오프닝끝시간) {
        LocalTime 열초시작 = LocalTime.of(0, 0, 10);
        if (현재위치시간.isBefore(열초시작)) {
            현재위치시간 = LocalTime.of(0, 0, 0);
            if (!현재위치시간.isBefore(오프닝시작시간) && !현재위치시간.isAfter(오프닝끝시간)) {
                현재위치시간 = 오프닝끝시간;
            }
        } else {
            현재위치시간 = 현재위치시간.minusSeconds(10);
            if (!현재위치시간.isBefore(오프닝시작시간) && !현재위치시간.isAfter(오프닝끝시간)) {
                현재위치시간 = 오프닝끝시간;
            }
        }
        return 현재위치시간;
    }

    private LocalTime 다음(LocalTime 현재위치시간, LocalTime 오프닝시작시간, LocalTime 오프닝끝시간, LocalTime 동영상길이시간) {
        LocalTime 열초끝 = 동영상길이시간.minusSeconds(10);
        if (현재위치시간.isAfter(열초끝)) {
            현재위치시간 = 동영상길이시간;
        } else if (!현재위치시간.isBefore(오프닝시작시간) && !현재위치시간.isAfter(오프닝끝시간)) {
            현재위치시간 = 오프닝끝시간;
            현재위치시간 = 현재위치시간.plusSeconds(10);
        } else {
            현재위치시간 = 현재위치시간.plusSeconds(10);
            if (!현재위치시간.isBefore(오프닝시작시간) && !현재위치시간.isAfter(오프닝끝시간)) {
                현재위치시간 = 오프닝끝시간;
            }
        }
        return 현재위치시간;
    }

    private LocalTime 시간변환(String[] 분할) {
        return LocalTime.of(0, Integer.parseInt(분할[0]), Integer.parseInt(분할[1]));
    }
}
