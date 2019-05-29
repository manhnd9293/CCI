import java.util.ArrayList;

	class Solution {
		public static boolean isMatch(String pattern, String value) {
			int na = 0;
			int nb = 0;
			for(int i = 0; i < pattern.length(); i++) {
				if(pattern.charAt(i) == 'a') na++;
				else nb++;
			}
	
			int fb = 0;
			while(pattern.charAt(fb) != 'b' && fb < pattern.length()) fb++;
	
	
			int la = 0;
			while(la * na <= value.length()) {
				int remainLen = value.length() - la * na;
				if(nb == 0 || remainLen % nb == 0) {
					int lb = remainLen / nb;
					String va = value.substring(0, la);
					String vb = value.substring(fb, fb+lb);
					StringBuffer sb = new StringBuffer();
					for(int i = 0; i < pattern.length(); i++) {
						String sub = (pattern.charAt(i) == 'a' ? va : vb);
						sb.append(sub);
					}
					String res = sb.toString();
					if(res.equals(value)) return true;
					else return false;
				}
			}
			return false;
	
		}
		
		public int countSubstrings(String s) {
			if(s.length() == 0) return 0;
			ArrayList<Integer> m = new ArrayList<Integer>();
			m.add(0);
			int res = 1;
			for(int i =1 ; i < s.length(); i++){
				System.out.println("i= " + i);
				m.add(i);
				res++;
				ArrayList <Integer> n = new ArrayList<>();
				for(Integer k : m){
					System.out.println("index " + k);
					if((k >= 1) && (s.charAt(k-1) == s.charAt(i))){
						res++;
						n.add(k-1);
					}
				}
				n.add(i);
				m = n;
		}
			System.out.println(res);
			return res;
		}
	}


	class PatternMatching {
		
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		int k = a.countSubstrings("aaa");
		}
	}
	

