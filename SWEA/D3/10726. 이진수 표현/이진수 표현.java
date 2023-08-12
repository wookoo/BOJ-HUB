//ColorTest.java

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static final int TARGET = 0b1111111111;

    public static void main(String args[]) throws Exception {

       // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// , target)
        int tc = Integer.parseInt(br.readLine());// br.readLine();
        for (int TC = 0; TC < tc; TC++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());//, null, false)
            int lastBitNum = Integer.parseInt(stk.nextToken());
            int input = Integer.parseInt(stk.nextToken());
            int TARGET = 0;
            System.out.print("#"+(TC+1) +" ");
            for(int i = 0; i < lastBitNum; i++){
                TARGET = (1<<i) | TARGET;
            }
            // System.out.println(TARGET);
            if((input&TARGET) == TARGET){
                System.out.println("ON");
            }
            else{
                System.out.println("OFF");
            }



        }

    }

}