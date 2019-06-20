/* CLASS
 *@name:ex3_5
 *@description: 多线程的主类，继承Tread类
 *@return description: none
 * 
 */     
public class ex3_5  extends Thread
{  
	int pauseTime;
	String name;
	public ex3_5(String name)
	{
		this.pauseTime=300;
		this.name=name;
	}
	//重载run方法，把多线程主要运行的代码放在里面
	public void run()
	{
		for (int i=0; i<20; i++) {
			//防止出现错误，提高了多线程程序的安全性
			try
			{
				System.out.println(this.name);
				Thread.sleep(pauseTime);
			}
			catch(InterruptedException e)
			{
				System.out.println("Thread Wrong:"+e);
			}
		}
	}
	//main函数测试
    public static void main(String[] args)  
    {  
    	ex3_5 th1=new ex3_5("Thread1");
    	th1.start();
    	ex3_5 th2=new ex3_5("Thread2");
    	th2.start();
    }   
}  