/* CLASS
*@name:ex3_6	
*@description:主类，用于调用测试类test
*/    
public class ex3_6  
{  
    public static void main(String[] args)  
    {  
    	E e=new E();
    	E.main();
    }   
}  
//接口A，定义了method方法
interface Interface_A
{
	abstract int method(int n);
}
/* CLASS
*@name: A
*@description:类A实现了接口A中的method方法
*用于计算求和
*/  
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

/* CLASS
*@name: B
*@description:类B实现了接口A中的method方法
* 用于计算阶乘
*/    
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
/* CLASS
*@name: E
*@description:类E用于测试两个接口
*/    
class E
{
	public static void main()
	{
		//这里使用了接口回调
		Interface_A a;
		a=new A();
		System.out.println(a.method(5));
		a=new B();
		System.out.println(a.method(5));
	}
}