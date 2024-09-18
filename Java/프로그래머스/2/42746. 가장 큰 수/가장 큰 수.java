import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        if(Arrays.stream(numbers).sum() == 0){
            return "0";
        }

        String[] arr = new String[numbers.length];
        for(int i = 0 ; i < arr.length;i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o2+o1) - Integer.parseInt(o1+o2);
            }
        });

        String ans = "";
        for(String an : arr){
            ans +=an;
        }
        return ans;

    }
}

