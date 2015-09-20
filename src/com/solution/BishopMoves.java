package com.solution;

public class BishopMoves {

	public static void main(String[] args) {
		Integer[][] space = {{1, 2, 3},
				 			 {4, 5, 6},
				 			 {7, 8, 9},
				 			{-1, 0, -1}};
		Bishop bishop = new Bishop(space);
		System.out.println(bishop.isValidMove(9, 1));

	}

}

class Bishop{
	Integer[][] space;
	public Bishop(Integer[][] space ){
		this.space=space;
	}
	boolean isValidMove(int pos,int dir){
		boolean res=false;
		int newpos;
		switch (dir){
		case 1: 
			newpos=pos-1-3;
			System.out.println(newpos);
			if(newpos>=0 &&newpos<=9){
				res=true;
			}
		break;
		case 2: 
			newpos=pos-1-1;
			System.out.println(newpos);
			if(newpos>=0 &&newpos<=9){
				res=true;
			}
		break;
		case 3: 
			newpos=pos+1+3;
			System.out.println(newpos);
			if(newpos>=0 &&newpos<=9){
				res=true;
			}
		break;
		case 4: 
			newpos=pos+1+1;
			System.out.println(newpos);
			if(newpos>=0 &&newpos<=9){
				res=true;
			}
		break;
		}
		//System.out.println(pos+1+3);
		//if(space[pos+])
		return res;
	}
}
