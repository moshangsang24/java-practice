/*
content: java experiment
user: Liu
data:
version: 0.0.1
*/    

/* CLASS
*@name: ex2_3
*@description:
*/    
public class ex3_2  
{  
    public static void main(String[] args)  
    {  
    	PlainRect p1=new PlainRect();
    	if(p1.isInside(2,3))
    		System.out.println("In.");
    	else {
    		System.out.println("Not in.");
    	}
    }   
}  
/* CLASS
*@name: Rect
*@description: 长方形类，有高和宽两个成员，两个构造函数
* 还有两个返回面积和周长的方法
*/    
class Rect
{
	protected
	double weight;
	double height;
	public
	Rect(double weight, double height)
	{
		this.weight=weight;
		this.height=height;
	}
	Rect()
	{
		this.weight=10;
		this.height=10;
	}
	void area()
	{
		System.out.println("The area of the rectangular is:"+this.weight*this.height);
	}
	void perimeter()
	{
		System.out.println("The perimeter of the rectangular is:"+2*(this.weight+this.height));
	}
}
/* CLASS
*@name: PlianRect
*@description:长方形类，继承自Rect类，加入了起点坐标，增加了两个构造方法
* 有一个方法判断点是不回在长方形中
*/    
class PlainRect extends Rect
{
	double startX;
	double startY;
	PlainRect(double weight, double height, double startX, double startY)
	{
		super(weight,height);
		this.startX=startX;
		this.startY=startY;
	}
	PlainRect()
	{
		super(0.0,0.0);
		this.startX=0;
		this.startY=0;
	}
	//判断点是不回在长方形中，点x和y是传入的参数，返回的是一个boolean值
	boolean isInside(double x,double y)
	{
		if(x >=startX && x <=(startX+weight)&&y >=startY && y <=(startY-height) )
			return true;
		else
			return false;
	}
}