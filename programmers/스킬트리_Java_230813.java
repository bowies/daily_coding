package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class 스킬트리_Java_230813 {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String skillTree : skill_trees) {
            int index = 0; // 스킬 순서 인덱스를 초기화
            
            // 스킬트리를 순회하면서 가능한 스킬트리인지 체크
            boolean 가능한지확인 = true;

            for (char i : skillTree.toCharArray()) {
                if (skill.indexOf(i) == index) {
                    // 현재 배워야 할 스킬을 올바른 순서대로 배우는 경우
                    index++;
                } else if (skill.indexOf(i) < index) {
                    // 이미 배운 스킬인 경우는 무시
                } else {
                    // 올바른 스킬 순서가 아닌 경우
                    가능한지확인 = false;
                    break;
                }
            }
            
            if (가능한지확인) {
                answer++;
            }
        }
        
        return answer;
    }









    public int solution2(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees)); // 주어진 스킬트리를 ArrayList로 변환
        // ArrayList<String> skillTrees = new ArrayList<String>(); // 처음부터 ArrayList를 사용할 수도 있습니다.
        Iterator<String> it = skillTrees.iterator(); // ArrayList의 요소를 반복 순회하기 위한 Iterator를 생성

        while (it.hasNext()) {
            String 현재_검사중인_스킬트리 = it.next();
            // 주어진 스킬트리에서 skill 문자열에 포함된 문자를 제외한 나머지 문자를 모두 제거
            String filteredSkillTree = 현재_검사중인_스킬트리.replaceAll("[^" + skill + "]", "");

            if (skill.indexOf(filteredSkillTree) != 0) {
                // 만약 현재 스킬트리가 주어진 스킬 순서에 맞지 않으면
                // 해당 스킬트리를 ArrayList에서 제거
                it.remove();
            }
        }

        answer = skillTrees.size(); // 가능한 스킬트리의 개수를 계산
        return answer; // 결과 반환
    }

}
