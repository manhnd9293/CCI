import java.util.HashMap;

class Solution{
	public int countEval(String s, boolean res) {
		if(s.length() == 0 ) return 0;
		if(s.length() == 1) {
			if((s.charAt(0) == '0' && res == false) 
					|| (s.charAt(0) == '1' && res == true)) return 1;
			else return 0;
		}
		HashMap<String, Integer> M = new HashMap<>();
		return countEval_aux(s, res, M);
	}
	
	private int countEval_aux(String s, boolean res, HashMap<String, Integer> M){
		if(s.length() == 0) return 0;
		if(s.length() == 1) {
			if(s.charAt(0) == '0' && res == false 
					|| s.charAt(0) == '1' && res == true) return 1;
			else return 0;
		}
		if(M.containsKey(s + res)) return M.get(s + res);
		else {
			int ways = 0;
			for(int i = 1; i < s.length(); i+= 2) {
				String left = s.substring(0, i);
				String right = s.substring(i+1, s.length());
				
				int left_true = countEval_aux(left, true, M);
				int left_false = countEval_aux(left, false, M);
				int right_true = countEval_aux(right, true, M);
				int right_false = countEval_aux(right, false, M);
				
				int total_epx = (left_false+left_true) * (right_false + right_true);
				int total_true = 0;
				int total_false = 0;
				char c = s.charAt(i);
				if(c == '&') {
					total_true = left_true * right_true;
					total_false = total_epx - total_true;
				} else if(c == '|') {
					total_false = left_false * right_false;
					total_true = total_epx - total_false;
				} else {
					total_true = left_true * right_false + left_false * right_true;
					total_false = total_epx - total_true;
				}
				ways += (res ? total_true : total_false);
			}
			M.put(s + res, ways);
			return ways;
		}
	}
}
public class BooleanExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String s = "0&0&0&1^1|1&0|1";
		int res = sol.countEval(s, true);
		System.out.println(res);

	}

}
