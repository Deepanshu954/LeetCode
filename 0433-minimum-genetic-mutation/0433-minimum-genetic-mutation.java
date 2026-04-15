class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        if(!set.contains(end)) return -1;

        Queue<String> q = new ArrayDeque<>();
        Set<String> vis = new HashSet<>();
        q.offer(start);
        vis.add(start);

        char[] choice = {'A','C','G','T'};
        int count = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            count++;

            for(int i = 0; i < size; i++) {
                String curr = q.poll();
                char[] gene = curr.toCharArray();

                for(int j = 0; j < 8; j++) {
                    char og = gene[j];

                    for(char ch : choice) {
                        if(ch == og) continue;
                        gene[j] = ch;
                        String next = new String(gene);

                        if(next.equals(end)) return count;
                        if(set.contains(next) && !vis.contains(next)) {
                            vis.add(next);
                            q.offer(next);
                        }
                    }

                    gene[j] = og;
                }
            }
        }


        return -1;
    }
}

/*

Approach

1. Put all the strings in bank in hashset for O(1) lookup;
2. BFS From start gene
3. For each gene in queue
    -> Try changing each position 0 to 7 times
    -> Try every valid character at that position 
    -> If Result is in bank and not visited -> Add to queue
4. When Your deque the end gene -> return current level(mutation count)
5. If Queue is Empty Return -1

*/