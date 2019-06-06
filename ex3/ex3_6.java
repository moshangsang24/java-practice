/*
content: java experiment
user: Liu
data:
version: 0.0.1
*/    
public class ex3_6  
{  
    public static void main(String[] args)  
    {  
    	E e=new E();
    	E.main();
    }   
}  
interface Interface_A
{
	abstract int method(int n);
}

class A implements Interface_A
{
	public int method(int n)
	{
		int s=0;
		for(int i=1;i<=n;i++)
		{
			s+=i;
		}
		return s;
	}
}

class B implements Interface_A
{
	public int method(int n)
	{
		int s=1;
		for(int i=2;i<=n;i++)
		{
			s*=i;
		}
		return s;
	}
}

class E
{
	public static void main()
	{
		Interface_A a;
		a=new A();
		System.out.println(a.method(5));
		a=new B();
		System.out.println(a.method(5));
	}
}