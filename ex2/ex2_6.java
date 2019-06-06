/*
content: java experiment
user: Liu
data:
version: 0.0.1
*/    
import java.util.Scanner;

public class ex2_6  
{  
    public static void main(String[] args)  
    {  
    	Scanner scan=new Scanner(System.in);
    	System.out.println("Input a num (1 or 2):");
    	int a=scan.nextInt();
    	print p;
    	p=new print();
    	p.output(a);
    	a=scan.nextInt();
    	p.output(a);
    	scan.close();
    }   
}  

class print
{
	private void output(int x)
	{
		if(x==1) 
			showAlphabet();
		else if(x==2) 
			showalphabet();
		else
			System.out.println("Please input 1 or 2!");
	}

	private void showAlphabet()
	{
		System.out.println("************************");
		System.out.println("     The Alphabet");
		for(int i=1;i<=26;i++){
			char c=(char)(i+64);
			System.out.print(c+" ");
			if(i%6==0)
				System.out.println("");
		}
		System.out.println("\n************************");
	} 
	private void showalphabet()
	{
		System.out.println("************************");
		System.out.println("     The alphabet");
		for(int i=1;i<=26;i++){
			char c=(char)(i+96);
			System.out.print(c+" ");
			if(i%6==0)
				System.out.println("");
		}
		System.out.println("\n************************");
	} 
}