import java.util.Arrays;
import java.util.LinkedList;

class Solution {
	public int countFaczeros(int n) {
		if(n < 0) return -1;
		int count = 0;
		for(int i = 5; n / i > 0; i*=5) {
			count += n/i;
		}
		return count;
	}
	
	public int findSmallest(int [] a, int [] b) {
		Arrays.sort(a);
		Arrays.sort(b);
		int min = Integer.MAX_VALUE;
		int p1 = 0;
		int p2 = 0;
		while(p1 < a.length && p2 < a.length) {
			int sub = Math.abs(a[p1]- b[p2]);
			if(sub < min) min = sub;
			if(a[p1] > b[p2]) {
				p2++;
			} else {
				p1++;
			}
		}
		return min;
	}
}


public class NumberSwaper {

	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.add(1);
		l.add(2);
		int k = l.pop();
		System.out.println(k);
	}

}
