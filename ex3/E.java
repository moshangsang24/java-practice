/* CLASS
*@name:E
*@description:主类E，用于测试
*/    
public class E  
{  
    public static void main(String[] args)  
    {  
    	InterfaceA a=new Print();
    	a.printCapitalLetter();
    	InterfaceB b=new Print();
    	b.printLowercaseLetter();
    }   
}  
/* @INTERFACE
*@name: InterfaceA
*@description: 含有打印大写字母表方法
*/    
interface InterfaceA
{
	abstract void printCapitalLetter();
}
/* @INTERFACE
*@name: InterfaceB
*@description: 含有打印小写字母表方法
*/ 
interface InterfaceB
{
	abstract void printLowercaseLetter();
}
/* CLASS
*@name:Print
*@description:实现了两个接口中的方法，A接口中的打印
*大写字母表方法，B接口中的打印小写字母表中的方法
*/    
class Print implements InterfaceA,InterfaceB
{
	public void printCapitalLetter()
	{
		System.out.println("************************");
		System.out.println("     The Alphabet");
		for(int i=1;i<=26;i++){
			//int强制转化成char
			char c=(char)(i+64);
			System.out.print(c+" ");
			if(i%6==0)
				System.out.println("");
		}
		System.out.println("\n************************");

	}
	public void printLowercaseLetter()
	{
		System.out.println("************************");
		System.out.println("     The alphabet");
		for(int i=1;i<=26;i++){
			//int强制转化成char
			char c=(char)(i+96);
			System.out.print(c+" ");
			if(i%6==0)
				System.out.println("");
		}
		System.out.println("\n************************");
	}

}

