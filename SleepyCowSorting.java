import java.io.*;
import java.util.*;

public class SleepyCowSorting {
	
	public static boolean isSorted(ArrayList<Integer> arr) {
		for (int i = 1; i <= arr.size() - 1; i++) {
			if (arr.get(i) < arr.get(i-1)) {
				return false;
			}
		}
		return true;
	}
	
	public static int findLongestSeq(ArrayList<Integer> arr)
	{
	    int subSeqLength = 1;
	    int longest = 1;
	    int indexStart = 0;
	    int indexEnd = 0;

	    for (int i = 0; i < arr.size() - 1; i++)
	    {
		    if (arr.get(i) < arr.get(i + 1)) //We need to check if the current is equal to the next
	        {
	            subSeqLength++; //if it is we increment
	            if (subSeqLength > longest)//we assign the longest and new bounds
	            {
	                longest = subSeqLength;
	                indexStart = i + 2 - subSeqLength; //make sure the index start is correct
	                indexEnd = i + 2;
	            }
	        } 
	        else
	            subSeqLength = 1; //else re-initiate the straight length
	    }
	    
	    return longest;
 
	}
	
	public static int simulateSort(ArrayList<Integer> arr) {
		int steps = 0;
		ArrayList<Integer> arrtemp = new ArrayList<Integer>();
		boolean found = false;
		int loc = 0;		
		
		while (!isSorted(arr)) {
			found = false;
			int currlongest = findLongestSeq(arr);
			int prevlongest = findLongestSeq(arr);
			
			
			for (int i = 1; i <= arr.size() - 1; i++) {
				arrtemp = (ArrayList<Integer>)arr.clone();
				arrtemp.add(i,arrtemp.remove(0));
				currlongest = findLongestSeq(arrtemp);
				if (currlongest >= prevlongest) {
					prevlongest = currlongest;
					loc = i;
					found = true;
				} 
				
				if (i == arr.size() - 1 && !found) {
					loc = arr.size() - 2;
					found = true;
				}
			}
			arr.add(loc,arr.remove(0));
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

		
		out.write(simulateSort(arr) + "\n");
		out.close(); 

	}

}