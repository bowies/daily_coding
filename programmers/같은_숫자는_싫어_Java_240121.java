package programmers;

import java.util.*;

public class 같은_숫자는_싫어_Java_240121 {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                list.add(arr[i]);
            }
        }

        // 마지막 원소는 항상 포함됨
        list.add(arr[arr.length - 1]);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }




    public int[] solution_best(int []arr) {
        ArrayList<Integer> tempList = new ArrayList<Integer>();

        // 이전 숫자를 저장하는 변수 초기화 (임의의 숫자로 선택, 주어진 배열의 범위를 벗어나도록)
        int preNum = 10;

        // 배열 순회
        for(int num : arr) {
            // 현재 원소가 이전 숫자와 다르다면 (연속적으로 나타나지 않는 경우)
            if(preNum != num)
                // 중복이 제거된 결과를 저장하는 리스트에 현재 원소 추가
                tempList.add(num);

            // 이전 숫자 업데이트
            preNum = num;
        }

        int[] answer = new int[tempList.size()];

        for(int i=0; i<answer.length; i++) {
            answer[i] = tempList.get(i).intValue();
        }

        return answer;
    }
}
