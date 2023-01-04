package codility;

import java.util.ArrayList;

public class Flags_230104 {
    public static void main(String[] args) {

        int [] A = {1,5,3,4,3,4,1,2,3,4,6,2};
        System.out.println(solution(A));

    }    

    public static int solution(int[] A) {
        int answer = 0;
        int len = A.length;
        int temp = 1;

        while ((temp - 1) * temp < len) {
            int counter = temp;
            int i = 1;
            while (i < len - 1) {
                if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                    counter -= 1;
                    if (counter == 0) {
                        break;
                    }
                    i += temp;
                } else {
                    i +=1;
                }
            }
            if (counter == 0) {
                answer = temp;
                temp += 1;
            } else {
                break;
            }
        }

        return answer;
    }

    public static int solution2(int[] A) {
        int answer = 1; 

        if(A.length < 3){
            answer = 0;
            return answer;
        }
        
        ArrayList <Integer> list = new ArrayList<Integer>();  

		for (int i = 1; i < A.length - 1; i++) {  
			if (A[i - 1] < A[i] && A[i + 1] < A[i]) {  
				list.add(i);  
			}  
		}  

	    if (list.size() == 1 || list.size() == 0) {  
			return list.size();  
	    }  

        int start = 1;  
        int end = list.size();  
        int temp = 0; 
        int temp2 = 0;
        boolean flag = false;  
        int counter = 0;
        

        while (start <= end) {  
            temp = (start + end) / 2;  
            flag = false;  

            counter = 0;  
            temp2 = list.get(0);  

            for (int i = 0; i < list.size(); i++) {  
                if (list.get(i) >= temp2) {  
                    counter++;  
                    temp2 = list.get(i) + temp;  
					if (counter == temp) {                       
						flag = true;  
						break;  
					}  
                }  
            }  

            if (flag) {  
                answer = temp;  
                start = temp + 1;  
            }else {  
                end = temp - 1;  
            }  
        }  
       return answer;  
    }
}


