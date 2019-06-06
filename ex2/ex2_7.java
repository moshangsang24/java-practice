/*
content: java experiment
user: Liu
data:
version: 0.0.1
*/    
public class ex2_7  
{  
    public static void main(String[] args)  
    {  
    	People r1=new People("张三",18,"男",1.80);
    	r1.talk("你好！");
    	r1.calAdd(24,35);
    	r1.setName("李四");
    	r1.talk("");
    }   
}  

class People
{

private
	String name;
	int age;
	String sex;
	double height;
public
	People(String name, int age, String sex, double height) 
	{
		this.name=name;
		this.age=age;
		this.sex=sex;
		this.height=height;
	}

	void talk(String words)
	{
		System.out.println("My name is:"+this.name);
		System.out.println(words);
	}

	void calAdd(int a,int b)
	{
		int c=a+b;
		System.out.println(a+"+"+b+"="+c);
	}

	void setName(String rename)
	{
		this.name=rename;
	}


}