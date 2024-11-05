class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int[] rank = new int[list.size()];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i+1);
        }
        int result[] = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            result[index++] = map.get(arr[i]);
        }
        return result;
    }
}