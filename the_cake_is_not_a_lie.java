public class the_cake_is_not_a_lie {

	public static void main(String[] args)
	{
		String input="a";
		
		System.out.println( answer(input) );
	} 
	
 
	public static int answer(String s) {
		int increment;
		int out = -1;
		boolean isInvalid;
		int[] factors = getFactors(s.length());
		
		//for as many times as there are groups
		for(int i = 0; i < factors.length; i++)
		{
			increment = factors[i];
			isInvalid = false;
			
			//System.out.println(factors[i]);
			
			//iterate the string to check if it is composed of the substring of length factors[i]
			for(int k = increment; k+increment <= s.length() && !isInvalid; k+= increment) 
			{
				//System.out.println("k: " + k + "inc: " + increment);
				if(!s.substring(k-increment, k).equals(s.substring(k, k+increment)) || increment == 0)
					isInvalid = true;
			}
			
			if(!isInvalid)
			{
				out = s.length()/factors[i];
				i=factors.length;
			}
		}
		
		return out;
	}//end answer
	
	public static int[] getFactors(int n){ //Factor the length to get every possable permutation of n characters
		double f; //f is a possable factor
		int k = 0; //a counter that only increments when a factor is found
		int[] factors = new int[1+n/2];
		
		// i < f would give us all the combinations, from which we could get the permutations, but since n<200 this is basically O(c)
		for(int i = 0; i < n; i++)
		{
			f=(double )(n)/(double)(i+1);
			
			if( f % 1 == 0 ) //if f is an integer == if n is divisable by i
			{
				factors[k] = i+1; 
				k++;
			}
			
		}
		
		return factors;
	}//end getFactors
	
}
