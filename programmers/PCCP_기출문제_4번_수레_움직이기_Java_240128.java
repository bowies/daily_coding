package programmers;
import java.util.*;

class PCCP_기출문제_4번_수레_움직이기_Java_240128{
    private static class 좌표 {
        int x, y;

        좌표(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int 최대값 = 999999;

    public int[][] 지도;
    private boolean 빨간수레도착, 파란수레도착;
    private int[] 이동방향X = {-1, 1, 0, 0};
    private int[] 이동방향Y = {0, 0, -1, 1};
    private boolean[][][] 방문여부;

    public int solution(int[][] 미로) {
        좌표 시작점빨간수레 = null;
        좌표 시작점파란수레 = null;

        지도 = new int[미로.length][미로[0].length];
        방문여부 = new boolean[미로.length][미로[0].length][2];

        for (int i = 0; i < 미로.length; i++) {
            for (int j = 0; j < 미로[i].length; j++) {
                지도[i][j] = 미로[i][j];
                if (미로[i][j] == 1) 시작점빨간수레 = new 좌표(i, j);
                else if (미로[i][j] == 2) 시작점파란수레 = new 좌표(i, j);
            }
        }
        방문여부[시작점빨간수레.x][시작점빨간수레.y][0] = true;
        방문여부[시작점파란수레.x][시작점파란수레.y][1] = true;
        int 답 = 백트래킹(시작점빨간수레, 시작점파란수레, 0);
        return (답 == 최대값) ? 0 : 답;
    }

    private 좌표 다음위치얻기(int x, int y, int 방향) {
        int 다음x = x + 이동방향X[방향];
        int 다음y = y + 이동방향Y[방향];
        return new 좌표(다음x, 다음y);
    }

    private boolean 이동가능여부(좌표 시작빨간수레, 좌표 빨간수레,
                               좌표 시작파란수레, 좌표 파란수레) {
        if (빨간수레.x < 0 || 빨간수레.y < 0 || 빨간수레.x >= 지도.length || 빨간수레.y >= 지도[0].length
                || 파란수레.x < 0 || 파란수레.y < 0 || 파란수레.x >= 지도.length || 파란수레.y >= 지도[0].length
                || 지도[빨간수레.x][빨간수레.y] == 5 || 지도[파란수레.x][파란수레.y] == 5) return false;

        if ((시작빨간수레.x == 파란수레.x && 시작빨간수레.y == 파란수레.y)
                && (시작파란수레.x == 빨간수레.x && 시작파란수레.y == 빨간수레.y)) return false;

        if ((!빨간수레도착 && 방문여부[빨간수레.x][빨간수레.y][0])
                || (!파란수레도착 && 방문여부[파란수레.x][파란수레.y][1])) return false;

        if (빨간수레.x == 파란수레.x && 빨간수레.y == 파란수레.y) return false;
        return true;
    }

    private int 백트래킹(좌표 빨간수레, 좌표 파란수레, int 결과) {
        if (빨간수레도착 && 파란수레도착) return 결과;
        int 답 = 최대값;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                좌표 다음빨간 = (!빨간수레도착) ? 다음위치얻기(빨간수레.x, 빨간수레.y, i) : 빨간수레;
                좌표 다음파란 = (!파란수레도착) ? 다음위치얻기(파란수레.x, 파란수레.y, j) : 파란수레;

                if (!이동가능여부(빨간수레, 다음빨간, 파란수레, 다음파란)) continue;
                방문여부[다음빨간.x][다음빨간.y][0] = true;
                방문여부[다음파란.x][다음파란.y][1] = true;
                if (지도[다음빨간.x][다음빨간.y] == 3) 빨간수레도착 = true;
                if (지도[다음파란.x][다음파란.y] == 4) 파란수레도착 = true;

                답 = Math.min(답, 백트래킹(다음빨간, 다음파란, 결과 + 1));

                빨간수레도착 = false;
                파란수레도착 = false;
                방문여부[다음빨간.x][다음빨간.y][0] = false;
                방문여부[다음파란.x][다음파란.y][1] = false;
            }
        }
        return 답;
    }
}
