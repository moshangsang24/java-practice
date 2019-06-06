/*
content: java experiment
user: Liu
data:
version: 0.0.1
*/    
import java.util.Scanner;

public class ex2_1  
{  
    public static void main(String[] args)  
    {  
        lader l1=new lader(1.0,2.0,8.0);
        lader l2=new lader(2.0,3.0,4.0);
        l1.getArea();
        l2.getArea();
        circle c1=new circle(3.3);
        circle c2=new circle(5.0);
        c1.getPerimeter();
        c1.getArea();
        c2.getPerimeter();
        c2.getArea();

    }   

}  

class lader
{
	private double upper_line;
	private double lower_line;
	private double height;
	private double area;
	public lader(double upper_line,double lower_line,double height)
	{	
		this.upper_line=upper_line;
		this.lower_line=lower_line;
		this.height=height;
		this.area=(upper_line+lower_line)/2;
	}
	public void getArea()
	{
		System.out.println("The area of this lader is:"+this.area);
	}
}

class circle
{
	private double r;
	private double perimeter,area;
	static final double PI=3.1415926;
	public circle(double r)
	{
		this.r=r;
		this.perimeter=2*PI*r;
		this.area=PI*r*r;
	}
	public void getArea()
	{
		System.out.println("The area of this circle is:"+this.area);
	}

	public void getPerimeter()
	{
		System.out.println("The perimeter of this circle is:"+this.perimeter);
	}

}