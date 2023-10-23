
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static boolean GRAPH[][];
    static int N;
    static int M;
    static int H;
    static int W;
    static int SX;
    static int SY;
    static int GX;
    static int GY;

    static int DX[] = {0,1,0,-1};
    static int DY[] = {1,0,-1,0};


    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        GRAPH = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                GRAPH[i][j] = (Integer.parseInt(stk.nextToken()) == 0);
            }
        }
        stk = new StringTokenizer(br.readLine());
        H = Integer.parseInt(stk.nextToken())-1;
        W = Integer.parseInt(stk.nextToken())-1;
        SX = Integer.parseInt(stk.nextToken())-1;
        SY = Integer.parseInt(stk.nextToken())-1;
        GX = Integer.parseInt(stk.nextToken())-1;
        GY = Integer.parseInt(stk.nextToken())-1;

        int ans = bfs();

        System.out.println(ans);

    }

    public static boolean isIn(int x, int y){
        return (0<= x && x < N && 0<= y && y< M && GRAPH[x][y]);
    }
    static int bfs(){
        boolean visited[][] = new boolean[N][M];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{SX,SY,0});
        while (!q.isEmpty()){
            int[] line = q.poll();
            int x = line[0];
            int y = line[1];
            int depth = line[2];
            if(x == GX && y == GY){
                return depth;
            }
            if(!visited[x][y]){
                visited[x][y] = true;
                for(int i = 0; i < 4; i ++){
                    int ltx = x +DX[i];
                    int lty  = y + DY[i];

                    int rtx = ltx;
                    int rty = lty+W;

                    int lbx = ltx+H;
                    int lby = lty;

                    int rbx = ltx +H;
                    int rby = lty +W;

                    boolean flag = true;

                    if(i == 0){
                        //check Right
                        //rtx,rty,
                        for(int tx = rtx; tx<=rbx;tx++){
                            if(!isIn(tx,rty)){
                                flag = false;
                                break;
                            }
                        }
                        //rbx,rby

                    }
                    else if(i == 1){
                        for(int ty = lby; ty <=rby; ty++){
                            if(!isIn(lbx,ty)){
                                flag = false;
                                break;
                            }
                        }
                        //lbx,lby
                        //rbx,rby
                        //check down
                    }
                    else if(i == 2){
                        //ltx,lty
                        //lbx,lby
                        //check left
                        for(int tx = ltx; tx <=lbx; tx++){
                            if(!isIn(tx,lby)){
                                flag = false;
                                break;
                            }
                        }
                    }
                    else{
                        for(int ty = lby; ty <= rby; ty++){
                            if(!isIn(ltx,ty)){
                                flag = false;
                                break;
                            }
                        }
                        //ltx,lty
                        //rtx,rty
                        //check up
                    }

                    if(flag){
                        q.add(new int[]{ltx,lty,depth+1});
                    }


                }
            }
        }


        return -1;


    }


}