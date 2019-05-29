import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

class GraphPoint {
	double x, y;
	public GraphPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

class Line {
	public static double epsilon = .0001;
	public double slope, intercept;
	public boolean is_infinite = false;
	
	public Line (GraphPoint p, GraphPoint q) {
		if(p.x == q.x) {
			this.is_infinite = true;
			this.intercept = p.x;
		} else {
			this.slope = (p.y - q.y) / (p.x- q.x);
			this.intercept = p.y - this.slope * p.x;
		}
	}
	
	public static double floorToNearestEpsilon(double d) {
		int r = (int) (d/epsilon);
		return ((double) r) * epsilon;
	}
}

class HashMapList <T,E> {
	private HashMap<T, ArrayList<E>> map = new HashMap <T, ArrayList<E>>();
	
	public void put(T key, E item) {
		if(!map.containsKey(key)) {
			map.put(key, new ArrayList<E>());
		} else {
			map.get(key).add(item);
		}
	}
	
	public void put(T key, ArrayList<E> items) {
		map.put(key, items);
	}
	
	public ArrayList<E> get(T key){
		return map.get(key);
	}
	
	public boolean containsKey(T key) {
		return map.containsKey(key);
	}
	
	public boolean containsKeyValue(T key, E value) {
		ArrayList<E> list = map.get(key);
		if(list == null) return false;
		return list.contains(value);
	}
	
	public Set <T> keySet(){
		return map.keySet();
	}
	
	@Override
	public String toString() {
		return map.toString();
	}
}


public class BestLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		GraphPoint a = new GraphPoint(1, 2);
		GraphPoint b = new GraphPoint(7, 12);
		Line l = new Line(a, b);
		System.out.println("slope = " + l.slope);
		System.out.println("intercept = " + l.intercept);
		System.out.println("nearest to epsilon = " + Line.floorToNearestEpsilon(l.slope));
		
	}

}
