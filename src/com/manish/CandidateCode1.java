package com.manish;

public class CandidateCode1 {
	static int[][] array;
	static int[][] g;
	static int x=-1,y =-1;
	static String[][] output;
	static String outptFinal;
	public static void main(String[] args) {
		String[] input1 = { 
				"0#1#1#1#0#1#0#1","1#0#1#0#0#0#0#1","0#0#0#1#0#1#0#0","1#1#1#1#1#0#0#1","1#1#1#1#0#1#1#1",
				"1#1#1#1#0#1#1#1",
				"1#1#1#1#1#1#1#1",
				"1#1#0#1#0#0#1#1" };
		String[] input11 = {"0#1#1#1#0","1#0#1#0#0","0#0#0#1#0","1#1#1#1#1","1#1#1#1#0"};
		String[] input = {"0#1#1","1#0#1","1#1#0"};
		String[] input3 = {"1#1","1#1"};
		String[] input2 = {};
		String[] input4 = {"0#1#1","1#0#1","1#1#0"};
		/*int[][] temparray = formatInput(input);
		
		array = g = temparray;
		biggestSquare();
		
		System.out.println("biggest location:x,y="+x+","+y);
		construtcOP();
		System.out.println(outptFinal);*/
		
		String temp = biggestSquare(input3);
		System.out.println(temp);
	}
	
	public static String biggestSquare(String[] input1)
    {
		int[][] temparray = formatInput(input1);
		array = g = temparray;
		biggestSquare();
		outptFinal = construtcOP();
		
		return outptFinal;
    }
	private static String construtcOP() {
		if(x==-1)
		{
			outptFinal ="{}";
			return outptFinal;
		}
		int value = g[x][y]; 
		outptFinal="{";
		output = new String[value][value];
		for (int i = 0; i < value; ) 
		{
			outptFinal+="(";
			for (int j = 0; j < value; ) 
			{
				outptFinal += x+i + "#" + (y+j);
				outptFinal+=",";
				j++;
			}
			outptFinal=outptFinal.substring(0, outptFinal.length() - 1);
			outptFinal+="),";
			
			//System.out.println("");
			i++;
		}
		outptFinal=outptFinal.substring(0, outptFinal.length() - 1);
		outptFinal+="}";
		return outptFinal;
	}

	private static int[][] formatInput(String[] temparrayN) {
		int[][] temparray = new int[temparrayN.length][temparrayN.length];
		for(int i=0;i<temparrayN.length;i++)
		{
			String[] a = temparrayN[i].split("#");
			for(int j=0;j<temparrayN.length;j++)
			{
				temparray[i][j] = (Integer.parseInt(a[j]));
			}
		}
		
		return temparray;
	}

	private static char[] biggestSquare() {
		for (int n = 2; n <= array.length; n++)
		{
			getNSize1(n);
		}
		if(x==-1)
		{
			checkOne();
		}
		return null;
	}
	
	private static void checkOne() {
		for (int i = 0; i < array.length; i++) 
		{	for (int j = 0; j < array.length; j++) 
			{	if (array[i][j] == 1) 
				{ x=i;y=j;
					return;
				}
			}
		}			
	}

	private static void getNSize1(int n) {
		n--;
		for (int i = 0; i < array.length - n; i++) {
			for (int j = 0; j < array.length - n; j++) {
				if (array[i][j] == n) {
					if (array[i][j + 1] >= n && array[i + 1][j] >= n && array[i+1][j+1] >= n) {
						g[i][j]++;
						x=i;y=j;
					} 
				}
			}
		}
	}
	
/*static void printArr(int[][] g) {
		
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g.length; j++) {
				System.out.print(g[i][j]+" ");
			}
			System.out.println("");
		}
	}*/
}
