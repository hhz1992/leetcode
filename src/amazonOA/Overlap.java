package amazonOA;

/**
 * Created by Huanzhou on 2016/2/13.
 */
public class Overlap {
    public static boolean isOverlap(Point l1, Point r1, Point l2, Point r2){
        if(l2.x >= r1.x || r2.y >= l1.y || r2.x <= l1.x || l2.y <= r1.y)
            return false;
        return true;
    }


}
class Point {
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
