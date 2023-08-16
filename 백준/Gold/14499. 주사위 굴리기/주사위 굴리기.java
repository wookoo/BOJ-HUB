import java.io.*;
import java.util.*;


public class Main {


    static int GRID[][] = null;
    static int WIDTH;
    static int HEIGHT;

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};

    static int x;
    static int y;


    static Deque<Integer> vertical = new LinkedList<>();
    static Deque<Integer> horizon = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        vertical.add(0);
        vertical.add(0);
        vertical.add(0);
        vertical.add(0);
        horizon.add(0);
        horizon.add(0);
        horizon.add(0);











        WIDTH = Integer.parseInt(stk.nextToken());
        HEIGHT = Integer.parseInt(stk.nextToken());
        x = Integer.parseInt(stk.nextToken());
        y = Integer.parseInt(stk.nextToken());
        int cmd = Integer.parseInt(stk.nextToken());
        GRID = new int[WIDTH][HEIGHT];


        for (int i = 0; i < WIDTH; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < HEIGHT; j++) {
                GRID[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        stk = new StringTokenizer(br.readLine());


        for (int i = 0; i < cmd; i++) {
            int direction = Integer.parseInt(stk.nextToken()) - 1;
            int tx = x + dx[direction];
            int ty = y + dy[direction];
            if (0 <= tx && tx < WIDTH && 0 <= ty && ty < HEIGHT) {


                if(direction == 0){


                    int middle = horizon.peekFirst();
                    horizon.addFirst(horizon.pollLast());


                    int head = vertical.pollFirst();
                    vertical.pollFirst();
                    vertical.addFirst(middle);
                    vertical.addFirst(head);

                    int temp = vertical.pollLast();
                    vertical.addLast(horizon.pollFirst());
                    horizon.addFirst(temp);

//                    System.out.println(horizon);
//                    System.out.println(vertical);
                }

                else if(direction == 1){ //서쪽
                    int middle = horizon.peekLast();
                    horizon.addLast(horizon.pollFirst());

//            System.out.println(middle);
                    int head = vertical.pollFirst();
                    vertical.pollFirst();
                    vertical.addFirst(middle);
                    vertical.addFirst(head);
                    int temp = vertical.pollLast();
                    vertical.addLast(horizon.pollLast());
                    horizon.addLast(temp);

                }

                else if(direction == 2){ //북쪽
                    vertical.addLast(vertical.pollFirst());
                    int head = vertical.pollFirst();
                    int middle = vertical.peekFirst();
                    vertical.addFirst(head);


                    int left = horizon.pollFirst();
                    int right = horizon.pollLast();
                    horizon.clear();
                    horizon.add(left);
                    horizon.add(middle);
                    horizon.add(right);
//                    System.out.println(horizon);
//                    System.out.println(vertical);
                }
                else if(direction == 3){ // 남쪽

                    vertical.addFirst(vertical.pollLast());
                    int head = vertical.pollFirst();
                    int middle = vertical.peekFirst();
                    vertical.addFirst(head);
                    int left = horizon.pollFirst();
                    int right = horizon.pollLast();
                    horizon.clear();
                    horizon.add(left);
                    horizon.add(middle);
                    horizon.add(right);
//                    System.out.println(horizon);
//                    System.out.println(vertical);

                }

                //주사위를 굴렸고, 주사위의 바닥을 가져오기


                if(GRID[tx][ty] == 0){
                    GRID[tx][ty] = vertical.peekLast();
                }
                else{
                    vertical.pollLast();
                    vertical.addLast(GRID[tx][ty]);
//
                    GRID[tx][ty] =0;
                }
                int temp = vertical.pollFirst();
                int pr = vertical.peekFirst();
                vertical.addFirst(temp);
                System.out.println(pr);
                x = tx;
                y = ty;
//                System.out.println(horizon);
//                System.out.println(vertical);
//                System.out.println("====");
            }
        }


    }


}
