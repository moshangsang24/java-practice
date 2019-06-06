/*
content: java experiment
user: Liu
data:
version: 0.0.1
*/    
public class ex2_3  
{  
    public static void main(String[] args)  
    {  
    	account a1;
    	a1=new account("10000");
    	a1.showBalance();
    	a1.deposit(1000);
    	a1.showBalance();
    	a1.withdraw(500);
    	a1.showBalance();
    }   
}  

class account
{
	private String account_name;
	private int balance;

	public account(String name)
	{
		this.account_name=name;
		this.balance=0;
	}

	public void deposit(int amount)
	{
		this.balance+=amount;
	}

	public void withdraw(int amount)
	{
		if(amount<0){
			System.out.println("Please input a correct amount!");
		}
		else if(this.balance<amount)
			System.out.println("Your balance is not enough!");
		else
			this.balance-=amount;

	}

	public void showBalance()
	{
		System.out.println("Your account has:"+this.balance+"$!");
	}
}