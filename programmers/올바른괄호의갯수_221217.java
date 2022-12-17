package programmers;

public class 올바른괄호의갯수_221217 {
    public static void main(String[] args) {
        
    }
    
    public int solution(int n) {
        //괄호 쌍의 개수 N : 1 ≤ n ≤ 14, N은 정수
        //[카탈란 수] 라는 걸 이용하면 간단하게(?) 풀 수 있음
                   
        int [] arr = new int[n+1];
        
        arr[0] = 1;
        arr[1] = 1;
        
        for(int i = 2; i <= n; i++){ 
            for(int j = 1; j <= i; j++){
                arr[i] += arr[i-j] * arr[j-1]; 
            }
        }
        
        System.out.println(arr[n]);
        
        return arr[n];

    }
}
