package com.manish;
public class CandidateCode {
	static int[][] array;
	static int[][] g;

	public static void main(String[] args) {
		int[][] temparray1 = { 
				{ 0, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 0 } };
		int[][] temparray11 = { 
				{ 0, 0, 1, 1, 1 ,1}, 
				{ 1, 1, 1, 1, 1 ,1},
				{ 1, 1, 1, 1, 1 ,1}, 
				{ 1, 1, 1, 1, 1 ,1},
				{ 1, 1, 1, 1, 1 ,1},
				{ 1, 1, 1, 1, 0 ,1} };
		String[] temparrayN = { 
				"0#1#1#1#0#1#0#1",
				"1#0#1#0#0#0#0#1",
				"0#0#0#1#0#1#0#0",
				"1#1#1#1#1#0#0#1",
				"1#1#1#1#0#1#1#1",
				"1#1#1#1#0#1#1#1",
				"1#1#1#1#1#1#1#1",
				"1#1#0#1#0#0#1#1" };
		int[][] temparray = formatInput(temparrayN);
		
		array = g = temparray;
		biggestSquare();
		
	}

	private static int[][] formatInput(String[] temparrayN)   {

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
		//getDoubSize();
		//getTripleSize();
		//getQuatSize();
		/*getNSize1(2);
		getNSize1(3);
		getNSize1(4);
		getNSize1(5);*/
		for (int n = 2; n <= array.length; n++)
		{
			getNSize1(n);
		}
		return null;
	}

	/*private static void getNSize(int n) {
		n--;
		for (int i = 0; i < array.length - n; i++) {
			for (int j = 0; j < array.length - n; j++) {
				if (array[i][j] == n) {
					if (array[i][j + n] >= 1 && array[i + n][j] >= 1) {
						g[i][j]++;
					} 
				}
			}
		}
		System.out.println("print Quad array");
		printArr(g);
	}*/
	private static void getNSize1(int n) {
		n--;
		for (int i = 0; i < array.length - n; i++) {
			for (int j = 0; j < array.length - n; j++) {
				if (array[i][j] == n) {
					if (array[i][j + 1] >= n && array[i + 1][j] >= n && array[i+1][j+1] >= n) {
						g[i][j]++;
					} 
				}
			}
		}
		System.out.println("print Quad array");
		printArr(g);
	}

	private static void getQuatSize() {

		for (int i = 0; i < array.length - 3; i++) {
			for (int j = 0; j < array.length - 3; j++) {
				if (array[i][j] == 3) {
					//if (array[i][j + 3] >= 1 && array[i + 3][j] >= 1) {
					if (array[i][j + 1] >= 3 && array[i + 1][j] >= 3 && array[i+1][j+1] >= 3) {
						g[i][j]++;
					} 
				}
			}
		}
		System.out.println("print Quad array");
		printArr(g);
	}

	private static void getTripleSize() {

		for (int i = 0; i < array.length - 2; i++) 
		{
			for (int j = 0; j < array.length - 2; j++) 
			{
				if (array[i][j] == 2) 
				{
					//if (array[i][j + 2] >= 2 && array[i + 2][j] >= 2 && array[i+2][j+2] >= 1 ) {
					if (array[i][j + 1] >= 2 && array[i + 1][j] >= 2 && array[i+1][j+1] >= 2 ) {
						g[i][j]++;
					}
					/*boolean temp = true;
					for (int a = i; a <= i+2; a++) 
					{	for (int b = j; b <= i+2; b++)
						{
							if (array[a][b] == 0 && array[a][b] == 0)
								temp = false;
						}
					}
					if (temp == true) {
						g[i][j]++;
					}*/
				}
			}
		}
		System.out.println("print Triple array");
		printArr(g);
	}

	private static void getDoubSize() {

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[i][j] == 1) {
					if (array[i][j + 1] >= 1 && array[i + 1][j] >= 1 && array[i+1][j+1] == 1) {
						g[i][j]++;
					} 
				}
			}
		}
		System.out.println("print Double array");
		printArr(g);
	}

	static void printArr(int[][] g) {
		
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g.length; j++) {
				System.out.print(g[i][j]+" ");
			}
			System.out.println("");
		}
	}

}