class LockingTree {

    private int[] parentArrayVar;
    private List<Integer>[] childrenListTree;
    private int[] lockedByUserId;

    public LockingTree(int[] parent) {
        int totalNodesCount = parent.length;
        this.parentArrayVar = parent;
        this.childrenListTree = new ArrayList[totalNodesCount];
        this.lockedByUserId = new int[totalNodesCount];
        
        for (int iterationIndex = 0; iterationIndex < totalNodesCount; iterationIndex++) {
            this.childrenListTree[iterationIndex] = new ArrayList<>();
        }
        
        for (int iterationIndex = 1; iterationIndex < totalNodesCount; iterationIndex++) {
            this.childrenListTree[parent[iterationIndex]].add(iterationIndex);
        }
    }

    public boolean lock(int num, int user) {
        if (this.lockedByUserId[num] == 0) {
            this.lockedByUserId[num] = user;
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        if (this.lockedByUserId[num] == user) {
            this.lockedByUserId[num] = 0;
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        if (this.lockedByUserId[num] != 0) {
            return false;
        }

        int currentNodePointer = this.parentArrayVar[num];
        while (currentNodePointer != -1) {
            if (this.lockedByUserId[currentNodePointer] != 0) {
                return false;
            }
            currentNodePointer = this.parentArrayVar[currentNodePointer];
        }

        boolean hasLockedDescendant = false;
        Queue<Integer> bfsQueueStructure = new LinkedList<>();
        bfsQueueStructure.add(num);
        List<Integer> lockedDescendantsList = new ArrayList<>();

        while (!bfsQueueStructure.isEmpty()) {
            int poppedNodeElement = bfsQueueStructure.poll();
            for (int childNodeElement : this.childrenListTree[poppedNodeElement]) {
                if (this.lockedByUserId[childNodeElement] != 0) {
                    hasLockedDescendant = true;
                    lockedDescendantsList.add(childNodeElement);
                }
                bfsQueueStructure.add(childNodeElement);
            }
        }

        if (!hasLockedDescendant) {
            return false;
        }

        for (int lockedNodeElement : lockedDescendantsList) {
            this.lockedByUserId[lockedNodeElement] = 0;
        }
        this.lockedByUserId[num] = user;

        return true;
    }
}