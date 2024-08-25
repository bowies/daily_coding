package programmers;

class 캐릭터의_좌표_Java_240825 {
    public int[] solution(String[] keyinput, int[] board) {
        int[] curent = {0, 0};
        
        int xLimit = board[0] / 2;
        int yLimit = board[1] / 2;
        
        for (String key : keyinput) {
            switch (key) {
                case "up":
                    if (curent[1] < yLimit) {
                        curent[1]++;
                    }
                    break;
                case "down":
                    if (curent[1] > -yLimit) {
                        curent[1]--;
                    }
                    break;
                case "left":
                    if (curent[0] > -xLimit) {
                        curent[0]--;
                    }
                    break;
                case "right":
                    if (curent[0] < xLimit) {
                        curent[0]++;
                    }
                    break;
            }
        }
        
        return curent;
    }
}
