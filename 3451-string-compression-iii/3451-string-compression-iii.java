class Solution {
    static class Item{
        char c;
        int f;
        public Item(char c){
            this.c = c;
            this.f = 1;
        }
    }
    public String compressedString(String word) {
        Deque<Item> dq = new LinkedList<>();
        for(int i = 0 ; i < word.length(); i++){
            char now = word.charAt(i);
            if(dq.isEmpty()){
                dq.add(new Item(now));
                continue;
            }
            Item item = dq.peekLast();
            if(item.c == now){
                if(item.f == 9){
                    dq.add(new Item(now));
                }
                else{
                    item.f +=1;
                }
            }
            else{
                dq.add(new Item(now));
            }

        }
        String answer = "";
        while(!dq.isEmpty()){
            Item n = dq.pollFirst();
            answer = answer + n.f + n.c;
        }
        return answer;
    }
}