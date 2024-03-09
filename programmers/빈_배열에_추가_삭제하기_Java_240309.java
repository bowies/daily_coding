package programmers;

import java.util.ArrayList;
import java.util.List;

class 빈_배열에_추가_삭제하기_Java_240309 {

    public int[] solution(int[] arr, boolean[] flag) {
        List<Integer> X = new ArrayList<>();

        // arr 배열과 flag 배열을 순회하면서 X 배열에 요소를 추가하거나 제거함
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            // flag가 true인 경우, arr[i]를 2번 추가
            if (flag[i]) {
                int finalNum = num;
                // arr[i]를 2번 추가하는 람다식
                Runnable arr2번추가 = () -> {
                    for (int j = 0; j < finalNum * 2; j++) {
                        X.add(finalNum);
                    }
                };
                arr2번추가.run();
            } else { // flag가 false인 경우, 마지막 arr[i]개의 요소를 제거
                int finalNum = num;
                // 마지막 arr[i]개의 요소를 제거하는 람다식
                Runnable 마지막요소제거 = () -> {
                    int size = X.size();
                    if (size >= finalNum) {
                        for (int j = 0; j < finalNum; j++) {
                            X.remove(size - 1 - j);
                        }
                    }
                };
                마지막요소제거.run();
            }
        }

        // 결과를 저장할 배열 초기화
        int[] answer = new int[X.size()];
        // ArrayList에 저장된 값을 배열에 복사
        for (int i = 0; i < X.size(); i++) {
            answer[i] = X.get(i); // X 배열의 요소를 순서대로 배열에 저장
        }

        return answer; // 결과 배열 반환
    }
}
