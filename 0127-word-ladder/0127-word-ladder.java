class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        int L = beginWord.length();

        Map<String, List<String>> patterns = new HashMap<>();

        for (String word : dict) {
            for (int i = 0; i < L; i++) {
                String p = word.substring(0, i) + "*" + word.substring(i + 1);
                patterns.computeIfAbsent(p, k -> new ArrayList<>()).add(word);
            }
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        Set<String> vis = new HashSet<>();
        vis.add(beginWord);

        int steps = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                String word = q.poll();
                if (word.equals(endWord)) return steps;

                for (int i = 0; i < L; i++) {
                    String p = word.substring(0, i) + "*" + word.substring(i + 1);
                    if (!patterns.containsKey(p)) continue;

                    for (String nei : patterns.get(p)) {
                        if (!vis.contains(nei)) {
                            vis.add(nei);
                            q.add(nei);
                        }
                    }

                    patterns.get(p).clear(); // optimization
                }
            }
            steps++;
        }

        return 0;
    }
}