import java.io.*;
import java.util.*;
public class TheBucketListyrvij {
    public static void main(String[] args) throws java.io.IOException{
        Scanner sc = new Scanner(new FileReader("blist.in"));
        int N = sc.nextInt();
        HashMap<Integer, Integer> interval = new HashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(interval); 
        int[] s = new int[N];
        int[] t = new int[N];
        int[] b = new int[N];
        int maxBucket = 0;
        int curr = 0;
        for (int i = 0; i < N; i++) {
            s[i] = sc.nextInt();
            t[i] = sc.nextInt();
            b[i] = sc.nextInt();
            interval.put(s[i],b[i]);
            interval.put(t[i],-b[i]);
        }
        //System.out.println(interval);
        for (Integer key : treeMap.keySet()) {
            //System.out.println(key);
            curr += treeMap.get(key);
            if (curr > maxBucket) {
                maxBucket = curr;
            }
        }
        //System.out.println(maxBucket);
        FileWriter out = new FileWriter("blist.out");
        out.write(maxBucket + "\n");
        out.close();
    }
}