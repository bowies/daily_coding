package programmers;

class _1차_비밀지도_Java_240918 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];  
        
        for (int i = 0; i < n; i++) {
            int combined = arr1[i] | arr2[i]; //OR 연산

            String binaryString = Integer.toBinaryString(combined); //이진수로 변환하여 # & 공백 변환
            
            binaryString = String.format("%" + n + "s", binaryString); //n보다 길이가 짧으면 앞에 0을 채워준다
            
            binaryString = binaryString.replace('1', '#').replace('0', ' '); //이진수를 # & 공백 변환
            answer[i] = binaryString;
        }
        
        return answer;
    }
}
