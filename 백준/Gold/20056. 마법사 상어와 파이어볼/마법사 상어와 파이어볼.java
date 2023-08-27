import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;


class FireBall{
    int x;
    int y;
    int weight;
    int speed;
    int direction;
    boolean isLife;

    public FireBall(int x, int y, int weight, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.speed = speed;
        this.direction = direction;
        this.isLife = true;
    }
}

public class Main {

    static int SIZE;
    static HashMap<Integer,ArrayList<FireBall>> GRID;

    static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};
    static int dMX[] = {1, 1, 0, 0, 0, 0, 0, 1};
    static int dMY[] = {0, 0, 0, 0, 0, 1, 1, 1};

    static ArrayList<FireBall> fireBall = new ArrayList<FireBall>();


    public static void main(String[] args) throws Exception {
//         System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        SIZE = Integer.parseInt(stk.nextToken());
//        System.out.println(SIZE);
        for(int i = 0; i < 8 ; i++){
            if(dMX[i] == 1){
                dMX[i] = SIZE;
            }
            if(dMY[i] == 1){
                dMY[i] = SIZE;
            }
        }
        int Balls = Integer.parseInt(stk.nextToken());
        int cmd = Integer.parseInt(stk.nextToken());
        for(int b = 0; b < Balls; b++){
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            int weight = Integer.parseInt(stk.nextToken());
            int speed = Integer.parseInt(stk.nextToken());
            int direction = Integer.parseInt(stk.nextToken());
            fireBall.add(new FireBall(x,y,weight,speed,direction));
        }
        for(int k = 0; k < cmd; k++){
            GRID = new HashMap<Integer,ArrayList<FireBall>>();
            ArrayList<ArrayList<FireBall>> idx = new ArrayList<ArrayList<FireBall>>();
            for(FireBall f:fireBall){
                //move 구현
                if(f.isLife){



                    f.x = f.x+dx[f.direction]*(f.speed%SIZE);
                    f.y = f.y+dy[f.direction]*(f.speed%SIZE);

                    if(f.x > SIZE) f.x %= SIZE;
                    if(f.y > SIZE ) f.y %= SIZE;
                    if(f.x <= 0 ) f.x = SIZE-Math.abs(f.x);
                    if(f.y <= 0) f.y = SIZE-Math.abs(f.y);


                    int KEY = f.x*SIZE + f.y;
                    if(!GRID.containsKey(KEY)){
                        ArrayList<FireBall> temp = new ArrayList<FireBall>();
                        idx.add(temp);
                        GRID.put(KEY,temp);
                    }
                    GRID.get(KEY).add(f);
                }

            }

            for (ArrayList<FireBall> line : idx){
                if(line.size() >=2){ //파이어볼이 2개 이상 있는 경우


                    int weight = 0;
                    int speed = 0;

                    int tempDirection = line.get(0).direction %2;
                    int x = line.get(0).x;
                    int y = line.get(0).y;
                    boolean flag = false;
                    for(FireBall fire : line){
                        if(fire.isLife){
                            weight += fire.weight;
                            speed += fire.speed;
                            if(tempDirection != fire.direction%2){
                                flag = true;
                            }
                            fire.isLife = false;
                        }

                    }
                    weight /= 5;
                    speed /= line.size();
                    if (weight > 0){
                        if(flag){
                            //1 3 5 7

                            fireBall.add(new FireBall(x,y,weight,speed,1));
                            fireBall.add(new FireBall(x,y,weight,speed,3));
                            fireBall.add(new FireBall(x,y,weight,speed,5));
                            fireBall.add(new FireBall(x,y,weight,speed,7));

                        }
                        else{
                            fireBall.add(new FireBall(x,y,weight,speed,0));
                            fireBall.add(new FireBall(x,y,weight,speed,2));
                            fireBall.add(new FireBall(x,y,weight,speed,4));
                            fireBall.add(new FireBall(x,y,weight,speed,6));
                        }
                    }
                }
            }
            //여기서 이제 계산


        }

        int ans = 0;
        for(FireBall f: fireBall){
            if(f.isLife){
                ans += f.weight;
            }
        }
        System.out.println(ans);





    }


}