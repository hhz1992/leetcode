package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Huanzhou on 2016/2/2.
 */
public class No252_MeetingRooms {

    public boolean canAttendMeetings(Interval[] intervals) {

        if (intervals == null)
            return false;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });

        for(int i=0;i<intervals.length -1 ;i++){
            if(intervals[i+1].start < intervals[i].end)
                return false;
        }

        return true;
    }

}
