/*
content: java experiment
user: Liu
data:
version: 0.0.1
*/    

import java.util.Scanner;
public class ex1_5  
    {  
    	static int a[]={1,3,5,7,9,0};
        public static void main(String[] args)  
        { 
        	Scanner scan=new Scanner(System.in);
          	System.out.println("Please input a num:");  
        	int value=scan.nextInt();
        	showArray();
        	my_sort(value);
        	showArray();
        	scan.close();

        }   

        static void my_sort(int n)  
        {  
             int i=0;
             int j=0;
             for(i=0;i<5;i++)
             {
             	if(a[i]<n) continue;
             	for(j=5;j>i;j--)
             	{
             		a[j]=a[j-1];
             	}
             	a[i]=n;
             	return;
             }
        }   

        static void showArray()  
        {  
        	int i=0;
        	for(i=0;i<6;i++){
        		System.out.println(" "+a[i]);
        	}
        }   
    }  