import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        long pxList[] = new long[size];
        long pyList[] = new long[size];
        for (int i = 0; i < size; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            long x = Long.parseLong(stk.nextToken());
            long y = Long.parseLong(stk.nextToken());
            pxList[i] = x;
            pyList[i] = y;
        }

        int ans = 0;
        for (int a = 0; a < size - 2; a++) {
            for (int b = a + 1; b < size - 1; b++) {
                for (int c = b + 1; c < size; c++) {
                    long ax = pxList[a];
                    long ay = pyList[a];
                    long bx = pxList[b];
                    long by = pyList[b];
                    long cx = pxList[c];
                    long cy = pyList[c];

                    long aTob = (ax-bx)*(ax-bx) + (ay-by)*(ay-by);
                    long aToc = (ax-cx)*(ax-cx) + (ay-cy)*(ay-cy);
                    long bToc = (bx-cx)*(bx-cx) + (by-cy)*(by-cy);
                    if(aTob + aToc == bToc || aToc + bToc == aTob || aTob + bToc == aToc){
                        ans ++;
                    }



                }
            }
        }
        System.out.println(ans);

    }

}