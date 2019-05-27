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
        System.out.println("The original array is:");
    	showArray();
      	System.out.println("Please input a num:");  
    	int value=scan.nextInt();
    	my_sort(value);
        System.out.println("The changed array is:");
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
    	for(int elem:a){
    		System.out.print(elem+" ");
    	}
        System.out.println();
    }   
}  