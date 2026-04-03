class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> h = new HashMap<>();
        for(char c : s.toCharArray()) {
            int count = h.getOrDefault(c,0);
            h.put(c, count+1);
        }
        for(char c : t.toCharArray()){
            int count = h.getOrDefault(c,0);
            if(count == 0){
                return false;
            }else if(count-1 == 0){
                h.remove(c);
            }else{
                h.put(c, count-1);
            }
        }
        if(h.size() == 0){
            System.out.println(h.size());
            return true;
        }
        return false;

    }
}
