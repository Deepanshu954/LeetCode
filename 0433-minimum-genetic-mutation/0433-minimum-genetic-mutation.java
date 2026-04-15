class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        // Step 1 — put bank in a set for O(1) lookup
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        
        // Edge case — end gene not in bank at all
        if (!bankSet.contains(endGene)) return -1;
        
        // Step 2 — BFS setup
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(startGene);
        visited.add(startGene);
        int mutations = 0;
        
        char[] choices = {'A', 'C', 'G', 'T'};
        
        // Step 3 — BFS level by level
        while (!queue.isEmpty()) {
            int size = queue.size(); // process one level at a time
            mutations++;
            
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                char[] gene = curr.toCharArray();
                
                // Try every position
                for (int pos = 0; pos < 8; pos++) {
                    char original = gene[pos];
                    
                    // Try every character at this position
                    for (char c : choices) {
                        if (c == original) continue; // skip no-change
                        gene[pos] = c;
                        String next = new String(gene);
                        
                        // Valid next state = in bank + not visited
                        if (next.equals(endGene)) return mutations;
                        if (bankSet.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    gene[pos] = original; // restore for next iteration
                }
            }
        }
        
        return -1; // end gene unreachable
    }
}