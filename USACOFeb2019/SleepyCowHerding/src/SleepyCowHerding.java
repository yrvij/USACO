import java.io.*;
import java.util.*;

public class SleepyCowHerding {

	public static void main(String[] args) throws java.io.IOException {
		Scanner sc = new Scanner(new FileReader("herding.in"));
		int N = sc.nextInt();
		int[] locations = new int[N];
		for (int i = 0; i < N; i++) {
			locations[i] = sc.nextInt();
		}
		
		Arrays.sort(locations);
		int me = Math.abs(locations[N] - locations[1] - 1);
		int eb = Math.abs(locations[1] - locations[0] - 1);
		int max = Math.max(me,eb);
		int min = Math.min(me,eb);
		
		if (min == 0) {
			min = 2;
		} 
		sc.close();
		System.out.println(min);
		System.out.println(max);
		FileWriter out = new FileWriter("herding.out"); 
		out.write(min + "\n");
		out.write(max + "\n");
		out.close();
	}

}

// 1 2 109
// 2 107 109
// 107 108 109

// 1 108 109
// 1 3 108
// 1 2 3

// 1 2 56
// 2 54 56
// 54 55 56


