import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        long size = Long.parseLong(stk.nextToken());
        long N = Long.parseLong(stk.nextToken()) + Long.parseLong(stk.nextToken());

        long arr[] = new long[(int) size];
        long tree[] = new long[(int) (4*size)];
        for (long i = 0; i < size; i++) {
            arr[(int) i] = Long.parseLong(br.readLine());
        }
        initTree(arr,tree,0,size-1,1);

        for (long i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            //a가 1인 경우 b(1 ≤ b ≤ N)번째 수를 c로 바꾸고 a가 2인 경우에는 b(1 ≤ b ≤ N)번째 수부터 c(b ≤ c ≤ N)번째 수까지의 합을 구하여 출력하면 된다.
            long a = Long.parseLong(stk.nextToken());
            long b = Long.parseLong(stk.nextToken());
            long c = Long.parseLong(stk.nextToken());
            if (a == 1) {
                //change
                b = b -1;

                long diff = c-arr[(int) b];
                arr[(int) b] = c;
                update(tree,0, size - 1, 1, b, diff);

            } else {
                long result = sum(tree,0,size-1, 1,  (b-1),  (c-1));
                //prlong sum(b,c)
                System.out.println(result);

            }


        }

    }

    static long sum(long tree[],long start, long end, long node, long left, long right) {
        // 범위 밖에 있는 경우
        if(left > end || right < start) return 0;
        // 범위 안에 있는 경우
        if(left <= start && end <= right) return tree[(int) node];
        // 그렇지 않다면 두 부분으로 나누어 합을 구하기
        long mid = (start + end) / 2;
        return sum(tree,start, mid, node * 2, left, right) + sum(tree,mid + 1, end, node * 2 + 1, left, right);
    }

    public static long initTree(long arr[], long tree[], long start, long end, long index) {
        if (start == end) {
            return tree[(int) index] = arr[(int) start];
        }
        long mid = (start + end) / 2;

        return tree[(int) index] = initTree(arr, tree, start, mid, index * 2) + initTree(arr, tree, mid + 1, end, index * 2 + 1);
    }

    public static void update(long tree[], long start, long end, long node, long index, long dif) {
        // 범위 밖에 있는 경우
        if(index < start || index > end) return;
        // 범위 안에 있으면 내려가며 다른 원소도 갱신
        tree[(int) node] += dif;
        if (start == end) return;
        long mid = (start + end) / 2;
        update(tree,start, mid, node * 2, index, dif);
        update(tree,mid + 1, end, node * 2 + 1, index, dif);
    }
}