package programmers;

import java.util.*;
class Solution {
	public int solution(int[] people, int limit) {
        int cnt = 0;
        int j = 0;
        Arrays.sort(people);
        
        for(int i = people.length-1; i > j; i--) {
        	if(people[i] + people[j] <= limit) {
        		cnt++; 
        		j++;
        	}        		      	
        }
        
        return people.length - cnt;
    }
}