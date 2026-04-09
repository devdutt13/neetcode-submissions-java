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
        int[] end = new int[intervals.size()];
        int[] start = new int[intervals.size()];
        for(int i=0;i<intervals.size();i++){
            end[i] = intervals.get(i).end;
            start[i] = intervals.get(i).start;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int s =0;
        int e = 0;
        int count =0;
        int max = 0;
        while(s < intervals.size() && e<intervals.size()){
            if(start[s] < end[e]){
               count++;
               s++;
            }else{
                count--;
                e++;

            }
            max = Math.max(max,count);
        }
        return max;
    }
}
