import java.io.*;
import java.util.*;
public class MixingMilk {
    public static void main(String[] args) throws java.io.IOException {
        Scanner sc = new Scanner(new FileReader("mixmilk.in"));
        int size1 = sc.nextInt(),amount1 = sc.nextInt();
        int size2 = sc.nextInt(),amount2 = sc.nextInt();
        int size3 = sc.nextInt(),amount3 = sc.nextInt();
        for (int i = 0; i < 100; i++) {
            if(i%3 == 0) {
                amount2+=amount1;
                if(amount2> size2) {
                    amount1 = amount2 - size2;
                    amount2 = size2;
                }
                else {
                    amount1 = 0;
        }
        
    }
        else if(i%3 == 1) {
            amount3+=amount2;
            if(amount3 > size3) {
                amount2 = amount3 - size3;
                amount3 = size3;
        }
        else {
            amount2 = 0;
        }
    }
    else {
        amount1+=amount3;
        if(amount1 > size1) {
            amount3 = amount1 - size1;
            amount1 = size1;
        }
        else {
                amount3 = 0;
        }
    }
}       
        
        
        //System.out.println(m1 + " " + m2 + " " + m3);
        
        FileWriter out = new FileWriter("mixmilk.out"); 
        out.write(amount1 + "\n");
        out.write(amount2 + "\n");
        out.write(amount3 + "\n");
        out.close();
    }   
}