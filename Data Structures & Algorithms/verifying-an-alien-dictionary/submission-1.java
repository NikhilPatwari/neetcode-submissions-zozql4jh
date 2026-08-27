class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSmaller(words[i], words[i + 1], 0, map))
                return false;
        }
        return true;
    }
    private boolean isSmaller(String a, String b, int index, Map<Character, Integer> map) {
        if (index >= a.length() && index < b.length()) {
            return true;
        } else if (index >= b.length() && index < a.length()) {
            return false;
        } else if (index >= b.length() && index >= a.length()) {
            return true;
        }
        char charA = a.charAt(index);
        char charB = b.charAt(index);
        if (charA == charB) {
            return isSmaller(a, b, index + 1, map);
        } else {
            return map.get(charA) <= map.get(charB);
        }
    }
}