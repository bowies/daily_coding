package programmers;

class 옹알이_2_Java_230719 {
    /*
        머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다.
        조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과
        네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고 연속해서 같은 발음을 하는 것을 어려워합니다.
        문자열 배열 babbling이 매개변수로 주어질 때,
        머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
     */


    public int solution(String[] babbling) {
        int answer = 0;

        for(String word : babbling) {
            // 발음 가능 여부를 확인하여 발음 가능한 단어의 개수 증가
            if(발음가능확인(word)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean 발음가능확인(String word) {

        String[] 조카 = {"aya", "ye", "woo", "ma"};

        for(int i = 0; i < 조카.length; i++) {
            // 단어에서 조카 발음을 해당 인덱스의 숫자로 치환
            word = word.replace(조카[i], Integer.toString(i));
        }

        char prev = '-'; // 이전 숫자를 기록하는 변수, 초기값은 '-'으로 설정

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i); // 현재 숫자

            // 현재 숫자가 0~3 사이의 숫자가 아니면 발음 불가능하므로 false 반환
            if (curr < '0' || curr > '3') {
                return false;
            }

            // 이전 숫자와 현재 숫자가 같으면 발음 불가능하므로 false 반환
            if (prev == curr) {
                return false;
            }

            prev = curr; // 이전 숫자 갱신
        }

        return true; // 모든 조건을 통과하면 발음 가능하므로 true 반환
    }
    public int solution_short(String[] babbling) {
        int answer = 0;

        String[] 조카 = { "aya", "ye", "woo", "ma" };

        for (int i = 0; i < babbling.length; i++) {
            // 조카 발음 조합 확인
            for (int j = 0; j < 조카.length; j++) {
                // 조카 발음이 단어에 포함되어 있지 않은 경우 조카 발음 제거
                if (!babbling[i].contains(조카[j])) {
                    babbling[i] = babbling[i].replace(조카[j], " ");
                }
            }
            // 공백 제거하여 발음 가능한 단어인지 확인
            babbling[i] = babbling[i].replace(" ", "");
            if (babbling[i].length() == 0) {
                // 발음 가능한 단어인 경우 answer 증가
                answer++;
            }
        }

        return answer;
    }

    /*
        머쓱이의 조카가 발음할 수 있는 단어의 개수를 계산하는 또 다른 방법입니다.
        해당 단어가 "ayaaya", "yeye", "woowoo", "mama"를 포함하는지 확인하여 계산합니다.
    */
    public int solution_best(String[] babblings) {
        int answer = 0;

        for (int i = 0; i < babblings.length; i++) {
            // 단어가 "ayaaya", "yeye", "woowoo", "mama"를 포함하는 경우 continue하여 다음 단어로 넘어감
            if (babblings[i].contains("ayaaya") || babblings[i].contains("yeye") ||
                    babblings[i].contains("woowoo") || babblings[i].contains("mama")) {
                continue;
            }

            // 단어에서 "aya", "ye", "woo", "ma"를 공백으로 치환
            babblings[i] = babblings[i].replace("aya", " ");
            babblings[i] = babblings[i].replace("ye", " ");
            babblings[i] = babblings[i].replace("woo", " ");
            babblings[i] = babblings[i].replace("ma", " ");
            // 공백 제거하여 단어가 없는 경우 answer 증가
            babblings[i] = babblings[i].replace(" ", "");
            if (babblings[i].length() == 0) {
                answer++;
            }
        }
        return answer;
    }
}
