/*
content: java experiment
user: Liu
data:
version: 0.0.1
*/    
import java.util.Scanner;


public class ex1_7  
    {  
    	static int a[]={0,0,0,0,0,0,0,0,0,0};
    	//a=new int[10]={0,0,0,0,0,0,0,0,0,0};
        public static void main(String[] args)  
        {  
            readArray();
            showArray();
            change();
            showArray();
        }   

        static void readArray()
        {   
            Scanner scan=new Scanner(System.in);
            int i;
            for(i=0;i<10;i++){
                a[i]=scan.nextInt();
            }

        }
        static void showArray()  
        {  
        	int i=0;
        	for(i=0;i<10;i++){
        		System.out.print(a[i]);
        	}
        		System.out.println();
        }  
        static void change()
        {
        	int i,j,mx=a[0],mn=a[0];
        	int ix=0;
        	int in=0;
        	for(i=0;i<10;i++)
        	{
        		if(a[i]>mx){mx=a[i];ix=i;}
                if(a[i]<mn){mn=a[i];in=i;}
        	}
            System.out.println("The max of the Array is:"+mx);
            System.out.println("The min of the Array is:"+mn);
            a[ix]=mn;
            a[in]=mx;

        }
    }  