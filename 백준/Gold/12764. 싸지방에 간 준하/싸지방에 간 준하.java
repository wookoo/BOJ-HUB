import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int ans = 0;
        PriorityQueue<int[]> input = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });
        for (int i = 0; i < size; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            input.add(new int[]{start, end});
        }

        ArrayList<Integer> arr = new ArrayList<>();
        PriorityQueue<int[]> computers = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        PriorityQueue<int[]> whoBo = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        PriorityQueue<Integer> remain = new PriorityQueue<>();




        while (!input.isEmpty()) {
            int now[] = input.poll();
            int start = now[0];
            int end = now[1];

            while (!computers.isEmpty()) {
                if (computers.peek()[1] < start) {
                    // 컴퓨터 사용을 끝낸 사람이 있는지 검사
                    remain.add(computers.poll()[2]);
                } else {
                    break;
                }
            }

            if (remain.isEmpty()) {
                // 사용가능한 자리가 없을 경우 새로운 자리 배정
                computers.add(new int[]{start, end, ans});
                ans ++;
                arr.add(1);
            } else {
                // 사용가능한 자리가 있을 경우 사용가능한 자리 중 작은 번호순대로 좌석 배정
                int seatNo = remain.poll();
                computers.add(new int[]{start, end, seatNo});
                arr.set(seatNo,arr.get(seatNo)+1);
            }

        }
        System.out.println(ans);
        for(int i : arr){
            System.out.print(i + " ");
        }

    }


}