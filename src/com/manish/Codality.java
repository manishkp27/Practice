package com.manish;

public class Codality {

	public static void main(String[] args) {
		//System.out.println(solution(new int[]{2,2,2,2,2,3,4,4,4,6}));
		//System.out.println(solution(new int[]{1,2,3, 3, 4,4, 4,4,4}));
		//System.out.println(solution(new int[]{1,2,3,3,3,3, 3, 4,4}));
		//System.out.println(solution(new int[]{1,50,2147483647,2147483647,2147483647}));
		//System.out.println(solution(new int[]{0}));
		
		solution2(null);
	}
	class IntList{
		public int value;
		public IntList next;
	}
	 static public int solution2(IntList L) {
	        // write your code in Java SE 8
	        IntList temp;
	        int length=0;
	        
	        while(L!=null){
	            length++;
	            L=L.next;
	        }
	        return length;
	    }
	
	static int solution(int[] A) {
        int n = A.length;
        int[] L = new int[n + 1];
        L[0] = -1;
        for (int i = 0; i < n; i++) {
            L[i + 1] = A[i];
        }
        int count = 0;
        int pos = (n/ 2)+1;
        int candidate = L[pos];
        for (int i = 1; i <= n; i++) {
            if (L[i] == candidate)
                count = count + 1;
        }
        if (count >= pos)
            return candidate;
        return (-1);
    }
}
