package programmers;
class 콜라츠_추측_Java_240607 {
    public int solution(int num) {
        int count = 0;
        while (num != 1) {
            if (count >= 466) {
                return -1;
            }
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            count++;
        }
        return count;
    }
}
