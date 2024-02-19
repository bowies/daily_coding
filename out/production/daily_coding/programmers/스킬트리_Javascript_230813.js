function solution(skill, skill_trees) {
    var answer = 0;
    var regex = new RegExp(`[^${skill}]`, 'g'); // 스킬을 제외한 문자를 정규표현식으로 찾을 패턴 생성

    return skill_trees
        .map((x) => x.replace(regex, '')) // 스킬을 제외한 문자를 모두 제거하여 새로운 스킬트리 문자열로 변환
        .filter((x) => {
            // 스킬트리 문자열이 스킬 순서에 맞는지 또는 빈 문자열인지 필터링
            return skill.indexOf(x) === 0 || x === "";
        })
        .length; // 가능한 스킬트리 개수를 반환
}
