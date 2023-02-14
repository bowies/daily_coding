package programmers;

public class 단어변환_230214 {
        public int solution(String begin, String target, String[] words) {
            int len = words.length;


            int idx = -1;
            //target 이 words 내에 있는지 확인해야 함 (없으면 아예 못 바꿈 - 2번째 예)

            for(int i = 0 ; i < len ; i++) {
                if(words[i].equals(target)){
                    idx = i;
                }
            }

            if(idx < 0) {
                return 0;
            }

            //dfs
            boolean[] arr = new boolean[len];
            return dfs(begin, target, -1, words, arr, 0);
        }

        public int dfs(String begin, String target, int idx, String[] words, boolean[] arr , int cnt) {

            if(target.equals(begin)) {
                //target이 된 순간 떠난다
                return cnt;
            }

            if(idx >= 0) {
                //방문한 노드는 true 로 바꿔줌
                arr[idx] = true;
            }
            cnt++;

            int len = arr.length;

            for(int i=0 ; i<arr.length ; i++) {
                if(!arr[i]) {
                    if(한글자체크(begin.toCharArray(), words[i].toCharArray())) {
                        len = Math.min(len, dfs(words[i], target, i, words, arr, cnt));
                        arr[i] = false;
                    }
                }
            }
            return len;
        }

        public boolean 한글자체크(char[] begin, char[] target) {
            /* 한글자만 다른지 체크 */
            int cnt = 0;
            for(int j=0 ; j<begin.length ; j++) {
                if(begin[j] != target[j])
                    cnt ++;
            }
            //1글자만 달라야 패스할 수 있음
            return (cnt ==1) ? true : false;
        }

    }
