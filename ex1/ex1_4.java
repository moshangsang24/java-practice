package ex1;
/*
content: java experiment
user: Liu
data:
version: 0.0.1
*/   

public class ex1_4  
   {  
       public static void main(String[] args)  
       {  
           System.out.println("The sum is:"+cal());  
       }

       static double cal()  
       {  
            double m=1;
            double n=1;
            double k=0;
            double sum=0;
            int i=1;
            for(i=1;i<=20;i++)
            {
            	k=m+n;
            	sum+=k/n;
            	m=n;
            	n=k;
            }
            return sum;

       }   

   }

  