import java.util.*;
import java.io.*;

public class ShellGame {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("shell.in"));
		int N = sc.nextInt();
		int max = 0;
		int succ = 0;
		int[] pebbleArr = new int[4];
		int[] a = new int[N];
		int[] b = new int[N];
		int[] g = new int[N];
		
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt(); b[i] = sc.nextInt(); g[i] = sc.nextInt();
		}
		
		for (int j = 1; j <= 3; j++) {
			pebbleArr[j] = 1;
			succ = 0;
			for (int i = 0; i < N; i++) {
				
				if (a[i] > b[i]) {
					int temp = a[i];
					a[i] = b[i];
					b[i] = temp;
				}
				
				
				if (pebbleArr[a[i]] == 1) {
					pebbleArr[a[i]]--;
					pebbleArr[b[i]]++;
				} else if(pebbleArr[b[i]] == 1) {
					pebbleArr[b[i]]--;
					pebbleArr[a[i]]++;
				}
				
				
				if (pebbleArr[g[i]] == 1) {
					succ++;
				}
			}
			if (succ > max) {
				max = succ;
			}
			
			// reinitialize the array
			for (int k=1;k<4;k++) {
				pebbleArr[k] = 0;
			}
			
		}
		
		sc.close();
		
		//System.out.println(max);
		FileWriter out = new FileWriter("shell.out"); 
		out.write(max + "\n");
		out.close();
	}

} 
