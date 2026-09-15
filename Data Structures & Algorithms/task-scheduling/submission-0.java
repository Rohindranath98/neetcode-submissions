class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count=new int[26];
        for(char task:tasks){
            count[task-'A']++;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int c: count){
            if(c>0){
                pq.add(c);
            }
        }
        int time=0;
        while(!pq.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<=n;i++){
                if(!pq.isEmpty()){
                    int freq=pq.poll();
                    if(freq-1>0){
                        temp.add(freq-1);
                    }
                }
                time++;
                if(pq.isEmpty() && temp.isEmpty()){
                    break;
             
                }
            }
            for(int freq:temp){
                pq.add(freq);
            }
        }
        return time;
    }
}
