/*
content: java experiment
user: Liu
data:
version: 0.0.1
*/    
import java.util.Scanner;

public class ex1_8  
    {  
        public static void main(String[] args)  
        {  
        	code c1;
        	c1=new code();
        	System.out.println("The code is:");
        	c1.showCode();
        	c1.cipher();
        	System.out.println("The ciphered code is:");
        	c1.showCode();
        }   
    }  

class code
{
	int a[] ={0,0,0,0};

	code(){
	 	Scanner scan=new Scanner(System.in);
        System.out.println("Please input the code:");
        int i;
        for(i=0;i<4;i++){
            a[i]=scan.nextInt();
        }
        scan.close();
    }

    void showCode()
    {  
        for(int elem:a){
            System.out.print(elem+" ");
        }
        System.out.println();
    } 

    void cipher(){
    	int i;
    	int tmp;
    	for(i=0;i<4;i++){
    		a[i]=(a[i]+5)%10;
    	}
    	swap(1,4);
    	swap(2,3);
    }
    void swap(int i,int j)
    {
    	i--;
    	j--;
    	int tmp=a[i];
    	a[i]=a[j];
    	a[j]=tmp;
    }

}