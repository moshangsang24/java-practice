/*
content: java experiment
user: Liu
data:
version: 0.0.1
*/    
public class ex1_31  
    {  
        public static void main(String[] args)  
        {  
        	int t=print_p();
        	System.out.printf("There are %d numbers.\n",t);
            System.out.println("Complete!");  
        }
        static int print_p()
        {  
        	int i=0,j=0,k=0;
        	int time=0;
        	for (i=1; i<5; i++) {
        	  	for (j=1; j<5; j++) {
        	  		for (k=1;k<5;k++ ) {
        	  			if(i!=j && j!=k && i!=k){
        	  				System.out.print(i);
        	  				System.out.print(j);
        	  				System.out.print(k);
        	  				System.out.println();
        	  				time++;
        	  		}
        	  	}
        	  }  
        }   
        return time;

    } 
    } 