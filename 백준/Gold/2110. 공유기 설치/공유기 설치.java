import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws  Exception{
//        System.setIn(new FileInputStream("./src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(stk.nextToken());
        int choice = Integer.parseInt(stk.nextToken());
        int arr[] = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        int start = 1;
        int end = arr[size-1] - arr[0];
        int result = 0;

        //3. 집들 사이의 거리를 기준으로 이분 탐색을 진행한다.
        while (start <= end) {
            int mid = (start+end) / 2;

            int cnt = 1;
            int prev_house = arr[0];
            for (int i = 1; i < size; i++) {
                if (arr[i] - prev_house >= mid) {
                    cnt++;
                    prev_house = arr[i];
                }
            }

            //4. 3을 만족하는 거리 중 최댓값을 갱신한다.
            //공유기를 제한 갯수 이상 사용했을 경우, 공유기를 설치 하는 거리를 늘린 후 다시 설치해 본다.
            if (cnt >= choice) {
                result = Math.max (result, mid);
                start = mid+1;
            }
            //공유기를 제한 갯수 미만 사용했을 경우, 공유기를 설치 하는 거리를 좁힌 후 다시 설치해 본다.
            else end = mid-1;
        }

        System.out.println(result);
    }
}