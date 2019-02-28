package sub;

import java.util.*;

public class All_N_Digit_Numbers {

	private static int[] digits;
	private static int n;
	private static int m;
	private static int[] nums; // will contain each list of digit arrangements 
	
	
	public All_N_Digit_Numbers(int m, int[] digits, int n, int[] nums) {
		this.m = m;
		this.digits = digits;
		this.n = n;
		this.nums = nums;
	}
	
	
	public static ArrayList<int[]> generateNums(int c) {
		ArrayList<int[]> numbers = new ArrayList<int[]>();
		if (c == n) {
			numbers.add(nums);
		}
		for (int a : digits) {
			nums[c] = a;
			generateNums(c+1);
		}
		return numbers;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int[] digits = new int[m];
		for (int i = 0; i < m; i++) {
			digits[i] = sc.nextInt();
		}
		int n = sc.nextInt();
		int[] nums = new int[n];
		All_N_Digit_Numbers client = new All_N_Digit_Numbers(m, digits, n, nums);
		ArrayList<int[]> arr = client.generateNums(0);
		for (int[] item : arr) {
			System.out.println(Arrays.toString(item));
		}
		
		
	}

}
