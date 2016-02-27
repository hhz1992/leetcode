package binarysearch;

/**
 * Created by Huanzhou on 2016/2/2.
 */
public class No278_FirstBadVersion {

    public boolean isBadVersion(int version){
        return true;
    }


    public int firstBadVersion(int n) {

        int start = 1, end = n, mid = 1;

        while(end>start){
            mid = start + (end-start) / 2;
            if(isBadVersion(mid))
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }

}
