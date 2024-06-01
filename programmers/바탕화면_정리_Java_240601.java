package programmers;

class 바탕화면_정리_Java_240601 {
    public int[] solution(String[] wallpaper) {
        int 최소Row = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        int 최대Row = Integer.MIN_VALUE;
        int 최대Col = Integer.MIN_VALUE;

        for (int row = 0; row < wallpaper.length; row++) {
            for (int col = 0; col < wallpaper[row].length(); col++) {
                if (wallpaper[row].charAt(col) == '#') {
                    if (row < 최소Row) {
                        최소Row = row;
                    }
                    if (row > 최대Row) {
                        최대Row = row;
                    }
                    if (col < minCol) {
                        minCol = col;
                    }
                    if (col > 최대Col) {
                        최대Col = col;
                    }
                }
            }
        }

        return new int[] { 최소Row, minCol, 최대Row + 1, 최대Col + 1 };
    }
}
