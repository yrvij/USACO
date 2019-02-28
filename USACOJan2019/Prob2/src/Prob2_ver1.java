import java.io.*;
import java.util.*;

public class Prob2 {
	
	public static boolean isSorted(ArrayList<Integer> arr) {
		for (int i = 1; i <= arr.size() - 1; i++) {
			if (arr.get(i) < arr.get(i-1)) {
				return false;
			}
		}
		return true;
	}
	
	public static int simulateSort(ArrayList<Integer> arr) {
		int steps = 0;
		Integer max = Collections.max(arr);
		Integer min = Collections.min(arr);
		
		
		while (! isSorted(arr)) {
			boolean found = false;
			int pointer = arr.get(0);
			for (int i = 1; i <= arr.size() - 2; i++) {
				Integer prev = arr.get(i);
				Integer next = arr.get(i+1);
				// normal condition
				if ((pointer > prev) && (pointer < next)) {
					found = true;
					arr.add(i,arr.remove(0));
				}
				
				
				if ((pointer == min) && (prev == max)) {
					found = true;
					arr.add(i,arr.remove(0));	
				} 
			}
			if (! found) {
				arr.add(arr.size()-1,arr.remove(0));
			}
			steps++;
		}
		return steps;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("sleepy.in"));
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		sc.close();
		

		FileWriter out = new FileWriter("sleepy.out"); 
		int s = simulateSort(arr);
		System.out.println(s);
		out.write(s + "\n");
		out.close();

	}

}
