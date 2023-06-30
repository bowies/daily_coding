package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class 할_일_목록_Java_230701 {
    /*
    오늘 해야 할 일이 담긴 문자열 배열 todo_list와
    각각의 일을 지금 마쳤는지를 나타내는 boolean 배열 finished가 매개변수로 주어질 때,
    todo_list에서 아직 마치지 못한 일들을 순서대로 담은 문자열 배열을 return 하는 solution 함수를 작성해 주세요.
     */
    public String[] solution(String[] todo_list, boolean[] finished) {

        List list = new ArrayList();

        for(int i = 0; i < todo_list.length; i++){
            if(finished[i] == false){
                list.add(todo_list[i]);
            }
        }
        String[] answer = new String[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = (String) list.get(i);
        }

        return answer;
    }


    public String[] solution_stream(String[] todo_list, boolean[] finished) {
        return IntStream.range(0, todo_list.length)
                .filter(i -> !finished[i])
                .mapToObj(i -> todo_list[i])
                .toArray(String[]::new);
    }
    /*
    이 코드에서는
    1) IntStream.range(0, todo_list.length)를 사용하여
    0부터 todo_list의 길이까지의 범위를 생성합니다.
    2) filter 메서드를 사용하여 완료되지 않은 항목을 필터링하고,
    3) mapToObj 메서드를 사용하여 해당 인덱스의 todo_list 값을 추출합니다.
    4) 최종적으로 toArray(String[]::new)를 사용하여 스트림을 String 배열로 변환합니다.
     */





}