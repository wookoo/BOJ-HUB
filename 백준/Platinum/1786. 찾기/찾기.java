import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {


        public static void main(String[] args) throws  Exception{
           // System.setIn(new FileInputStream("./src/bj/BJ_1786.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String haystack = br.readLine();
            String needle = br.readLine();

            int n = haystack.length();
            int m = needle.length();
            int i = -1;
            int j = 0;
            int pi[] = new int[m+1];
            pi[j] = i;
            while (j < m){
                if(i == -1 || needle.charAt(i) == needle.charAt(j)){
                    pi[++j] = ++i;
                }
                else{
                    i = pi[i];
                }
            }
            i = 0;
            j = 0;
            ArrayList<Integer> result = new ArrayList<>();

            while (i < n){
                if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
                    i++;
                    j++;
                }
                else{
                    j = pi[j];
                }
                if(j == m){


                    result.add(i-m+1);
                    j = pi[j];
                }
            }

            System.out.println(result.size());
            for(Integer e : result){
                System.out.println(e);
            }
        }


}
