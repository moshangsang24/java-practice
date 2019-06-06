/*
content: java experiment
user: Liu
data:
version: 0.0.1
*/    
public class ex2_5  
{  
    public static void main(String[] args)  
    {  
    	student s1,s2;
    	s1=new student(10001,"liu",22);
    	s2=new student(10002,"wang",23);
    	s1.outPut();
    	s2.outPut();
    }   
}  

class student
{
	int stuNo;
	String name;
	int age;

	public student(int stuNo,String name,int age)
	{
		this.stuNo=stuNo;
		this.name=name;
		this.age=age;
	}

	public void outPut()
	{
		System.out.println("StudentNo:     Name       Age");
		System.out.printf("%-14d %-10s %-4d\n",this.stuNo,this.name,this.age);
	}

}