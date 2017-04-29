import java.math.BigInteger;

public class baby_bomb {

	public static void main(String[] args)
	{
		String m = "2";
		String f = "4";
		
		System.out.println( answer(m, f) );
	}
	
	public static String answer(String M, String F) 
	{ 
		BigInteger m = new BigInteger(M);
        BigInteger f = new BigInteger(F);
        BigInteger div = new BigInteger("-1");
        final BigInteger zero = new BigInteger("0");
        final BigInteger one = new BigInteger("1");
        String out;
        BigInteger i = new BigInteger("0");
        
        while(f.compareTo(m) != 0 && f.compareTo(zero) == 1 && m.compareTo(zero) == 1) // f!=m f>0 && m>0
        {
        	i = i.add(one);
        	
        	//DEBUGGING
        	System.out.print("M: " + m);
        	System.out.print(" F: " + f + "\n");
        	System.out.println("I: " + i + "\n");
        	
        	if(f.compareTo(m) == 1) {// f > m
        		div = f.divide(m);				   //(variable) div = f (operator) div m
        		f = f.subtract( div.multiply(m) ); // f= f mod m 
        		
        		i = i.add(div.subtract(one)); 
        	}
        	else {
        		
        		div = m.divide(f);				   //(variable) div = f (operator) div m
        		m = m.subtract( div.multiply(f) ); // f= f mod m 
        		
        		i = i.add(div.subtract(one));
        	}
        	
        }
        
        //DEBUGGING
    	System.out.print("M: " + m);
    	System.out.print(" F: " + f);
    	System.out.println(" I: " + i + "\n");
    	
        if( ( f.compareTo(one) == 0 && m.compareTo(zero) == 0 ) //f == 1 && m == 0
         || ( m.compareTo(one) == 0 && f.compareTo(zero) == 0 ))//f == 0 && m == 1 
        	out = i.subtract(one).toString();
        else
        	out = "impossible";
        
		return out;
    }
	
}
