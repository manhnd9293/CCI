
public class MainSubSort {
	public static void subSort(int [] a) {
		if(a.length == 0 || a.length == 1) return;
		
		int end_left = 0;
		while(end_left < a.length-1 && a[end_left+1] >= a[end_left]) end_left++;
		if(end_left == a.length-1) {
			System.out.println("Day da sap xep");
			return;
		}
		
		int end_right = a.length -1;
		while(end_right > 0 && a[end_right-1] <= a[end_right]) end_right--;
		
		int min_mid = Integer.MAX_VALUE;
		int max_mid = Integer.MIN_VALUE;
		for(int i = end_left+1; i < end_right; i++) {
			if(a[i] > max_mid) max_mid = a[i];
			else if(a[i] < min_mid) min_mid = a[i];
		}
		
		while(a[end_left] > min_mid && end_left >= 0) {
			if(a[end_left] > max_mid) {
				max_mid = a[end_left];
				//while(a[end_right] < max_mid && end_right < a.length-1) end_right++;
			}
			end_left--;
		}
		
		while(a[end_right] < max_mid && end_right < a.length) {
			if(a[end_right] < min_mid) {
				min_mid = a[end_right];
				while(a[end_left] > min_mid && end_left >= 0) end_left--;				
			}
			end_right++;
		}
		System.out.println("(" + (end_left+1) +" , " + (end_right-1) + ")");
	}
	
	public static void main(String[] args) {
		int [] a = {1,2,3,4,5,6};
		subSort(a);

	}

}
