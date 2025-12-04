class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) freq.put(num, freq.getOrDefault(num,0)+1);

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<>(){
            public int compare(Integer a, Integer b){
                if(freq.get(a) == freq.get(b)) return b - a;
                return freq.get(a) - freq.get(b);
            }
        });

        for(Integer key : freq.keySet()) queue.offer(key);

        int index = 0;
        
        while(!queue.isEmpty()){
            int key = queue.poll();
            int f = freq.get(key);

            for(int i = 0; i < f; i++){
                nums[index++] = key;
            }
        }

        return nums;
    }
}


/*
class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) freq.put(num, freq.getOrDefault(num,0)+1);

        Integer[] temp = new Integer[n];
        for(int i = 0; i < n; i++) temp[i] = nums[i];

        Arrays.sort(temp, new Comparator<>(){
            public int compare(Integer a, Integer b){
                if(freq.get(a) == freq.get(b)) return b - a;
                return freq.get(a) - freq.get(b);
            }
        });

        for(int i = 0; i < n; i++) nums[i] = temp[i];
        return nums;
    }
}
*/