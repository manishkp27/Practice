package com.solution;

import java.util.*;
public class CopyOfRobber {
	 static House1[] housSpace;
	 static int rank=-1;
	public static void main(String[] args) {
		//int[] num = {1,23,34,56,23,54,67,34,2};
		//int[] num = {2,3,2,2,3,3};

		//int[] num = {2,3,2};
		//int[] num = {1,1,3,6,7,10,7,1,8,5,9,1,4,4,3};
		
		/*int[] num = {183,219,57,193,94,233,202,154,65,240,97,234,100,249,186,66,90,238,168,128,177,235,
				50,81,185,165,217,207,88,80,112,78,135,62,228,247,211};
		*/int[] num = {104,209,137,52,158,67,213,86,141,110,151,127,238,147,169,138,240,185,246,225,147,203,83,83,131,227,54,
				78,165,180,214,151,111,161,233,147,124,143};//3155->3176
		
        System.out.println( Arrays.toString(num));
        System.out.println(rob(num));;
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
        
        housSpace=new House1[num.length];
        for(int i=0;i<num.length;i++){
        	housSpace[i]=new House1(num[i],i);
        }

        rank( num);

        //steal with default max
        int res1=steal();
        display();
        System.out.println("=======res1="+res1);
        
        int minRank;
        int numH=getNumFromRank(rank);
        int numL;
        for(minRank=0;minRank<rank;minRank++){
        	numL=getNumFromRank(minRank);
            //reverse ranks
            int temp=housSpace[numH].rank; housSpace[numH].rank=housSpace[numL].rank;
            housSpace[numL].rank=temp;
            //steal with next max
            int res2=steal();
            
            //recorrect correct ranks
            temp=housSpace[numH].rank; housSpace[numH].rank=housSpace[numL].rank;
            housSpace[numL].rank=temp;
            
            System.out.println("======res2="+res2);
          
            //get highest
            res=res2>res?res2:res;
        }
         
        //res=res1>res2?res1:res2;
        
        return res;
    }
	static void rank(int[] num){
		//sort the money in ascending order
        int[] sorted = new int[num.length];
        sorted = Arrays.copyOf(num, num.length);
        Arrays.sort(sorted);
        System.out.println( Arrays.toString(sorted));
        
		//int rank=-1;
        for(int i=0;i<num.length;i++)
        {	for(int j=0;j<num.length;j++)
            {	if(housSpace[j].money == sorted[i] && housSpace[j].rank==-1)
	        	{	rank++;
            		housSpace[j].rank=rank;
            		//System.out.println(j+" "+housSpace[j].money+"->"+housSpace[j].rank);
	        	} 
            }
        }
	}

	//steal
		static int steal(){
			resetSteal();
			int res = 0;
	        int number=0;
	        for(int r=rank;r>=0;r--)
	        {	//System.out.print("rank:"+r+" ");
	        	number=getNumFromRank(r);
	        	if((housSpace[number].burgled==false)
	        		&& ((number==0 || (housSpace[number-1]==null || housSpace[number-1].burgled==false))&&
	        		(number==housSpace.length-1 || (housSpace[number+1]==null || housSpace[number+1].burgled==false))))
	        		{
	        			housSpace[number].burgled=true;
	        			res=res+housSpace[number].money;
	        			//System.out.println("number:"+number+" yes:"+housSpace[number].money);
	        		}        	
	        	else{
	        		//System.out.println("number:"+number+" NO :"+housSpace[number].money);
	        	}
	        }
	        return res;
		}
		
		static int getNumFromRank(int rank){
			int res = 0;
			for(int i=0;i<housSpace.length;i++){
				if(housSpace[i].rank==rank){
					res=i;
					//System.out.println("getNumFromRank i="+i+" rank="+rank);
				}
			}
			return res;
		}
		
		//reset burglary
		static void resetSteal(){
			for(House1 h:housSpace){
	        	h.burgled=false;
	        }
		}
		//display burglary
		static void display(){
			int i=0;
			for(House1 h:housSpace){
	        	System.out.println("num:"+i+++" rank:"+h.rank+" money:"+h.money+", "+h.burgled+" ");
	        }
		}
}
class House1{
	int money;
	int rank;
	boolean burgled;
	public House1(){	}
	public House1(int money, int number){
		this.money=money;
		this.rank=-1;
		burgled=false;
	}
}
