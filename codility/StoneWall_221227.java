import java.util.Stack;

public class StoneWall_221227 {
    public static void main(String[] args) {
        int [] H = {8,8, 5, 7,9,8,7,4,8};
        System.out.println(solution(H));
    }
    public static int solution(int[] H) {
        int answer = 0;

        Stack <Integer> stack = new Stack<>();
        Integer temp = 0;

        for (int i = 0; i < H.length; i++) {
            while (!stack.isEmpty()) {
                //안 비었으면 돌린다!
                temp = stack.pop();
                //일단 pop 해줌! (peek 대신 pop 해버림!)

                if (temp == H[i]) {
                    //똑같으면 넣어줌!
                    stack.push(temp);
                    break;
                } else if (H[i] > temp) {
                    //더 크면 temp랑 새로운 애를 넣어줌!
                    stack.push(temp);
                    stack.push(H[i]);
                    break;
                } else {
                    //아니면 그냥 ++
                    answer++;
                }
            }

            if (stack.isEmpty() == true){
                //비었으면 넣어준다
                stack.push(H[i]);
            } 
        }
        
        answer = answer + stack.size();
        return answer;
    }
}
