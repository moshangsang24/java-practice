 
import java.util.Scanner;
/* CLASS
*@name:ex3_7
*@description:主类用于测试
*/    
public class ex3_7  
{  
    public static void main(String[] args)  
    {  
    	int a=0,b=0;
    	Scanner scan=new Scanner(System.in);
    	System.out.println("Input a&b:");
    	//输入过程
    	a=scan.nextInt();
    	b=scan.nextInt();
    	//创建一个useCompute类
    	useCompute com=new useCompute();
    	//接口回调，创建运算符类
    	compute a1=new add();
    	compute a2=new minus();
    	compute a3=new multiply();
    	compute a4=new divide();
    	//调用useCompute类进行计算
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
//接口compute，定义了一个抽象的计算方法
interface compute
{
	abstract int compute(int n,int m);
}
/* CLASS
*@name: add
*@description:add类实现接口compute中的compute方法
* 用于计算加法
*/    
class add implements compute
{
	public int compute(int n,int m)
	{
		return n+m;
	}
}
/* CLASS
*@name: minus
*@description:add类实现接口compute中的compute方法
* 用于计算减法
*/    
class minus implements compute
{
	public int compute(int n,int m)
	{
		return n-m;
	}
}
/* CLASS
*@name: multiply
*@description:add类实现接口compute中的compute方法
* 用于计算乘法
*/    
class multiply implements compute
{
	public int compute(int n,int m)
	{
		return n*m;
	}
}
/* CLASS
*@name: divide
*@description:add类实现接口compute中的compute方法
* 用于计算除法
*/    
class divide implements compute
{
	public int compute(int n,int m)
	{
		return n/m;
	}
}
/* CLASS
*@name:useCompute
*@description: 用于调用接口和数字实现数字的计算
*/    
class useCompute
{
	public void useCom(compute com,int one,int two)
	{
		System.out.println(com.compute(one,two));
	}
}
