public class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000"))
            return 0;
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains("0000"))
            return -1;
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");
        int levels = 0;
        while (!q.isEmpty()) {
            levels++;
            for (int i = q.size(); i > 0; i--) {
                String s = q.poll();
                if (s.equals(target)) return levels;
                for (int j = 0; j < 4; j++) {
                    String l = rotateLeft(s, j);
                    String r = rotateRight(s, j);
                    if (!visited.contains(l)){
                        if (l.equals(target)) return levels;
                        q.offer(l);
                        visited.add(l);
                    }
                    if (!visited.contains(r)){
                        if (r.equals(target)) return levels;
                        q.offer(r);
                        visited.add(r);
                    }
                }
            }
            
        }
        return -1;
    }
    private String rotateLeft(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '0') {
            chars[i] = '9';
        } else {
            chars[i]--;
        }
        // System.out.println("s : " + s);
        // System.out.println("s - left - : "+i+" : " + String.valueOf(chars));
        return String.valueOf(chars);
    }
    private String rotateRight(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '9') {
            chars[i] = '0';
        } else {
            chars[i]++;
        }
        //  System.out.println("s : " + s);
        // System.out.println("s - right - : "+i+" : " + String.valueOf(chars));
        return String.valueOf(chars);
    }
}