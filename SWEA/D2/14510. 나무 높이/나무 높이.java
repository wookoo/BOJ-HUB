import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {


    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int TC = 1; TC <= tc; TC++) {
            int size = Integer.parseInt(br.readLine());
            StringTokenizer stk = new StringTokenizer(br.readLine());

            PriorityQueue<Integer> evenPq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o2, o1);
                }
            });
            PriorityQueue<Integer> oddPq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o2, o1);
                }
            });

            int trees[] = new int[size];
            int target = 0;
            for (int i = 0; i < size; i++) {
                int num = Integer.parseInt(stk.nextToken());
                trees[i] = num;
            }
            target = Arrays.stream(trees).max().getAsInt();
            for (int i : trees) {
                int diff = target - i;
                if (diff == 0) {
                    continue;
                }
                if (diff % 2 == 0) {
                    evenPq.add(diff);
                } else {
                    oddPq.add(diff);
                }
            }
            int day = 0;
            while (true) {
                day++;
                if (evenPq.isEmpty() && oddPq.isEmpty()) {
                    break;
                }
                if (day % 2 == 0) {
                    //짝수날

                    int num = 0;
                    if (!evenPq.isEmpty()) {
                        num = evenPq.poll();
                        num = num - 2;
                        if (num > 0) {
                            evenPq.add(num);
                        }
                    } else {
                        num = oddPq.poll();
                        if (num == 1) {
                            oddPq.add(num);
                        } else {
                            oddPq.add(num - 2);
                        }
                    }
                }
                if (day % 2 == 1) {
                    //홀수날

                    int num = 0;
                    if (!oddPq.isEmpty()) {
                        num = oddPq.poll();
                        num = num - 1;
                        if (num > 0) {
                            evenPq.add(num);
                        }
                    } else {
                        if(evenPq.size() == 1 && evenPq.peek() == 2){
                            continue;
                        }
                        num = evenPq.poll();
                        num = num - 1;

                        oddPq.add(num);


                    }
                }
            }

            day = day - 1;


            System.out.println("#" + TC + " " + (day));


        }


    }


}
