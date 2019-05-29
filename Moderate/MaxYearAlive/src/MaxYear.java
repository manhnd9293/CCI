import java.util.Arrays;
import java.util.Random;

class Person {
	int birth;
	int death;
	
	public Person (int birth, int death) {
		this.birth = birth;
		this.death = death;
	}
}

class Solution {
	public int maxYearAlive(Person [] a){
		int [] birth = sortBirth(a,true);
		int [] death = sortBirth(a,false);
		
		int p1 = 0; // birth year pointer
		int p2 = 0; // death year pointer
		int maxYearAlive= 0;
		int alive = 0;
		int maxAlive = 0;
		
		while(p1 < birth.length) {
			if(birth[p1] <= death[p2]) {
				alive ++ ;
				if(alive > maxAlive) {
					maxAlive = alive;
					maxYearAlive = birth[p1];
				} 
				p1++;
			} else {
				alive--;
				p2++;
			}
		}
		System.out.println(maxAlive + "-" + maxYearAlive);
		return maxYearAlive;
	}
	
	private int [] sortBirth(Person []a, boolean b) {
		int [] res = new int [a.length];
		for(int i = 0; i < a.length; i++) {
			res[i] = (b ? a[i].birth : a[i].death);
		}
		Arrays.sort(res);
		return res;
	}
	
	public int maxYearAlive(Person [] a, int min, int max) {
		int [] years = new int [max - min + 2];
		
		for(int i = 0; i < years.length; i++) years[i] = 0; 
		
		for(Person p : a) {
			years[p.birth -min]++;
			years[p.death+1-min]--;
		}
		
		int maxYear = 0;
		int current = 0;
		int maxAlive = 0;
		
		for(int i = 0; i < years.length; i++) {
			current += years[i];
			if(current > maxAlive) {
				maxAlive = current;
				maxYear = i;
			}
			//System.out.println(current);
		}
		System.out.println(maxAlive + "-" + (maxYear + min));
		return maxYear + min;
	}
}


public class MaxYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int n = 1000;
		Person [] a = new Person [n];
		
		int min = Integer.MAX_VALUE;
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			int birth = r.nextInt(100) + 1900;
			int death = birth + r.nextInt(100) + 1;
			a[i] = new Person(birth, death);
			if(birth < min) min = birth;
			if(death > max) max = death;
		}
		for(int i = 0; i < n; i++) {
			System.out.println(a[i].birth  + "-" + a[i].death);
		}
		Solution sol = new Solution();
		int res1 = sol.maxYearAlive(a);
		int res2 = sol.maxYearAlive(a,min,max);
		
		//System.out.println(res1);
		//System.out.println(res2);

	}

}
