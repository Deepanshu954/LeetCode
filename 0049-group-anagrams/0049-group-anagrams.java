import java.util.AbstractList;

class Solution {
     List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();

    return new AbstractList<List<String>>() {
      boolean initialized = false;

      public int size() {
        init();
        return result.size();
      }

      public List<String> get(int i) {
        init();
        return result.get(i);
      }

      public void init() {
        if (initialized) {
          return;
        }
        for (String s : strs) {
          char[] arr = s.toCharArray();
          Arrays.sort(arr);
          map.computeIfAbsent(new String(arr), _ -> {
            List<String> list = new ArrayList<String>();
            result.add(list);
            return list;
          }).add(s);
        }
        initialized = true;
      }
    };

  }
}