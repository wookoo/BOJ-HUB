import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len = arr2.length;
        boolean visited[] = new boolean[arr1.length];

        int result[] = new int[arr1.length];
        int index = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr2[i] == arr1[j] && !visited[j]) {
                    visited[j] = true;
                    result[index++] = arr1[j];
                }
            }
        }
        
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            if (!visited[i]) {
                arr.add(arr1[i]);
            }
        }
        Collections.sort(arr);
        while (!arr.isEmpty()) {
            result[index++] = arr.get(0);
            arr.remove(0);
        }
        return result;


    }
}