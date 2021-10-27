import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> list = new ArrayList();
        int[] curr_interval = intervals[0];
        list.add(curr_interval);
        
        for(int[] interval:intervals){
            int first_begin = curr_interval[0];
            int first_end = curr_interval[1];
            int next_begin = interval[0];
            int next_end = interval[1];
            if(first_end>=next_begin){
                curr_interval[1] = Math.max(first_end,next_end);
            }else{
                curr_interval = interval;
                    list.add(curr_interval);
            }
        }
        return list.toArray(new int[list.size()][]);
        
    }
}