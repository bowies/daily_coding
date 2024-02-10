class 문자열_정렬하기_1_Java_240211 {
    public int[] solution(String my_string) {
        return my_string.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .sorted()
                .toArray();
    }


    public int[] solution(String my_string) {
        ArrayList<Integer> list = new ArrayList<>();

        for (char c : my_string.toCharArray()) {
            if (Character.isDigit(c)) {
                list.add(Character.getNumericValue(c));
            }
        }

        Collections.sort(list);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
