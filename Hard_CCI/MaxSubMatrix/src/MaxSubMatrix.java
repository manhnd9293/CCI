import java.util.Random;


class SubMatrix{
	int rowStart;
	int rowEnd;
	int colStart;
	int colEnd;
	int val;
	
	public SubMatrix(int rowS,int rowE,int colS,int colE) {
		this.rowStart =rowS;
		this.rowEnd = rowE;
		this.colStart =colS;
		this.colEnd = colE;
	}
	
}

class SubArray{
	int s;
	int e;
	int val;
	
	public SubArray(int s,int e, int val) {
		this.s = s;
		this.e = e;
		this.val = val;
	}
}

class Solution{
	SubMatrix maxSubMatrix(int [][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		int max = Integer.MIN_VALUE;
		SubMatrix res = new SubMatrix(0, 0, 0, 0);
		
		for(int  i =0; i < m; i++ ) {
			int [] rowSum = new int [n];
			for(int j = i; j < m; j++) {
				for(int k = 0; k < matrix[0].length;k++) {
					rowSum[k] += matrix[j][k];
				}
				
				SubArray maxArr = maxSubArray(rowSum);
				if(maxArr.val > max) {
					max = maxArr.val;
					res.val = maxArr.val;
					res.rowStart = i;
					res.rowEnd = j;
					res.colStart = maxArr.s;
					res.colEnd = maxArr.e;
				}
			}
		}
		return res;
	}
	
	SubArray maxSubArray(int [] a) {
		SubArray res = new SubArray(0, 0, a[0]);
		
		int ei = a[0];
		int start = 0;
		int end = 0;
		
		for(int i = 1; i < a.length; i++) {
			if(ei <= 0) {
				ei = a[i];
				start = i;
				end = i;
			} else {
				ei += a[i];
				end = i;
			}
			
			if(ei > res.val) {
				res.s = start;
				res.e = end;
				res.val = ei;
			}
		}
		return res;
	}
}


public class MaxSubMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		Random rand = new Random();
		/*
		int n = 5;
		int [] a = new int [n];
		a[0] = 3;
		a[1] = -2;
		a[2] = 5;
		a[4] = -1;
		a[3] = -2;
		
		SubArray res = s.maxSubArray(a);
		System.out.println(res.s);
		System.out.println(res.e);
		System.out.println(res.val);
		*/
		int p = 20;
		int q = 20;
		int lim = 100;
		int [][] matrix = new int [p][q];
		for(int i = 0; i < p; i++) {
			for(int j = 0; j < q; j++) {
				matrix[i][j] = 2 * rand.nextInt(lim) - 1 *lim;
			}
		}
		
		//matrix[0][0] = 1;
		//matrix[1][0] = 2;
		
		for(int i = 0; i < p; i++) {
			for(int j = 0; j < q; j++) {
				System.out.print(String.format("%6d", matrix[i][j]));
			}
			System.out.println();
		}
		System.out.println();
		SubMatrix r = s.maxSubMatrix(matrix);
		
		System.out.println("row : " + r.rowStart + "----" + r.rowEnd);
		System.out.println("col : " + r.colStart + "----" + r.colEnd);
		
		for(int i = r.rowStart; i <= r.rowEnd; i++) {
			for(int j = r.colStart; j <= r.colEnd; j++) {
				System.out.print(String.format("%6d", matrix[i][j]));
			}
			System.out.println();
		}
		System.out.println(r.val);
	}

}
