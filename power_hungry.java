import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class power_hungry {

	public static void main(String[] args)
	{
		/*
		Random rand = new Random();
		int len = rand.nextInt(51);
		
		int[] in = new int[len];
		
		for(int i = 0; i < len; i++)
		{
			in[i] = rand.nextInt(2001) -1000;
			System.out.println(i + "	" + in[i]);
		}
		*/
		int[] in = {0};
		System.out.println("Ans: " + answer(in));
		
	}
	
	public static String answer(int[]xs) {
		
		BigInteger product = new BigInteger("1");
		
		List<Integer> lst = new ArrayList<Integer>(); 
		//the list is so that the smallest negative number will be left behind if there are an odd number of negatives
		
		for(int i = 0; i < xs.length; i++) //iterate the list 
		{
			
			if( xs[i] > 0) //if t > 0 multiply
				product = product.multiply( BigInteger.valueOf( xs[i] ) );
			else if( xs[i] < 0 ) //if t < 0
			{
				if( lst.size() >= 2)//if list will be made full  
				{
					lst.add(xs[i]);
					Collections.sort(lst);				
					product = product.multiply( BigInteger.valueOf( lst.get(0)*lst.get(1) ) );
					lst.remove(0); // removes one, two takes one's spot, remove one
					lst.remove(0);
				}
				else //otherwise add to the list
					if(lst.size() < 1)
						lst.add(0, xs[i]);
					else
						lst.add(1, xs[i]);	
			}
		}
		
			if( lst.size() == 2) //if we are left with two negatives, multiply
				product = product.multiply( BigInteger.valueOf( lst.get(0)*lst.get(1) ) );
			
		return product.toString();
    }
	
	
}
