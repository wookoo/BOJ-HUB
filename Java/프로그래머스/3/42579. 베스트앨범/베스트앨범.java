import java.util.*;
class Solution {

    public ArrayList<Integer> solution(String[] genres, int[] plays) {
    
    
        Map<String,Integer> map = new HashMap<>();
        Map<String,PriorityQueue<int[]>> map2= new HashMap<>(); 
    
        for(int i = 0; i < genres.length; i++){
            String genre = genres[i];
            int count = plays[i];
            if(!map.containsKey(genre)){
                map.put(genre,0);
                map2.put(genre,new PriorityQueue<>(
                    (o1,o2) ->{
                        return Integer.compare(o2[0],o1[0]);
                    }
                ));
            }
            map.put(genre,map.get(genre)+count);
            map2.get(genre).add(new int[]{count,i});
        }

        ArrayList<Integer> answer = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (o1,o2) ->{
                return Integer.compare(o2[0],o1[0]);
            }
        );
        
        String[] distinct = map.keySet().toArray(new String[0]);
        for(int i = 0; i < distinct.length; i++){
            String key = distinct[i];
            pq.add(new int[]{map.get(key),i});
        }
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int keyIndex = temp[1];
            String key = distinct[keyIndex];
            PriorityQueue<int[]> pq2 = map2.get(key);
            for(int i = 0; i < 2; i++){
                if(!pq2.isEmpty()){
                    int[] first = pq2.poll();
                    answer.add(first[1]);
                }
            }
            
           

        }
        

        return answer;
    }
}