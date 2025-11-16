class Solution {
    public int racecar(int target) {
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(new int[]{0, 1}); 

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int pos = curr[0];
                int speed = curr[1];

                if (pos == target) return steps;

                String key = pos + "," + speed;
                if (visited.contains(key)) continue;
                visited.add(key);

                int newPos = pos + speed;
                int newSpeed = speed * 2;

                if (Math.abs(newPos - target) <= 2 * target) {
                    q.add(new int[]{newPos, newSpeed});
                }

                int revSpeed = speed > 0 ? -1 : 1;
                q.add(new int[]{pos, revSpeed});
            }
            steps++;
        }
        return -1;
    }
}