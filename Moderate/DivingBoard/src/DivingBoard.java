import java.util.HashMap;
import java.util.HashSet;

class Solution{
	public HashSet <Integer> divingBoard(int k, int shorter, int longer) {
		HashSet<Integer> lengths = new HashSet<Integer>();
		HashSet<String> visited = new HashSet<String>();
		countDivingBoard(k, 0, shorter, longer, lengths, visited);
		System.out.println("total solution: " + lengths.size());
		return lengths;	
	}
	
	void countDivingBoard(int k, int total, int s, int l, HashSet<Integer> len,HashSet<String> visited) {
		if(visited.contains(k +"-"+ total)) return;
		if(k == 0) {
			len.add(total); 
			return;
		} else {
			countDivingBoard(k-1, total + s, s, l, len,visited);
			countDivingBoard(k-1, total + l, s, l, len,visited);
			visited.add(k+ "-"+ total);
			return;
		}
	}
}


public class DivingBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		HashSet<Integer> m = s.divingBoard(100, 5, 3);
		for(Integer i : m) {
			System.out.println(i);
		}
	}

}
