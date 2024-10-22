package programmers;

class 쿼드압축_후_개수_세기_Java_241008 {

    // 결과를 저장할 배열: answer[0] = 0의 개수
    , answer[1] = 1의 개수
    int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return answer;
    }
    
    // (x, y)에서 시작하는 size x size 크기의 부분 배열을 처리하는 함수
    private void compress(int[][] arr, int x, int y, int size) {
        if (isSame(arr, x, y, size)) {
            answer[arr[x][y]]++;
        } else {
            int newSize = size / 2;
            compress(arr, x, y, newSize);            // 왼쪽 위
            compress(arr, x, y + newSize, newSize);  // 오른쪽 위
            compress(arr, x + newSize, y, newSize);  // 왼쪽 아래
            compress(arr, x + newSize, y + newSize, newSize);  // 오른쪽 아래
        }
    }
    
    private boolean isSame(int[][] arr, int x, int y, int size) {
        int firstValue = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != firstValue) {
                    return false; // 하나라도 다르면 
                }
            }
        }
        return true; 
    }
}
