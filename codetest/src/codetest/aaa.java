package codetest;
import java.util.Scanner;

public class aaa {
    public static void main (String args[]) {
    	Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        int i = 666;
        while(true) {
            String si = String.valueOf(i);
            if(si.contains("666")) {
                count++;
                if(count == n) break;
            }
            i++;
        }
        System.out.println(i);
    }
}
