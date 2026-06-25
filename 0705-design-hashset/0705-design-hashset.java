class MyHashSet {
    private boolean[] store;

    public MyHashSet() {
        store = new boolean[1_000_00_1];
    }
    
    public void add(int key) {
        store[key] = true;
    }
    
    public void remove(int key) {
        store[key] = false;
    }
    
    public boolean contains(int key) {
        return store[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */