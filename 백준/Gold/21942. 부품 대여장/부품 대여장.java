import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int record = Integer.parseInt(stk.nextToken());
        String dayEndHour = stk.nextToken();
        int day = Integer.parseInt(dayEndHour.substring(0, 3));
        int hour = Integer.parseInt(dayEndHour.substring(4, 6));
        int minute = Integer.parseInt(dayEndHour.substring(7, 9));
        int deadLine = day * 24 * 60 + hour * 60 + minute;
        int tax = Integer.parseInt(stk.nextToken());

        HashMap<String, Long> timeTable = new HashMap<>();
        HashMap<String, Long> taxTable = new HashMap<>();
        for (int i = 0; i < record; i++) {
            stk = new StringTokenizer(br.readLine());
            String temp = stk.nextToken();
            int tempMonth = Integer.parseInt(temp.substring(5, 7));
            int tempDay = Integer.parseInt(temp.substring(8, 10));
            temp = stk.nextToken();
            int tempHour = Integer.parseInt(temp.substring(0, 2));
            int tempMinute = Integer.parseInt(temp.substring(3, 5));
            long time = getTime(tempMonth, tempDay, tempHour, tempMinute);
            String item = stk.nextToken();
            String name = stk.nextToken();
            String key = item + "-" + name;
            if (timeTable.containsKey(key)) {
                long rentalTime = timeTable.get(key);
                long returnTime = time; //빌린시간 + 데드라인 > 반납시간
                long diff = returnTime - rentalTime;

                if (0 < diff) {
                    if (taxTable.containsKey(name)) {
                        taxTable.put(name, taxTable.get(name) + diff);
                    } else {
                        taxTable.put(name, diff);
                    }
                }
                timeTable.remove(key);
            } else {
                time += deadLine;
                timeTable.put(key, time);

            }

        }
        if (taxTable.isEmpty()) {
            System.out.println(-1);
        } else {
            List<String> keys = new ArrayList<>(taxTable.keySet());
            Collections.sort(keys);
            for(String name:keys){
                System.out.println(name +" " + taxTable.get(name) * tax);
            }


        }


    }

    public static long getTime(int month, int day, int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        month = month - 1;
        calendar.set(2021, month, day, hour, minute, 0);
        return calendar.getTimeInMillis() / 60000;

    }


}