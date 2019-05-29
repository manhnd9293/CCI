import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

class Box {
	public int w;
	public int h;
	public int d;
	
	Box(int width, int height, int depth) {
		w = width;
		h = height;
		d = depth;
	}
	boolean canAbove(Box b) {
		if((this.d <= b.d) && (this.h <= b.h) && (this.w <= b.w)) return true;
		else return false;
	}
}

class BoxCompare implements Comparator{
	public int compare(Object a, Object b) {
		Box box_a = (Box) a;
		Box box_b = (Box) b;
		if(box_a.d > box_b.d) return 1;
		else if(box_a.d == box_b.d) {
			if(box_a.h > box_b.h) return 1;
			else if(box_a.h == box_b.h) {
				if(box_a.w > box_b.w) return 1;
				else if(box_a.w== box_b.w) return 0;
				else return -1;
			} else return -1;
		} else return -1;
	}
}


class Solution {
	int maxStack(ArrayList<Box> a) {
		int [] p = new int [a.size()];
		for(int i = 0; i < a.size(); i++) {
			int k = i-1;
			while(k >= 0 && !a.get(k).canAbove(a.get(i))) k--;
			p[i] = k;
		}
		int [] M = new int[a.size()];
		int maxHeight = 0;
		int max_index = 0;
		for(int i = 0; i < a.size(); i++) {
			int cur = a.get(i).d;
			int prev = (p[i] >= 0 ? M[p[i]] : 0);
			int height = cur + prev;
			M[i] = height;
			if(M[i] > maxHeight) {
				maxHeight  = M[i];
				max_index = i;
			}
		}
		System.out.println("solution: ");
		int j = max_index;
		while(j >= 0) {
			System.out.println(j+1 + ": " + a.get(j).d + " "+ a.get(j).h + " " + a.get(j).w );
			j = p[j];
		}
		return maxHeight;
	}
}

public class StackBoxMain {

	public static void main(String[] args) {
		Random rand = new Random();
		int n = 100;
		ArrayList <Box> a = new ArrayList <Box> ();
		for(int i =0; i< n; i++) {
			int w = rand.nextInt(100)+1;
			int h = rand.nextInt(100)+1;
			int d = rand.nextInt(100)+1;
			a.add(new Box(w,h,d));
		}
		for(int i =0; i< n; i++) {
			System.out.println(i+1 + ": " + a.get(i).d + "-" + a.get(i).h + "-" + a.get(i).w);
		}
		
		Collections.sort(a, new BoxCompare());
		
		System.out.println("after sort: ");
		for(int i =0; i< n; i++) {
			System.out.println(i+1 + ": " + a.get(i).d + "-" + a.get(i).h + "-" + a.get(i).w);
		}
		System.out.println(":D");
		int res = new Solution().maxStack(a);
		System.out.println(res);
	}

}
