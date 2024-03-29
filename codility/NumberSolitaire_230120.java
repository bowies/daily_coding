class NumberSolitaire{
    public static void main(String[] args) {
        int [] A = {1,-2,0,9,-1,-2};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        
        int[] arr = new int[A.length];

        //조약돌은 정사각형 숫자 0에 표시되어 있습니다. 0 - 0
        arr[0] = A[0];

        for(int i = 1; i < A.length; i++){            
            int 최대가능한결과 = -2147483648;//Integer.MIN_VALUE
            
            for(int 주사위 = 1; 주사위 <= 6; 주사위++){
                if(i - 주사위 >= 0){
                    최대가능한결과 = Math.max(arr[i-주사위]+A[i], 최대가능한결과);
                    System.out.println(i + "번째, 주사위값 : " + 주사위 + " 최대 가능한 결과 " + 최대가능한결과);
                }
            }    
            arr[i] = 최대가능한결과; 
        }
        
        return arr[A.length-1];
    }
    /*
        1인용 게임은 0에서 N-1까지 번호가 매겨진 N개의 연속된 사각형으로 구성된 보드에서 진행됩니다. 
        각 사각형에는 숫자가 쓰여 있습니다. 
        N 정수의 비어 있지 않은 배열 A에는 사각형에 쓰여진 숫자가 포함됩니다. 
        또한 일부 사각형은 게임 중에 표시할 수 있습니다.
        게임을 시작할 때 0번 사각형에 조약돌이 있고 이것은 보드에서 표시된 유일한 사각형입니다. 
        게임의 목표는 조약돌을 제곱수 N-1로 옮기는 것입니다.

        매 턴마다 앞면에 1에서 6까지의 숫자가 있는 육면체 주사위를 던지고 주사위가 정지한 후 윗면에 표시되는 숫자 K를 고려합니다. 
        그런 다음 제곱수 I에 있는 조약돌을 제곱수 I + K로 이동합니다. 
        단, 제곱수 I + K가 존재합니다. 제곱수 I + K가 존재하지 않으면 유효한 움직임을 얻을 때까지 주사위를 다시 던집니다. 
        마지막으로 제곱수 I + K를 표시합니다.

        게임이 끝난 후(조약돌이 제곱수 N-1 위에 서 있을 때) 결과를 계산합니다. 
        게임의 결과는 표시된 모든 사각형에 쓰여진 숫자의 합입니다.

        예를 들어 다음 배열이 있다고 가정합니다.

            A[0] = 1
            A[1] = -2
            A[2] = 0
            A[3] = 9
            A[4] = -1
            A[5] = -2
        가능한 게임은 다음과 같습니다.

        조약돌은 정사각형 숫자 0에 표시되어 있습니다.
        우리는 3을 던집니다. 조약돌은 제곱수 0에서 제곱수 3으로 이동합니다. 우리는 제곱수 3을 표시합니다.
        우리는 5를 던집니다. 보드에 정사각형 숫자 8이 없기 때문에 조약돌은 움직이지 않습니다.
        우리는 2를 던집니다. 조약돌은 정사각형 숫자 5로 이동합니다. 이 사각형을 표시하면 게임이 종료됩니다.
        표시된 사각형은 0, 3, 5이므로 게임의 결과는 1 + 9 + (-2) = 8입니다. 
        이것이 이 보드에서 얻을 수 있는 최대 가능한 결과입니다.

        함수 작성:

        class 공배수_230519 { public int solution(int[] A); }

        N 정수의 비어 있지 않은 배열 A가 주어지면 배열 A로 표시되는 보드에서 달성할 수 있는 최대 결과를 반환합니다.

        예를 들어, 주어진 배열

            A[0] = 1
            A[1] = -2
            A[2] = 0
            A[3] = 9
            A[4] = -1
            A[5] = -2
        함수는 위에서 설명한 대로 8을 반환해야 합니다.

        다음 가정에 대한 효율적인 알고리즘을 작성 하십시오.

        N은 범위 [ 2 .. 100,000 ] 내의 정수 이고;
        배열 A의 각 요소는 [ −10,000 .. 10,000 ] 범위 내의 정수 입니다.
    */

}