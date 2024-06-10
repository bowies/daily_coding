package programmers;

class 호텔_대실_Java_240611 {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] total = new int[24*60+10]; //tip - 예약 종료 시간 때문에 이걸 안 하면 runtime error
        int[][] time = new int[book_time.length][2];
        
        int index = 0;
        
        for(String[] str : book_time) {
            time[index][0] = 시간계산(str[0]);
            time[index][1] = 시간계산(str[1]) + 10; //tip - 종료 시간을 분 단위로 변환 후 10분 추가
            index++;
        }

        for(int[] i : time) {
            total[i[0]]++;
            total[i[1]]--;
        }

        for(int i = 1; i < total.length; i++) {
            total[i] += total[i-1];
            answer = Math.max(answer, total[i]);
        }

        return answer;
    }

    public int 시간계산(String book) {
        int 시간 = Integer.parseInt(book.split(":")[0]) * 60;
        int 분 = Integer.parseInt(book.split(":")[1]);

        return 시간 + 분;
    }
}
