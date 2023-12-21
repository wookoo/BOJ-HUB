import javax.management.AttributeList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int people = Integer.parseInt(stk.nextToken());

        int partyCount = Integer.parseInt(stk.nextToken());
        ArrayList<ArrayList<Integer>> peoplePartyGroup = new ArrayList<>();
        for(int i = 0 ; i < people; i++){
            peoplePartyGroup.add(new ArrayList<Integer>());
        }
        ArrayList<ArrayList<Integer>> partyGroup = new ArrayList<>();
        for(int i = 0; i < partyCount; i++){
            partyGroup.add(new ArrayList<Integer>());
        }
        boolean lier[] = new boolean[people];
        boolean checkedParty[] = new boolean[partyCount];
        boolean checkedPeople[] = new boolean[people];
        stk = new StringTokenizer(br.readLine());
        int truth = Integer.parseInt(stk.nextToken());
        for(int i = 0 ; i <truth;i++){
            lier[Integer.parseInt(stk.nextToken())-1] = true;
        }
        for(int i = 0; i<partyCount;i++){
            //i 는 party
            stk = new StringTokenizer(br.readLine());
            int pp = Integer.parseInt(stk.nextToken());
            for(int j = 0 ; j < pp; j++){
                int curruntPartyperson = Integer.parseInt(stk.nextToken());
                peoplePartyGroup.get(curruntPartyperson-1).add(i);
                partyGroup.get(i).add(curruntPartyperson-1);
            }
        }
//        System.out.println(peoplePartyGroup);
//        System.out.println(partyGroup);
//        System.out.println(Arrays.toString(lier));
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < people;i ++){
            if (lier[i]){
                q.add(i);
            }
        }
//        System.out.println(q);
        while (!q.isEmpty()){
            int curruntPerson = q.poll();
            lier[curruntPerson] = true;
            if(!checkedPeople[curruntPerson]){
                checkedPeople[curruntPerson] = true;
                //next node 들
                ArrayList<Integer> joinPartys = peoplePartyGroup.get(curruntPerson);
                for(int par: joinPartys){
                    //파티들이 나올것임
                    ArrayList<Integer> nowParty = partyGroup.get(par);
                    for(int person : nowParty){
                        q.add(person);
                    }
                }

            }

        }
        HashSet<Integer> result = new HashSet<>();
        for(int i = 0 ; i < people; i++){
            if(!lier[i]){
                ArrayList<Integer> nowParty = peoplePartyGroup.get(i);
                for(int p: nowParty){
                    result.add(p);
                }
            }
        }
//        System.out.println(Arrays.toString(lier));
        System.out.println(result.size());


    }
}