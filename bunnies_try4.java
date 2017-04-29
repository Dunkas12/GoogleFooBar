
public class bunnies_try4 {

	public static int answer(int[][] maze) { 

       
		return -1;
	}
	
}

/*
class mazeRunner //optionaly named bunnies
{
	private int Xcurrent, Ycurrent, Xlast, Ylast;
	private int[] left, up, right, down;
	private int [][] directions;
	private int [][] maze;
	private int steps;
	
	public mazeRunner(int XcurrentIN, int YcurrentIN, int  XlastIN, int YlastIN, int stepsIN, int[][] mazeIN)
	{
		this.Xcurrent = XcurrentIN;
		this.Ycurrent = YcurrentIN;
		this.Xlast = XlastIN;
		this.Ylast = YlastIN;
		this.steps = stepsIN;
		this.maze = mazeIN;
		
		this.left  = new int[]{ this.Xcurrent-1 , this.Ycurrent   };
		this.up    = new int[]{ this.Xcurrent   , this.Ycurrent+1 };
		this.right = new int[]{ this.Xcurrent+1 , this.Ycurrent   };
		this.down  = new int[]{ this.Xcurrent   , this.Ycurrent-1 };
		
		directions = new int[][]{this.left, this.up, this.right, this.down};
	}
	
	public mazeRunner(int[] currentXY, int[] lastXY, int stepsIN, int[][] mazeIN)
	{
		this.Xcurrent = currentXY[0];
		this.Ycurrent = currentXY[1];
		this.Xlast = lastXY[0];
		this.Ylast = lastXY[0];
		this.steps = stepsIN;
		this.maze = mazeIN;
		
		this.left  = new int[]{ this.Xcurrent-1 , this.Ycurrent   };
		this.up    = new int[]{ this.Xcurrent   , this.Ycurrent+1 };
		this.right = new int[]{ this.Xcurrent+1 , this.Ycurrent   };
		this.down  = new int[]{ this.Xcurrent   , this.Ycurrent-1 };
		
		directions = new int[][]{this.left, this.up, this.right, this.down};
	}
	
	public void setPosition(int Xnew, int Ynew)
	{
		System.out.println("SetPosition Called ***");
		if(Xnew == this.Xlast && Ynew == this.Ylast)
			System.out.println("******* GOING BACKWARDS *******");
		
		this.Xlast = this.Xcurrent;
		this.Ylast = this.Ycurrent;
		this.Xcurrent = Xnew;
		this.Ycurrent = Ynew;
	}
	
	public int getSteps()
	{
		return steps;
	}
	
	public int[][] getDirections()
	{
		return directions;
	}
	
	public int getX()
	{
		return this.Xcurrent;
	}
	
	public int getY()
	{
		return this.Ycurrent;
	}
	
	public boolean isValidMove(int[] xy)
	{
		System.out.println("XLast, YLast " + this.Xlast + "		" + this.Ylast );
		return (
				(this.Xlast != xy[0] || this.Ylast != xy[1]) 	//new location isnt old location
				&& xy[0] >= 0 && xy[0] < this.maze[0].length 	//x is in the matrix
				&& xy[1] >= 0 && xy[1] < this.maze.length		//y is in the matrix
				&& this.maze[xy[1]][xy[0]] == 0				//the location is a path
				);
		
	}

}
*/