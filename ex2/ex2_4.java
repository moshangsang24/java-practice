/*
content: java experiment
user: Liu
data:
version: 0.0.1
*/    
public class ex2_4  
{  
    public static void main(String[] args)  
    {  
    	clock c1,c2,c3;
    	c1=new clock(5,23,44);
    	c2=new clock(12,3,55);
    	c3=new clock(25,3,01);
    	c1.show();
    	c2.show();
    	c3.show();
    }   
}  

class clock
{
	private int hour,minute,second;
	public clock(int h,int m,int s)
	{
		if(h<0 || h>24){
			System.out.println("The value of hour is between 0~24.");
			return;
		}
		if(m<0 || m>60){
			System.out.println("The value of minute is between 0~60.");
			this.hour=0;
			return;
		}
		if(s<0 || s>60){
			System.out.println("The value of second is between 0~60.");
			this.hour=0;
			this.minute=0;
			return;
		}

		this.hour=h;
		this.minute=m;
		this.second=s;
	}

	void show()
	{
		System.out.printf("The time is: %2d:%02d:%02d\n",this.hour,this.minute,this.second);
	}
}