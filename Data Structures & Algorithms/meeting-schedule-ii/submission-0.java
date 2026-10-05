/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Interval i : intervals) {
            map.put(i.start, map.getOrDefault(i.start, 0) + 1);
            map.put(i.end, map.getOrDefault(i.end, 0) - 1);
        }
        int maxRooms = 0;
        int rooms = 0;
        for(Integer i : map.keySet()) {
            rooms += map.get(i);
            if(maxRooms < rooms){
                maxRooms = rooms;
            }
        }
        return maxRooms;
    }
}
