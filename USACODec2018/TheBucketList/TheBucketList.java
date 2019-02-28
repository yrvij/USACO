import java.io.*;
import java.util.*;
public class TheBucketList {
    public static void main(String[] args) throws java.io.IOException{
        Scanner sc = new Scanner(new FileReader("blist.in"));
        int N = sc.nextInt();
        int[int[]] buckets = new int[int[]];
        int[] s = new int[N];
        int[] t = new int[N];
        int[] b = new int[N];
        int maxBucket = 0;
        int curr = 0;
        
        for (int i = 0; i < N; i++) {
            s[i] = sc.nextInt();
            t[i] = sc.nextInt();
            b[i] = sc.nextInt();
            
        }
        
        //Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(interval); 
        //System.out.println(interval);
        //System.out.println(maxBucket);
        FileWriter out = new FileWriter("blist.out");
        out.write(maxBucket + "\n");
        out.close();
    }
}