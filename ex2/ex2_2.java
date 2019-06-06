/*
content: java experiment
user: Liu
data:
version: 0.0.1
*/    
public class ex2_2  
{  
    public static void main(String[] args)  
    {  
    	XiYouJiRenWu zhuBaJie,sunWuKong;
    	zhuBaJie=new XiYouJiRenWu("猪八戒","九尺兵耙",3.3);
    	sunWuKong=new XiYouJiRenWu("孙悟空","金箍棒",4.6);
    	zhuBaJie.printName();
    	zhuBaJie.printWeapon();
    	sunWuKong.printName();
    	sunWuKong.printWeapon();
    }   
} 


 class XiYouJiRenWu
 {
 	private double height;
 	private String name;
 	private String weapon;

 	public XiYouJiRenWu(String name,String weapon,double height)
 	{
 		this.name=name;
 		this.weapon=weapon;
 		this.height=height;
 	}

 	public void printName()
 	{
 		System.out.println("The name of this character is:"+this.name);
 	}

 	public void printWeapon()
 	{
 		System.out.println("The weapon of this character is:"+this.weapon);
 	}

 }