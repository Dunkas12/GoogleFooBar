
public class en_route_salute {

	public static void main(String[] args)
	{
		String input = ">";
		
		System.out.println( answer(input) );
	}
	
	public static int answer(String s) { 

		char[] st = s.toCharArray();
		int n = 0;
		
        for(int i = 0; i < st.length; i++)
        {
        	
        	if(st[i] == '>')
        		for(int k = i+1; k < st.length; k++) //increment n by two for every < in front of a >
        		{
        			if(st[k] == '<')
        				n+=2;
        		}
        	
        }
		
		return n;
    } 
	
}
