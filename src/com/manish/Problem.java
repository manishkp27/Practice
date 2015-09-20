package com.manish;

public class Problem {

	public static void main(String[] args) {
		System.out.println("hi manish");
		System.out.println(solution(new int[]{2,7,3,9}));
		System.out.println(solution(new int[]{-1, 3, -4, 5, 1, -6, 2, 1}));
	}
	public static int solution(int[] A) {
		int res = -1;
        if (A == null || A.length == 0){
           return 0;
        }
        
        else
        {
            long sumLeft = 0;
            long sumRight = 0;
            for (int i = 0; i < A.length; i++)
            {
                sumRight += A[i];
            }

            for (int i = 0; i < A.length; i++)
            {
                long tempRight = sumRight - A[i];
                if (sumLeft == tempRight)
                {
                    res = i;
                    break;
                }
                else
                {
                    sumLeft += A[i];
                    sumRight = tempRight;
                }
            }
        }
        return res;
    }
}
