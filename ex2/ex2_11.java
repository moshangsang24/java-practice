/*
content: java experiment
user: Liu
data:
version: 0.0.1
*/    
import java.util.Scanner;

public class ex2_11  
{  
    public static void main(String[] args)  
    {  
    	Scanner scan=new Scanner(System.in);
    	String s=scan.next();
    	int max=0,index=0;
    	for(int i=0;i<s.length();i++)
    	{
    		for(int j=1;j<s.length()/2 && i+j< s.length() && i-j>=0 ;j++){
    			if(s.charAt(i-j)!=s.charAt(i+j) && j>max){
    				max=j-1;
    				index=i;
    			}
    		}
    	}

    	for(int i=max;i>=0;i--){
    		System.out.print(s.charAt(index-i));
    	}
    	for(int i=1;i<max;i++){
    		System.out.print(s.charAt(index-i));
    	}
    }   
}  