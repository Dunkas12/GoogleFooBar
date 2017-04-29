
public class staircase {

	public static final int maxInput = 200;
	
	public static void main(String[] args)
	{
		System.out.println( answer(3  ) + " should be 1" );
		System.out.println( answer(4  ) + " should be 1" );
		System.out.println( answer(5  ) + " should be 2?" );
		System.out.println( answer(6  ) + " should be 3?" );
		System.out.println( answer(7  ) + " should be 4?" );
		System.out.println( answer(8  ) + " should be 4?" );
		System.out.println( answer(9  ) + " should be 8?" );
		System.out.println( answer(10 ) + " should be 9?" );
		System.out.println( answer(200) + " should be 487067745" );
	}
	
	public static int answer( int n )
	{
		//the question here is how many partitions of n consisting of distinct ints exist, as partitions that consists of distinct ints
		//can be rearanged in an increasing order aka as stairs.
		//the generating function for Q(n) here: http://mathworld.wolfram.com/PartitionFunctionQ.html tell us that Q(n) = the coeff in
		//front of x^n in the inf product of (1+x^i). This coefficient can be calculated simply by evaluating the product from 1 to n.
		//c_n, the coeff infront of x^n is the sum of a_i*b_k for i from 0 to n and k from n to 0, as seen here:
		//https://en.wikipedia.org/wiki/Polynomial_arithmetic#Elementary_operations_on_polynomials , therefore
		
		int[] coeff = new int[maxInput+1];
		coeff[0] = 1;
		
		for(int i = 1; i <= n; i++)
			for(int k = n; k >= i; k--)
				coeff[k] += coeff[k-i];
		
		return coeff[n]-1; 
		//generating function for q(n) includes a 1xn staircase, we dont, hence the -1
	}
	
}
