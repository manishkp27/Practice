package com.solution;

import java.util.*;
public class Robber {
	 static House[] housSpace;
	 static int rank=-1;
	 static int length=0;
	 static int[] getNum;
	 static int[] getRank;
	public static void main(String[] args) {
		double t1 = System.currentTimeMillis();
		//int[] num = {1,23,34,56,23,54,67,34,2};
		//int[] num = {2,3,2,2,3,3};

		int[] num = {1,10,11,3};
		//int[] num = {1,1,3,6,7,10,7,1,8,5,9,1,4,4,3};
		
		/*int[] num = {104,209,137,52,158,67,213,86,141,110,151,127,238,147,169,138,240,185,246,225,147,203,83,83,131,227,54,
				78,165,180,214,151,111,161,233,147,124,143};//3155->3176
		*/
		/*int[] num = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
				,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
				,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        */
		System.out.println( Arrays.toString(num));
        System.out.println(rob(num));;
        System.out.println((System.currentTimeMillis()-t1));
	}
	static int rob(int[] num) {
        int res = 0;
        
        if(num==null||num.length<1){
        	return 0;
        }
        else if(num.length==1){
        	return num[0];
        }
        else if(num.length==2){
        	return num[0]>num[1]?num[0]:num[1];
        }
        
        length=num.length;
        getNum=new int[length];
        getRank=new int[length];
        
        housSpace=new House[length];
        for(int i=0;i<length;i++){
        	//housSpace[i]=new House(num[i]);
        	housSpace[i]=new House();
        	housSpace[i].money=num[i];
        	
        	getNum[i]=-1;
        	getRank[i]=-1;
        }

        rank( num);

        //steal with default max
        int res1=steal();        
        System.out.println("=======res1="+res1);
        res=res1;
        
        
         
        return res;
    }
	static void rank(int[] num){
        int[] sorted = new int[length];
        sorted = Arrays.copyOf(num, length);
        Arrays.sort(sorted);
        System.out.println( Arrays.toString(sorted));
        
        for(int i=0;i<length;i++)
        {	for(int j=0;j<length;j++)
            {	if(housSpace[j].rank==-1 && housSpace[j].money == sorted[i] )
        		//if(getRank[j]==-1 && housSpace[j].money == sorted[i] )
	        	{	rank++;
            		housSpace[j].rank=rank;
            		getNum[rank]=j;
            		getRank[j]=rank;
            		continue;
	        	} 
            }
        }
        System.out.println("getNum nums");
        System.out.println( Arrays.toString(getNum));
        /*System.out.println("housSpace ranks");
        System.out.print("[");
        for(House h:housSpace){
        	System.out.print(h.rank+", ");
        }
        System.out.println("]");*/
        System.out.println("getRank ranks");
        System.out.println( Arrays.toString(getRank));
	}

		static int steal(){			
			int res = 0;
	        int number;
	        for(int r=rank;r>=0;r--)
	        {	
	        	number=getNum[r];
	        	if((housSpace[number].money>0 && housSpace[number].burgled==false)
	        		&& ((number==0 || (housSpace[number-1]==null || housSpace[number-1].burgled==false))
	        		&&(number==length-1 || (housSpace[number+1]==null || housSpace[number+1].burgled==false))))
	        		{
	        			housSpace[number].burgled=true;
	        			res+=housSpace[number].money;
	        		}        	
	        }
	        return res;
		}
		
		static void resetSteal(){
			for(int i=0; i<length;i++){
				if(housSpace[i].burgled==true)
					housSpace[i].burgled=false;
	        }
		}
}
class House{
	int money;
	int rank=-1;
	boolean burgled=false;
	/*public House(){	}
	public House(int money){
		this.money=money;
	}*/
}


/*int minRank;
//int numH=getNumFromRank(rank);
int numH=getNum[rank];
int numL;
for(minRank=0;minRank<rank;minRank++){
	//numL=getNumFromRank(minRank);
	numL=getNum[minRank];
    //int temp=housSpace[numH].rank; housSpace[numH].rank=housSpace[numL].rank;  housSpace[numL].rank=temp;
    int temp1=getRank[numH]; getRank[numH]=getRank[numL]; getRank[numL]=temp1;

    int temp11 = getNum[rank];getNum[rank]=getNum[minRank];getNum[minRank]=temp11 ;
    
    resetSteal();
    int res2=steal();
    
    //temp=housSpace[numH].rank; housSpace[numH].rank=housSpace[numL].rank; housSpace[numL].rank=temp;
    temp1=getRank[numH]; getRank[numH]=getRank[numL]; getRank[numL]=temp1;

    temp11 = getNum[rank];getNum[rank]=getNum[minRank];getNum[minRank]=temp11 ;
    
    System.out.println("======res2="+res2);
    res=res2>res?res2:res;
}*/