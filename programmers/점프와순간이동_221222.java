package programmers;

public class 점프와순간이동_221222 {
    public static void main(String[] args) {
        int n = 5;
        solution(n);
    }

    public static int solution(int n) {
        int ans = 0;
        
        //n 
        //n * 2 
        //순간이동 : 건전지 안 줄어듬
        //K칸 점 프 : K만큼 건전지 사용량 듬
        //건전지 사용량 최소값
        //n 위치에 도달해야 함 (튀어 나가면 안됨)

        //N이 0이 될때까지 연산 반복
        //N이 홀수일 때는 1칸 폴짝 움직여야 해서 1개 건전지 씀
        //N이 나누가 2 하면 건전지 없이 갈 수 있어서 폴짝 가짐

        while(n != 0){
            if( n % 2 == 0){
                n /= 2;
                System.out.println(n+"이다!");
            }else{
                n--;
                System.out.println(n + "이다 ㅠ");
                ans++;
            }

        }
        System.out.println(ans);

        return ans;
    }
}
