import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;


public class Main {
    static int WIDTH;
    static int HEIGHT;

    static int GRID[][] = new int[101][101];


    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,-1,0,1};

    static final  int UP = 1;
    static final int DOWN = 3;
    static final int LEFT = 2;
    static final int RIGHT = 0;

    static HashMap<Integer,Integer> rotate = new HashMap<>();






    public static void main(String[] args) throws Exception {
      //  System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int CMD = Integer.parseInt(br.readLine());
        rotate.put(UP,LEFT);
        rotate.put(RIGHT,UP);
        rotate.put(LEFT,DOWN);
        rotate.put(DOWN,RIGHT);

        for(int i = 0 ; i < CMD; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            int direction = Integer.parseInt(stk.nextToken());
            int gen = Integer.parseInt(stk.nextToken());

            GRID[x][y] =1;

            if(gen == 0){
                GRID[x+dx[direction]][y+dy[direction]] =1;
            }
            else{
                Deque<Integer> deque = new LinkedList<>();
                deque.addLast(direction);
                Deque<Integer> tempDeque = new LinkedList<>();
                for(int g = 0; g < gen; g++){
                    int size = deque.size();
                    for(int t = 0; t < size; t++){
                        int temp= deque.pollLast();
                        int rotated = rotate.get(temp);
                        tempDeque.add(rotated);
                        deque.addFirst(temp);
                    }
                    while(!tempDeque.isEmpty()){
                        deque.addLast(tempDeque.pollFirst());
                    }
//                    System.out.println(deque);


                }
                while(!deque.isEmpty()){
                    int index = deque.pollFirst();
                    x += dx[index];
                    y += dy[index];
                    GRID[x][y] =1;
                }


            }

        }



        int cnt = 0 ;


        for(int i = 0; i <100;i++){
            for(int j = 0; j < 100 ; j++){
                if((GRID[i][j] == 1) && (GRID[i + 1][j] == 1) && GRID[i+1][j+1] ==1&& GRID[i][j+1] ==1){


                    cnt++;

                }
            }

        }
        System.out.println(cnt);






    }






}