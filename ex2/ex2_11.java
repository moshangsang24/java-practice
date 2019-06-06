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
    	int index=0;
    	int res=0,mid;
    	for(int i=0;i<s.length();i++)
    	{
    		mid=1;
    		for(int j=1;j<=s.length();j++){
    			if(i-j<0 || i+j>=s.length() || s.charAt(i-j)!=s.charAt(i+j))
    			{
    				break;
    			}
    				mid+=2;
    		}
    		if(mid>res){
    			res=mid;
    			index=i-res/2;
    		}
	    	mid=0;
	    	for(int j=1;j<=s.length();j++)
	    	{
	    		if(i+1-j<0 || i+j>=s.length()|| s.charAt(i-j+1)!=s.charAt(i+j))
	    			break;
	    		mid+=2;
	    	}
    		if(mid>res){
    			res=mid;
    			index=i-res/2+1;
    		}
    	}
    	System.out.println(s.substring(index,index+res));
    }   
}  