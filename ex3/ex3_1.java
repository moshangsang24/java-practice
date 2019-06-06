/* CLASS
*@name: Person
*@description:一个person类，里面有人的基本信息
* 
*/    
class Person
{
	String name;
	String adress;
	String telphone;
	String email;
	Person(String name, String adress, String telphone, String email) 
	{
		this.name=name;
		this.adress=adress;
		this.telphone=telphone;
		this.email=email;
	}
}
/* CLASS
*@name: Employee
*@description: 员工类，继承自People类，里面有员工的一些信息
* 
*/    
class Employee extends Person
{
	String office;
	double wage;
	String hiredate;
	Employee(String name, String adress, String telphone, String email,
		String office,double wage,String hiredate)
	{
		super(name,adress,telphone,email);
		this.office=office;
		this.wage=wage;
		this.hiredate=hiredate;

	}
}
/* CLASS
*@name: Faculty 类，继承自员工类，里面加入了学位和级别两个成员
*@description:
*/    
class Faculty extends Employee
{
	String degree;
	String level;
	Faculty(String name, String adress, String telphone, 
		String email, String office,double wage,
		String hiredate,String degree, String level)
	{
		super(name,adress,telphone,email,office,wage,hiredate);
		this.degree=degree;
		this.level=level;
	}

	void test()
	{
		System.out.println("name:"+this.name);
		System.out.println("adress:"+this.adress);
		System.out.println("telphone:"+this.telphone);
		System.out.println("email:"+this.email);
		System.out.println("office:"+this.office);
		System.out.println("wage:"+this.wage);
		System.out.println("hiredate:"+this.hiredate);
		System.out.println("degree:"+this.degree);
		System.out.println("level:"+this.level);
	}
}
/* CLASS
*@name:
*@description: Staff类，继承自员工类，加入了两个成员方法
*@return description: none
* 
*/    
class Staff extends Employee
{
	String duty;
	Staff(String name, String adress, String telphone, 
		String email, String office,double wage,
		String hiredate,String duty)
	{
		super(name,adress,telphone,email,office,wage,hiredate);
		this.duty=duty;
	}

	void test()
	{
		System.out.println("name:"+this.name);
		System.out.println("adress:"+this.adress);
		System.out.println("telphone:"+this.telphone);
		System.out.println("email:"+this.email);
		System.out.println("office:"+this.office);
		System.out.println("wage:"+this.wage);
		System.out.println("hiredate:"+this.hiredate);
		System.out.println("duty:"+this.duty);

	}
}
/* CLASS
*@name: ex3_1
*@description: 主类，其中有main方法，用于测试类的正确与否，创建成员并调用test方法
* 
*/    
public class ex3_1  
{  
    public static void main(String[] args)  
    {  
    	Staff s=new	Staff("Liu","CUMTB","8888888","df@163.com","111"
    		,3000,"2000.1.1","doctor");
    	s.test();
    	System.out.println();
    	Faculty f=new Faculty("Liu","CUMTB","8888888","df@163.com","111"
    		,3000,"2000.1.1","doctor","p8");
    	f.test();

    }   
}  

