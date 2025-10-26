import java.util.*;

class Solution {
    static class nvqtiwjzrxka {
        int[] qydfmsurkpbe;
        nvqtiwjzrxka(int[] xgzrmopajwq) { this.qydfmsurkpbe = xgzrmopajwq; }
        @Override public boolean equals(Object hgfytzklqwe) {
            return hgfytzklqwe instanceof nvqtiwjzrxka && Arrays.equals(qydfmsurkpbe, ((nvqtiwjzrxka) hgfytzklqwe).qydfmsurkpbe);
        }
        @Override public int hashCode() { return Arrays.hashCode(qydfmsurkpbe); }
    }

    public List<List<String>> groupAnagrams(String[] pqslvnmhjkre) {
        Map<nvqtiwjzrxka, List<String>> mduqpxtlrysa = new HashMap<>();
        for (String czrhtyplqwas : pqslvnmhjkre) {
            int[] fklgyxvotqmn = new int[26];
            for (char qtfznkporysd : czrhtyplqwas.toCharArray()) fklgyxvotqmn[qtfznkporysd - 'a']++;
            nvqtiwjzrxka udtzyplxqsom = new nvqtiwjzrxka(fklgyxvotqmn);
            mduqpxtlrysa.computeIfAbsent(udtzyplxqsom, k -> new ArrayList<>()).add(czrhtyplqwas);
        }
        return new ArrayList<>(mduqpxtlrysa.values());
    }
}