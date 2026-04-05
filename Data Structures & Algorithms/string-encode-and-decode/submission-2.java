class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            int len = s.length();
            sb.append(len);
            sb.append('#');
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int[] temp = stringSize(str,i);
            int size = temp[0];
            int startIndex = temp[1];
            if(size == 0){
                res.add("");
                i = startIndex;
            }else{
                res.add(str.substring(startIndex,startIndex+size));
                i = startIndex + size;
            }
        }
        return res;

    }

    private int[] stringSize(String s, int index){
        StringBuilder size = new StringBuilder();
        for(int i = index ; i < s.length(); i++ ){
            char c = s.charAt(i);
            if(c == '#'){
                return new int[]{Integer.parseInt(size.toString()),i+1};
            }
            size.append(c);
        }
        return new int[]{0,0};
    }
}
