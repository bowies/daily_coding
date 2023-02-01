import java.util.ArrayList;

public class TreeHeight_230131 {
    public static void main(String[] args) {

        Tree T = null;
        System.out.println(solution(T));
    }

    public static int solution(Tree T) {
        return height(T);
    }

    // 재귀로 높이 얻음
    public static int height(Tree T) {
        if (T == null){
            // T 자체가 비어버리면 -1 처리 (안해주면 오류남)
            return -1;
        }else{
            // 왼쪽 트리와 오른쪽 트리의 최대 높이를 구하고,
            // +1을 더한 값을 return 해줌 (현재 높이까지 더해줘야 함)
            return Math.max(height(T.l) + 1, height(T.r) + 1);
        }
    }


    public int solution_재귀로안풀면(Tree T) {
        //https://github.com/jlhuang/codility-lessons/blob/master/lesson%2099%20:%20Future%20training/TreeHeight/Solution_Non_Recurse.java

        // 큐는 트리의 각각 수준 노드를 가지고 있다.
        ArrayList<Tree> queue = new ArrayList<Tree>();
        queue.add(T);
        int height = -1;
        while (queue.size() != 0) {
            height++;
            // 현재 레벨의 노드의 수
            int numberOfLevelNode = queue.size();
            while (numberOfLevelNode != 0) {
                // 현재 레벨 노드가 가리키는 걸 다 삭제해버리고
                Tree t = queue.remove(0);
                // 다음 레벨 애들로 가리킴
                if (t.l != null)
                    queue.add(t.l);
                if (t.r != null)
                    queue.add(t.r);
                numberOfLevelNode--;
            }
        }
        return height;
    }

    private static class Tree {
        //오류를 없애고자 자동 생성
        public Tree l;
        public Tree r;
    }
}
