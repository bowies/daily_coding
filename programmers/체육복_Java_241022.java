package programmers;

import java.util.*;

class 체육복_Java_241022 { 
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for (int l : lost) {
            if (!contains(reserve, l)) {
                lostList.add(l);
            } else {
                remove(reserve, l);
            }
        }
        
        for (int r : reserve) {
            if (!contains(lost, r)) {
                reserveList.add(r);
            }
        }
        
        int answer = n - lostList.size(); 
        
        for (int l : lostList) {
            if (reserveList.contains(l - 1)) {
                reserveList.remove(Integer.valueOf(l - 1));
                answer++;
            } else if (reserveList.contains(l + 1)) {
                reserveList.remove(Integer.valueOf(l + 1));
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean contains(int[] arr, int num) {
        for (int a : arr) {
            if (a == num) return true;
        }
        return false;
    }
    
    private void remove(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                arr[i] = -1; 
                break;
            }
        }
    }
}
