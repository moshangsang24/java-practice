/*
content: java experiment
user: Liu
data:
version: 0.0.1
*/    
import java.util.Scanner;

// public class ex2_8  
// {  
//     public static void main(String[] args)  
//     {  
//     	TestClass.main(new String[1]);
//     }   
// }  

class car
{
	String car_num;
	int velocity;
	double carry;

	car()
	{
		this.car_num="XX1234";
		this.velocity=100;
		this.carry=100;
	}

	car(String car_num, int velocity, double carry) 
	{
		this.car_num=car_num;
		this.velocity=velocity;
		this.carry=carry;
	}

	public void addVelocity()
	{
		this.velocity++;
	}
	public void minusVelocity()
	{
		this.velocity--;
	}

	public void setCarNum(String car_num)
	{
		this.car_num=car_num;
	}

	public void getCarry()
	{
		System.out.println(this.carry);
	}
	public void showInfo()
	{
		System.out.println("Car Number:"+this.car_num);
		System.out.println("velocity:"+this.velocity);
		System.out.println("carry:"+this.carry);
	}

}

class TestClass
{
    public static void main(String[] args)  
    {  
    	car r1,r2;
    	r1=new car();
    	r1.setCarNum("9752");
    	r1.addVelocity();
    	r2=new car("5086",150,200);
    	r2.minusVelocity();
    	r1.showInfo();
    	r2.showInfo();

    }   

}