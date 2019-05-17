/*
content: java experiment
user: Liu
data:
version: 0.0.1
*/    
public class ex1_3


    {  
		public static int a[]=new int[3];
        public static void main(String[] args)  
        {  
        	print_p(0);
            System.out.println("Complete!");  
        } 

        static void showArray()
        {  
        	int i=0;
        	for (; i<3; i++) {
        	  	System.out.print(""+a[i]);
        	}  
        	System.out.println("");
        }   

        static void print_p(int cur)
        {  
        	int i=0;
        	int j=0;
        	if(cur==3){
        		showArray();	
        	}
        	else for (i=1;i<=4;i++) {
        		boolean ok=true;
        		for(j=0;j<cur;j++)
        			if(a[j]==i) ok=false;
        		if (ok){
	        		a[cur]=i;
	        		print_p(cur+1);
	        		// a[cur]=0;
        		}

        	}
        	  
        }   

    }  