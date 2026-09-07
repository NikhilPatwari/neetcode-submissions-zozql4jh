class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                maxHeap.offer(new int[] {count[i], i});
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!(maxHeap.isEmpty() && queue.isEmpty())) {
            int[] a = null;
            if (!maxHeap.isEmpty()) {
                a = maxHeap.poll();
                char c = (char) ('a' + a[1]);
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                    return "";
                }
                sb.append(c);
            }
            if (!queue.isEmpty()) {
                maxHeap.offer(queue.poll());
            }
            if (a != null && a[0] > 1) {
                queue.offer(new int[] {a[0] - 1, a[1]});
            }
        }
        return sb.toString();
    }
}