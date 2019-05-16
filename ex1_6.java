/*
content: java experiment
user: Liu
data:
version: 0.0.1
*/    
import java.util.Scanner;
public class ex1_6  
    {  
    	static int a[]={1,2,3,4,5,6,7,8,9,0};
        public static void main(String[] args)  
        {  
        	Scanner scan=new Scanner(System.in);
            System.out.println("Input m, and m<10:");
        	int n=scan.nextInt();
        	System.out.println("The original array:");
        	showArray();
        	move(n);
        	System.out.println("The changed array:");
        	showArray();

        }   

        static void move(int n)  
        {  
            int i=0;
            int tmp[];
            tmp=new int[10];
            for(i=9;i>=0;i--)
            {
            	if(i>=10-n) tmp[i]=a[i];
            	else
            	{
	        		a[i+n]=a[i];
	        		if(i<n){
	        			
	        		}
            	} 
            }
            for (i=0; i<n; i++) {
            	a[i]=tmp[i+10-n];
            }
        }   

        static void showArray()  
        {  
        	int i=0;
        	for(i=0;i<10;i++){
        		System.out.println(""+a[i]);
        	}
        }   
    }  