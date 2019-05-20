
public class ex1_2 {
	public static void main(String[] args)
	{
		int i;
		int sum=0;
		for(i=1;i<11;i++) {
			sum+=factor(i);
		}
		System.out.println("1!+2!+...+10!="+sum);
	}
	
 	static int factor(int n) {
		int tem=1;
		int i=1;
		while(i<=n) {
			tem*=i;
			i++;
		}
		return tem;
	}

}