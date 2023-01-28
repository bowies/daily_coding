public class CountConformingBitmasks_230128 {
    public static void main(String[] args) {
        int A = 1073741727;
        int B = 1073741631;
        int C = 1073741679;
        //https://github.com/ahmadaghazadeh/Challenges/blob/master/Codibility/CountConformingBitmasks/CountConformingBitmasks.java

        System.out.println(solution(A,B,C));

    }

        public static int solution(int A, int B, int C) {

            int answer = 0;
            String aStr = Integer.toBinaryString(A);
            String bStr = Integer.toBinaryString(B);
            String cStr = Integer.toBinaryString(C);

            answer =  checkBit(aStr)+ checkBit(bStr)+ checkBit(cStr);
            answer -= checkBit(Integer.toBinaryString(A|B));
            answer -= checkBit(Integer.toBinaryString(A|C));
            answer -= checkBit(Integer.toBinaryString(B|C));
            answer += checkBit(Integer.toBinaryString(A|B|C));

            return answer;
        }
        private static int checkBit(String number){

            int count=0;

            for (int i = 0; i < number.length(); i++) {
                if(number.charAt(i)=='0'){
                    count++;
                }
            }

            count += 30 - number.length();//★
            return (int)Math.pow(2, count);
        }


}
