import java.util.ArrayList;
import java.util.Arrays;

public class Answer {
	
	public static final int PATH = 0;
	public static final int WALL = 1;
	
	public static int bunnies(int[][] maze) { 

		//for some reason maze.clone() does not work as I think it should on arrays. 
		int[][] startMaze = new int[maze.length][maze[0].length];
		
		for(int i = 0; i < maze.length; i++)
			for(int k = 0; k < maze[0].length; k++)
				startMaze[i][k] = maze[i][k];
		
		int[][]   endMaze = new int[maze.length][maze[0].length];
		
		for(int i = 0; i < maze.length; i++)
			for(int k = 0; k < maze[0].length; k++)
				endMaze[i][k] = maze[i][k];
		
		mazeRunner startRunner = new mazeRunner(new int[]{0, 0}, 0, startMaze);
		mazeRunner   endRunner = new mazeRunner(new int[]{0, 0}, 0,  endMaze);
		
		startRunner.moveTo( new int[]{0,0} );
		  System.out.println( endRunner.moveTo( new int[]{maze[0].length-1 ,maze.length-1} ) );
		  
		
		ArrayList<mazeRunner> startRunners = new ArrayList<mazeRunner>();
		ArrayList<mazeRunner>   endRunners = new ArrayList<mazeRunner>();
		
		startRunners.add(startRunner);
		endRunners.add(endRunner);
		
		boolean notAllStuck = true;
		
		boolean startIsNotStuck = true;
		boolean   endIsNotStuck = true;
		
		//Debugging code: this visualizes the arrays
		System.out.println("Start:");
		for(int[] col : startMaze)
			System.out.println(Arrays.toString( col ));
		System.out.println("End:");
		for(int[] col : endMaze)
			System.out.println(Arrays.toString( col ));
		System.out.println("");
		//*/
		while( notAllStuck )
		{
			startIsNotStuck = increment( startRunners , maze);
			  endIsNotStuck = increment( endRunners   , maze);
			  
			notAllStuck =( startIsNotStuck || endIsNotStuck );
			//if we did notAllStuck = (increment( startRunners , maze) || increment( endRunners   , maze)) then short circuit evaluation
			//( https://en.wikipedia.org/wiki/Short-circuit_evaluation ) would make startRunners finish before end runners begain. 
			
			
			///Debugging code: this visualizes the arrays
			System.out.println("Start:");
			for(int[] col : startMaze)
				System.out.println(Arrays.toString( col ));
			System.out.println("End:");
			for(int[] col : endMaze)
				System.out.println(Arrays.toString( col ));
			System.out.println("");
			//*/
		}
		
		int[][] resultant = new int[maze.length][maze[0].length];
		int shortestPath = 2147483647; 								//just a placeholder until we populate resultant
		
		for(int y = 0; y < maze.length; y++)
			for(int x = 0; x < maze[0].length; x++) {
				if(startMaze[y][x] < 0 && endMaze[y][x] < 0) { //if both startRunners and endRunners can get to this position 
					resultant[y][x] = startMaze[y][x] + endMaze[y][x];
					
					if( Math.abs( resultant[y][x] ) < Math.abs( shortestPath )){
						shortestPath = resultant[y][x]; 	 
					}
				}
				
			}
		
		shortestPath = Math.abs( shortestPath )-1; //minus one because we are summing the moves from both the end and begining, thus 
												   //we count moving into the meeting position twice. (At least thats what I think)
		
		return shortestPath;
	}											   

	
	//returns false if all mazeRunners in runners are stuck, true otherwise
	public static boolean increment( ArrayList<mazeRunner> runners , int[][] maze){ 
		
		boolean allStuck = true;
		ArrayList<int[]> validDirections;
		
		//this loop decrements so mazeRunners added durring this loop do not affect the number of times the loop executes
		for(int i = runners.size()-1; i >= 0; i--) {
			validDirections = runners.get(i).getValidDirections();
			System.out.println("Directions: " + validDirections.size());
			
			if(validDirections.size() > 0) {
				allStuck = false;
				
				runners.get(i).moveTo( validDirections.get(0) ); //put the first runner in the first direction
				
				if(validDirections.size() > 1)
				{		
					for(int k = 1; k < validDirections.size(); k++) //create more runners for other directions as needed
						runners.add( new mazeRunner( validDirections.get(k), runners.get(i).getSteps(), runners.get(i).getMaze()) ); 
						//new runner inherits its parents steps
				}	
			}//end validDirections > 0
				
		}//end for
		
		return !allStuck;
	}//end increment
	
	
}

//mazeRunners navagate the maze keeping track of exactly how many steps it is to every tile on the maze by storing steps to a matrix
class mazeRunner 
{
	public final int PATH = 0;
	public final int WALL = 1;
	
	private int Xcurrent, Ycurrent, steps;
	private int[] left, up, right, down;
	private int [][] maze;
	private boolean isStuck;
	
	public mazeRunner(int[] currentXY,  int stepsIN, int[][] mazeIN)
	{
		this.Xcurrent = currentXY[0];
		this.Ycurrent = currentXY[1];
		this.steps = stepsIN;
		this.maze = mazeIN;
		this.isStuck = false;
		this.left  = new int[]{ this.Xcurrent-1 , this.Ycurrent   };
		this.up    = new int[]{ this.Xcurrent   , this.Ycurrent-1 };
		this.right = new int[]{ this.Xcurrent+1 , this.Ycurrent   };
		this.down  = new int[]{ this.Xcurrent   , this.Ycurrent+1 };
		this.maze[this.Ycurrent][this.Xcurrent] = -(this.steps);
	}
	
	public int[][] getDirections(){
		
		return new int[][]{
		{ this.Xcurrent-1 , this.Ycurrent   },
		{ this.Xcurrent   , this.Ycurrent-1 },
		{ this.Xcurrent+1 , this.Ycurrent   },
		{ this.Xcurrent   , this.Ycurrent+1 } }; 
	}
	
	public int getX(){
		return this.Xcurrent;
	}
	
	public int getY(){
		return this.Ycurrent;
	}

	public int getSteps(){
		return this.steps;
	}
	
	public void setSteps(int stepsIN){
		this.steps = stepsIN;
	}
	
	public boolean IsStuck(){
		return this.isStuck;
	}
	
	public void setIsStuck( boolean newIsStuck ){
		this.isStuck = newIsStuck;
	}
	
	public int[][] getMaze(){
		return this.maze;
	}
	
	public ArrayList<int[]> getValidDirections()
	{
		ArrayList<int[]> validDirections = new ArrayList<int[]>();
		
		for(int[] possableDir : this.getDirections())
			if( this.isValidMove( possableDir ) )
				validDirections.add( possableDir );
		
		return validDirections;
	}
	
	public boolean isValidMove(int[] xy)
	{
				return (	
							isInMatrix(xy)
						 && this.maze[xy[1]][xy[0]] == PATH		//the location is a path
					   );
		
	}

	public boolean isInMatrix(int[] xy)
	{
		return (
				    xy[0] >= 0 && xy[0] < this.maze[0].length 	//x is in the matrix
				 && xy[1] >= 0 && xy[1] < this.maze.length	    //y is in the matrix
			   );
	}
	
	public boolean moveTo( int[]xy ) { //returns true if the location is valid and the mazeRunner has moved
		
		boolean out = true;
		
		if( this.isValidMove(xy) ) {
			this.steps++;
			//make this position in the maxtix hold the number of steps it takes to get there 
			//we count from -1 to -inf so we dont confuse a wall with a tile we have already been to
			this.maze[xy[1]][xy[0]] = -(this.getSteps()); 
			
			//update instance variables:
			
			this.Xcurrent = xy[0];
			this.Ycurrent = xy[1];
			
			this.left[0] = xy[0]-1;
			this.left[1] = xy[1];
			
			this.up[0]   = xy[0];
			this.up[1]   = xy[1]-1;
			
			this.right[0]   = xy[0]+1;
			this.right[1]   = xy[1];
			
			this.down[0]    = xy[0];
			this.down[1]    = xy[1]+1;
			
			//if an adjacent tile is a wall, make it a tile that takes 1 extra step
			for( int[] pos : this.getDirections() )	
				if( isInMatrix(pos) && this.maze[ pos[1] ][ pos[0] ] == WALL)			
					this.maze[ pos[1] ][ pos[0] ] = -(this.steps+1); 	
		}
		else
			out = false;
		
		return out; 
	}
}