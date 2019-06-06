/*
content: java experiment
user: Liu
data:
version: 0.0.1
*/    
import java.util.Scanner;

public class ex3_7  
{  
    public static void main(String[] args)  
    {  
    	int a=0,b=0;
    	Scanner scan=new Scanner(System.in);
    	System.out.println("Input a&b:");
    	a=scan.nextInt();
    	b=scan.nextInt();
    	useCompute com=new useCompute();
    	compute a1=new add();
    	compute a2=new minus();
    	compute a3=new multiply();
    	compute a4=new divide();
    	System.out.print(a+"+"+b+"=");
    	com.useCom(a1,a,b);
    	System.out.print(a+"-"+b+"=");
    	com.useCom(a2,a,b);
    	System.out.print(a+"*"+b+"=");
    	com.useCom(a3,a,b);
    	System.out.print(a+"/"+b+"=");
    	com.useCom(a4,a,b);

    }   
}  

interface compute
{
	abstract int compute(int n,int m);
}

class add implements compute
{
	public int compute(int n,int m)
	{
		return n+m;
	}
}
class minus implements compute
{
	public int compute(int n,int m)
	{
		return n-m;
	}
}
class multiply implements compute
{
	public int compute(int n,int m)
	{
		return n*m;
	}
}
class divide implements compute
{
	public int compute(int n,int m)
	{
		return n/m;
	}
}

class useCompute
{
	public void useCom(compute com,int one,int two)
	{
		System.out.println(com.compute(one,two));
	}
}
