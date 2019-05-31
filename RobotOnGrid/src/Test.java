import java.util.*;
import java.lang.*;

class Point {
	int r,c;
	Point (int x, int y){
		r = x;
		c = y;
	}
}

class Solution {
	public ArrayList <Point> getPath(boolean [][] maze){
		ArrayList<Point> path =  new ArrayList<Point>();
		HashSet <Point> failedPoints = new HashSet<Point>();
		int m = maze.length;
		int n = maze[0].length;
		if(m == 0 || n == 0) return null;
		if(getPath(maze, m, n, path, failedPoints)) {
			return path;
		}
		return null;
	}
	
	
	private boolean getPath(boolean [][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
		if(row < 0 || col < 0 || !maze[row][col]) {
			return false;
		}
		Point p = new Point(row, col);
		if(failedPoints.contains(p)) return false;
		
		boolean isOrigin = (row == 0) && (col ==0);
		if(isOrigin || getPath(maze, row -1, col, path, failedPoints)
				|| getPath(maze, row -1, col, path, failedPoints)) {
			path.add(p);
			return true;
		}
		failedPoints.add(p);
		return false;
	}
}

public class Test {
	public static void main(String[] args) {
		System.out.println("hello, world");
	}

}
