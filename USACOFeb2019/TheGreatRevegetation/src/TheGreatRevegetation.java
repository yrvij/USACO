import java.io.*;
import java.util.*;

public class TheGreatRevegetation {
	
	private int[] pastures;
	private static ArrayList<int[]> output;
	
	public TheGreatRevegetation(int[] pastures, ArrayList<int[]> output) {
		this.pastures = pastures;
		this.output = output;
	}
	
	public boolean checkValidity(int[] pasture) {
		for (int i = 0; i < pastures.length; i++) {
			int index_one = pastures[i] / 10;
			int index_two = pastures[i] % 10;
			if (pasture[index_one - 1] == pasture[index_two - 1]) {
				return false;
			}
			//System.out.println(index_one + " " + index_two);
		}
		return true;
	}
	
	public static void generateNums(int c, int[] nums, int[] digits, int n) {
		if (c == n) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int a : digits) {
			nums[c] = a;
			generateNums(c+1, nums, digits, n);
		}
		
	}

	public static void main(String[] args) throws java.io.IOException {
		Scanner sc = new Scanner(new FileReader("revegetate.in"));
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] pastures = new int[M];
		for (int i = 0; i < M; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			String number = Integer.toString(Math.min(first,second)) + 
					Integer.toString(Math.max(first,second));
			int num = Integer.parseInt(number);
			pastures[i] = num;
		}
		Arrays.sort(pastures);
		
		//System.out.println(Arrays.toString(pastures));
		
		int[] combos = new int[5];
		
		int min = Integer.MAX_VALUE;
		int[] digits = {1,2,3,4};
		int[] nums = new int[N];
		ArrayList<int[]> output = new ArrayList<int[]>();
		
		TheGreatRevegetation client = new TheGreatRevegetation(pastures,output);
		
		client.generateNums(0, nums, digits, N);
		
		for (int[] item : output) {
			System.out.println(Arrays.toString(item));
		}
		
		
		/*for (int i1 = 1; i1 <= 4; i1++) {
			for (int i2 = 1; i2 <= 4; i2++) {
				for (int i3 = 1; i3 <= 4; i3++) {
					for (int i4 = 1; i4 <= 4; i4++) {
						for (int i5 = 1; i5 <= 4; i5++) {
							combos[0] = i1;
							combos[1] = i2;
							combos[2] = i3;
							combos[3] = i4;
							combos[4] = i5;
							String a = "";
							if (client.checkValidity(combos)) {
								for (int i = 0; i < 5; i++) {
									a += Integer.toString(combos[i]);
								}
								int num = Integer.parseInt(a);
								if (num < min) {
									min = num;
								}
							}
						}
					}
				}
			}
		}*/
		
		//System.out.println(min);
		
		sc.close();
		FileWriter out = new FileWriter("revegetate.out"); 
		out.write(min + "\n");
		out.close();
	}

}


