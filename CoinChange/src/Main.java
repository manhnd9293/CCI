
class Solution{
	public int coinChange_aux(int amount, int [] denoms,int index, int [][]M) {
		if(index == (denoms.length- 1)) {
			if(amount % denoms[index] == 0) return 1;
			else return 0;
		}
		if(M[index][amount] != -1) return M[index][amount];
		int deAmount = denoms[index];
		int upper_bound = amount / deAmount;
		int ways = 0;
		for(int i = 0; i <= upper_bound; i++) {
			int remain = amount - i * deAmount;
			ways += coinChange_aux(remain, denoms, index+1, M);
		}
		M[index][amount] = ways;
		return ways;
	}
	
	public int coinChange(int amount, int []denoms) {
		int [][] M = new int[denoms.length][amount+1];
		for(int i = 0; i < denoms.length; i++) {
			for(int j = 0; j <= amount; j++) {
				M[i][j] = -1;
			}
		}
		return coinChange_aux(amount,denoms,0, M);
	}
	
}

public class Main {
	public static void main(String[] args) {
		int [] denoms = {25,10,4,1};
		Solution sol = new Solution();
		int res = sol.coinChange(1000,denoms);
		System.out.println(res);

	}

}
