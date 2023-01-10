package codility;

public class CommonPrimeDivisors_230110 {
    public static void main(String[] args) {
        CommonPrimeDivisors_230110 c = new CommonPrimeDivisors_230110();
        int [] A = {15,10,3};
        int [] B = {75, 30, 5};

        System.out.println(c.solution(A, B));


    }

    
    public int solution(int[] A, int[] B) {
        int answer = 0;
        for(int i=0;i<A.length;i++) {
            //같은 소인수 집합을 가지면 ++
            if(samePrime(A[i], B[i])){
                answer++;    
            } 
        }
        return answer;
    }
    
    public int gcd(int num1, int num2) {
	    if(num1 % num2 == 0){
            //0이 될 때까지 돌림
            return num2;
        }
	    return gcd(num2, num1%num2);
	}

	public boolean samePrime(int ai, int bi) {
        boolean flag = false;
	    int gcdValue = gcd(ai,bi);

        int a;
        int b;

        //같은 인수 확인
        while(ai != 1) {
            a = gcd(ai,gcdValue);
            if(a == 1){
                break;
            }
            ai = ai/a;
        }

        while(bi != 1) {
            b = gcd(bi,gcdValue);
            if(b == 1){
                break;
            }
            bi = bi/b;
        }

        if(ai == 1 && bi == 1){
            //둘다 값이 1이면 true
            flag = true;
        }

        return flag;
	}
}
