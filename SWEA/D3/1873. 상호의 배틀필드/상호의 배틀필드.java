import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    static char GRID[][] = new char[20][];
    static int WIDTH;
    static int HEIGHT;

    static final int UP = 0;
    static final int DOWN = 1;
    static final int LEFT = 2;
    static final int RIGHT = 3;

    static final int SHOOT =  100;

    static final char WALL = '*';
    static final char FIELD = '.';
    static final char STEEL = '#';
    static final char WATER = '-';
    static final int dx[] = {-1,1,0,0};
    static final int dy[] = {0,0,-1,1};
    static int face;
    static int xPos;
    static int yPos;

    public static void main(String[] args) throws  Exception{
      //  System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer stk = null;
        HashMap<Character,Integer> direction = new HashMap<Character,Integer>();
        direction.put('U',UP);
        direction.put('D',DOWN);
        direction.put('L',LEFT);
        direction.put('R',RIGHT);
        direction.put('S',SHOOT);

        direction.put('^',UP);
        direction.put('v',DOWN);
        direction.put('<',LEFT);
        direction.put('>',RIGHT);

        for(int tc = 1; tc <=TC; tc++){
//            System.out.println("hi");
            stk = new StringTokenizer(br.readLine());
            WIDTH = Integer.parseInt(stk.nextToken());
            HEIGHT = Integer.parseInt(stk.nextToken());
            for(int i = 0 ; i < WIDTH ; i++){
                GRID[i] = br.readLine().toCharArray();
//                System.out.println(Arrays.toString(GRID[i]));
                for(int j = 0; j < HEIGHT; j++){
                    if(direction.containsKey(GRID[i][j])){

                        face = direction.get(GRID[i][j]);
                        xPos = i;
                        yPos = j;
                        GRID[i][j] = FIELD;
                    }
                }
            }
            br.readLine();
            char cmds[] = br.readLine().toCharArray();
            for(char CMD:cmds){
                int d = direction.get(CMD);
                if(d == SHOOT){
                    int tx = xPos;
                    int ty = yPos;
                    while(0 <= tx && tx < WIDTH && 0<= ty && ty < HEIGHT) {

                        if (GRID[tx][ty] == WALL) {
                            GRID[tx][ty] = FIELD;
                            break;
                        }
                        if (GRID[tx][ty] == STEEL) {
                            break;
                        }
                        tx += dx[face];
                        ty += dy[face];

                    }
                    continue;
                }

                face = d;
                int tx = xPos + dx[face];
                int ty = yPos + dy[face];
                if(0 <= tx && tx < WIDTH&&
                    0<= ty && ty < HEIGHT &&
                        GRID[tx][ty] == FIELD
                ){
                   xPos = tx;
                   yPos = ty;

                }

            }
            char tank = '^';
            switch (face){
                case UP:
                    tank = '^';
                    break;
                case DOWN:
                    tank = 'v';
                    break;
                case LEFT:
                    tank = '<';
                    break;
                case RIGHT:
                    tank = '>';
            }
            System.out.print("#"+tc+" ");
            GRID[xPos][yPos] = tank;
            print();


        }
    }
    public static void print(){
        for(int i = 0; i < WIDTH; i++){
            for(int j = 0; j < HEIGHT; j++){
                System.out.print(GRID[i][j]);
            }
            System.out.println();
        }
    }
}