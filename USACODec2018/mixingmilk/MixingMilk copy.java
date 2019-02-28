import java.io.*;
import java.util.*;
public class MixingMilk {
    public static void main(String[] args) throws java.io.IOException {
        Scanner sc = new Scanner(new FileReader("mixmilk.in"));
        int c1 = sc.nextInt(),m1 = sc.nextInt();
        int c2 = sc.nextInt(),m2 = sc.nextInt();
        int c3 = sc.nextInt(),m3 = sc.nextInt();
        int np = 0;
        while (np < 100) {
            if (m1 <= (c2 - m2)) {
                m2 += m1;
                m1 = 0;
            } else {
                m1 = (m1 + m2) - c2;
                m2 = c2;
            }
            //System.out.println(m1 + " " + m2 + " " + m3);
            if (m2 <= (c3 - m3)) {
                m3 += m2;
                m2 = 0;
            } else {
                m2 = (m2 + m3) - c3;
                m3 = c3;
            }
            //System.out.println(m1 + " " + m2 + " " + m3);
            if (m3 <= (c1 - m1)) {
                m1 += m3;
                m3 = 0;
            } else {
                m3 = (m3 + m1) - c1;
                m1 = c1;
            }
            //System.out.println(m1 + " " + m2 + " " + m3);
            np += 3;
        }
        if (m1 <= (c2 - m2)) {
            m2 += m1;
            m1 = 0;
        } else {
            m1 = (m1 + m2) - c2;
            m2 = c2;
        }
        //System.out.println(m1 + " " + m2 + " " + m3);
        
        FileWriter out = new FileWriter("mixmilk.out"); 
        out.write(m1 + "\n");
        out.write(m2 + "\n");
        out.write(m3 + "\n");
        out.close();
    }   
}