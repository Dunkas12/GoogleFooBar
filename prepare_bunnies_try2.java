/*
import java.util.ArrayList;

public class prepare_bunnies_try2 {
		
		public static void main(String[] args)
		{
			int[][] input = { 
								{0,1,1,1,1,1},
								{0,0,0,0,0,0},
								{0,1,1,1,1,0},
								{0,0,0,0,1,0},
								{1,1,1,0,1,0},
								{0,0,0,0,1,0},
								{0,1,1,1,1,0},
								{0,0,0,0,0,0}
							};
			
			System.out.println( answer(input) +1);
		}
		
		public static int answer(int[][] maze) { 
			
			int n = maze[0].length; //n==x
			int m = maze.length;	//m==y
			
			maze[0][0] = -1;
			maze[m-1][n-1] = -1;

			ArrayList<int[]> explorers = new ArrayList<int[]>();
			explorers.add(new int[]{0,0} );
			explorers.add(new int[]{m-1,n-1} );
					
			
			
			return -1;
	    }//end answer
		
		public int[][] getPaths(int[] explorer, int[][] maze)
		{
			int[][] possableDirections = getAdjacent(explorer);
			
			
			for(int i = 0; i < possableDirections[0].length; i++ )
				if( isValidMove(possableDirections[0][i], possableDirections[1][i], maze) )
		}
}
*/