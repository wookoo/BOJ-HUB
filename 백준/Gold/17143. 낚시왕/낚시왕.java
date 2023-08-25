import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

class Shark implements Comparable<Shark> {

    static int R;

    public static int dx[] = {-1, 0, 1, 0}; //상 좌 하 우 순
    public static int dy[] = {0, -1, 0, 1};
    static int C;

    int x;
    int y;
    final int speed;
    int direction;
    final int size;

    boolean life;

    public Shark(int x, int y, int speed, int direction, int size) {
        this.x = x;
        this.y = y;


        this.size = size;
        this.life = true; //캐스팅 당하거나, 물려죽거나

        if(direction == 1)
            direction = 0;
        else if(direction == 4)
            direction = 1;

        this.direction = direction;


        if(direction == 0 || direction == 2) // 상 하
            speed %= (R -1) * 2;
        else if(direction == 1 || direction == 3) // 좌 우
            speed %= (C -1) * 2;

        this.speed = speed;

//        if(this.direction == 1 && this.x == 0 ){
//            this.direction =2;
//        }
//        else if(this.direction == 2 && this.x == R-1 ){
//            this.direction =1;
//        }
//        else if(this.direction == 3 && this.y == C-1 ){
//            this.direction =2;
//        }
//        else if(this.direction == 4 && this.y == 0 ){
//            this.direction =3;
//        }


    }

    @Override
    public int compareTo(Shark o) {
        return Integer.compare(this.size, o.size) * -1;
    }

    @Override
    public String toString() {
        return "Shark{" +
                "x=" + x +
                ", y=" + y +
                ", size=" + size +
                ", life=" + life +
                ", speed=" + speed +
                '}';
    }

    public void move() {

        // d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽을 의미한다.
        for (int i = 0; i < speed; i++) {
            int newR = this.x + dx[direction];
            int newC = this.y + dy[direction];

            // 이동할 새로운 위치가 범위를 벗어나 벽에 부딪히면
            if(newR < 0 || newR >= R || newC < 0 || newC >= C) {
                x -= dx[direction]; // 다시 값 돌려주고
                y -= dy[direction];
                direction = (direction + 2) % 4; // 방향 반대로
                continue;
            }

            // 위치 벗어나지 않을때는 새로운 위치로 이동
            x = newR;
            y = newC;
        }
    }
}

public class Main {

    static int R;
    static int C;
    static int SharkSize;

    static ArrayList<Shark> sharks = new ArrayList<Shark>();

    static HashMap<Integer,PriorityQueue<Shark>> BOARD = new HashMap<Integer,PriorityQueue<Shark>>();

    static ArrayList<PriorityQueue<Shark>> temp = new ArrayList<PriorityQueue<Shark>>();

    public static void main(String[] args) throws Exception {
        //  System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        Shark.R = R;
        Shark.C = C;

        SharkSize = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < SharkSize; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken()) - 1;
            int y = Integer.parseInt(stk.nextToken()) - 1;
            int speed = Integer.parseInt(stk.nextToken());
            int direction = Integer.parseInt(stk.nextToken());
            int size = Integer.parseInt(stk.nextToken());
            Shark shark = new Shark(x, y, speed, direction, size);
            sharks.add(shark);

            int cellKey = x * C + y;
            if(!BOARD.containsKey(cellKey)){
                BOARD.put(cellKey,new PriorityQueue<Shark>());
            }
            BOARD.get(cellKey).add(shark);
        }

        //보드 초기화


        //여기서 낚시꾼의 포인트로 잡기

        int fishingSize = 0;
        for (int y = 0; y < C; y++) {

            //현재 좌표 i
            //물고기를 잡고
            for (int x = 0; x < R; x++) {
                int cellKey = x * C + y;
                if(BOARD.containsKey(cellKey)){
                    Shark casting = BOARD.get(cellKey).poll();
                    casting.life = false;
                    fishingSize += casting.size;
                    break;
                }
            }

            //먼저 캐스팅 진행


            BOARD = new HashMap<Integer,PriorityQueue<Shark>>();
            temp.clear();

            //상어 이동
            for (Shark shark : sharks) {
                if(shark.life){
                    shark.move();
                }

            }

            //상어 등록
            for (Shark shark : sharks) {
                if(shark.life){
                    int cellKey = shark.x * C + shark.y;
                    if(!BOARD.containsKey(cellKey)){
                        PriorityQueue<Shark> pq = new PriorityQueue<Shark>();
                        temp.add(pq);
                        BOARD.put(cellKey,pq);
                    }
                    BOARD.get(cellKey).add(shark);
                }
            }
            for (PriorityQueue<Shark> pq : temp){
                Shark alive = pq.poll();
                while (!pq.isEmpty()) {
                    Shark dead = pq.poll();
                    dead.life = false;
                }
                pq.add(alive);
            }

//            System.out.println("====");
//            for(int i = 0; i < R; i++){
//                for(int j = 0; j < C; j++){
//                    System.out.print(BOARD[i][j]);
//                }
//                System.out.println();
//            }

        }
        System.out.println(fishingSize);

    }
}