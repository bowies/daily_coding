package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class test_230107 {
    public static void main(String[] args) {
        String encyrpted_text = "qyyigoptvfb";
        String key = "abcdefghijk";
        int rotation = 3;
        //System.out.println(solution1(encyrpted_text, key, rotation));

        //String letters = "zzbbggaaaj";
        String letters = "bzgaj";
        int k = 3;
        //System.out.println(solution2(letters, k));

        String exp1 = "2x^5 + 3x^3 + 2x^1";
        String exp2 = "6x^6 + 4x^4 + 3x^3 + 2x^2";
        //System.out.println(solution3(exp1, exp2));

    
    }


    public static String solution3(String exp1, String exp2){

        String [] arr1 = exp1.split(" \\+ ");
        String [] arr2 = exp2.split(" \\+ ");

        
        HashMap <Integer, Integer> map = new HashMap<>();

        PriorityQueue queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String str : arr1){                
            String [] temp = str.split("\\^");
            String [] temp2 = temp[0].split("x");
            
            if(map.get(Integer.parseInt(temp[1])) == null){
                map.put(Integer.parseInt(temp[1]), Integer.parseInt(temp2[0]));
            }else{
                map.put(Integer.parseInt(temp[1]), Integer.parseInt(temp2[0])+map.get(Integer.parseInt(temp[1])));
            } 
        }
        for(String str : arr2){                     
            String [] temp = str.split("\\^");
            String [] temp2 = temp[0].split("x");
            
            if(map.get(Integer.parseInt(temp[1])) == null){
                map.put(Integer.parseInt(temp[1]), Integer.parseInt(temp2[0]));
            }else{
                map.put(Integer.parseInt(temp[1]), Integer.parseInt(temp2[0])+map.get(Integer.parseInt(temp[1])));
            }
        }   

        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.reverse(keySet);

        StringBuffer sb = new StringBuffer();

        for (int key : keySet) {
            sb.append(map.get(key) + "x^" + key + " + ");

        }

        String answer = sb.toString().substring(0, sb.length()-3);
    

        return answer;
    }
    
    public static String solution2(String letters, int k){
        //문자열 k개를 선택해서 순서를 유지하며 이어 붙임
        //사전 순으로 가장 뒤에 오는 문자열을 만들려고 함
        //letters에서 문자를 k개 선택해서, 순서를 유지하며 이어붙여 만들 수 있는 문자열 중 사전 순으로
        //가장 뒤에 오는 것을 return 하도록 만들면 됨
        
        char [] oriArr = letters.toCharArray();
        
        while(true){
            int count = 0;
            int [] temp = new int [k];
            while(count == k){
                

            }
            
        }



        /*
        char [] oriArr = letters.toCharArray();
        PriorityQueue queue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue queue2 = new PriorityQueue<>();
        

        for(int i = 0; i < oriArr.length; i++){
            queue.add((int)oriArr[i]);
        }

        int max = findArr(queue, oriArr, k);
        int jCounter = 0;

        for(int i = max; i < oriArr.length; i++){
            if(jCounter == k-1){
                break;
            }
            int temp = (int)queue.poll();
            for(int j = max; j < oriArr.length; j++){
                if(temp == (int)oriArr[j]){
                    queue2.add(j);
                    jCounter++;
                    break;
                }
            }
        }
        

        StringBuffer sb = new StringBuffer();
        sb.append(oriArr[max]);
        while(!queue2.isEmpty()){
            sb.append(oriArr[(int)queue2.poll()]);
        }
        System.out.println(sb.toString());
        */

        /*
        char [] oriArr = letters.toCharArray();
        PriorityQueue queue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue queue2 = new PriorityQueue<>();
        

        for(int i = 0; i < oriArr.length; i++){
            queue.add((int)oriArr[i]);
        }

 
        int max = findArr(queue, oriArr, k);

        int jCounter = 0;

        for(int i = max+1; i < oriArr.length; i++){
            if(queue.isEmpty() || jCounter == k-1){
                break;
            }else{
                int temp = (int) queue.poll();
                
                for(int j = max+1; j < oriArr.length; j++){
                    if(temp == (int)oriArr[j]){
                        queue2.add(j);                
                        jCounter++;        
                        break;
                    }
                }
            }
            
        }

        StringBuffer sb = new StringBuffer();
        sb.append(oriArr[max]);
        while(!queue2.isEmpty()){
            sb.append(oriArr[(int)queue2.poll()]);
        }
        System.out.println(sb.toString());

 */

/*

        int counter = 0;
        int max = 0;
        String answer = "";
        
        while(true){
            if(counter == letters.length()-k+1){
                break;
            }
            int temp = answer.compareTo(letters.substring(counter, counter+k));
            if(temp < max){
                max = temp;
                answer  = letters.substring(counter, counter+k);
            }
            counter++;
        }

        Stack <Character> stack = new Stack<Character>();
        for(char c : letters.toCharArray()){
            stack.add(c);
        }

        int temp = 0;
        while(!stack.isEmpty()){
            temp = (int)stack.pop();
            if(!stack.isEmpty()){
                if(temp < (int)stack.peek()){
                    
                }
            }
            if(temp < (int)stack.peek()){
                
                System.out.println(temp);
            }

        }
         */
        //return "";
    }
    
    private static int findArr(PriorityQueue queue, char[] oriArr, int k) {
        int max = (int)queue.poll();
        int answer = 0;
        for(int i = 0; i < oriArr.length; i++){
            if((int)oriArr[i] == max){
                if(i < k){
                    answer = i;
                    break;
                }else{
                    return findArr(queue, oriArr, k);
                }
            }
        }
        return answer;
    }


    public static String solution1(String encrypted_text, String key, int rotation){
        //평문과 같은 길이의 문자열 key
        //암호화시킬 문장을 key를 이용하여 암호화시킴
        //문장을 rotation만큼 회전시킴
        //을 역으로 까면 됨
        
        ArrayList<Character> arr = new ArrayList<>();
        
        int temp = 1; //rotation이 양수인지 음수인지 판별하기 위한 변수
        if(rotation < 0) {
            temp = -1;
        }

        int realRotate = Math.abs(rotation) % key.length() * temp;

        if(realRotate < 0) {
            //음수면 양수로 바꿔야 함 (-1이나 2나 똑같음... << >>>)
            realRotate = key.length() + realRotate; 
        }

        for(int i=0; i<key.length(); i++) {
            temp = i+realRotate;
            if(temp >= key.length()) {
                temp = temp - key.length();
            }
            arr.add(encrypted_text.charAt(temp));
        }

        StringBuffer sb = new StringBuffer();               
        for(int i=0; i<key.length(); i++) 
        {           
            int curVal = (int)arr.get(i);
            int keyVal = (int)key.charAt(i);
            
            int realVal = curVal - keyVal + 96;

            if(realVal < 97) {
                //이거 안 넣으면 오류남 
                //hellop_Zhon <- 같이 나옴
                realVal = realVal + 26;
            }      
          
            sb.append((char)(realVal));
        }     
        return sb.toString();
    }
    
}
