package design;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hhz on 2/28/16.
 */
public class No251_Flatten2DVector {

    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List <Integer> l1 = new ArrayList<Integer>();
        l1.add(1);
        l1.add(2);
        List <Integer> l2 = new ArrayList<Integer>();
        l2.add(3);
        List <Integer> l3 = new ArrayList<Integer>();
        l3.add(4);
        l3.add(5);
        l3.add(6);
        list.add(l1);
        list.add(l2);
        list.add(l3);
        Vector2D v2 = new Vector2D(list);

        while (v2.hasNext()) {
            System.out.println(v2.next());
        }

    }

}

class Vector2D {

    int row,col;
    List<List<Integer>> vec2d;

    public Vector2D(List<List<Integer>> vec2d) {
        row=0;
        col=0;
        this.vec2d = vec2d;
    }

    public int next() {
        return vec2d.get(row).get(col++);
    }

    public boolean hasNext() {
        while(row<vec2d.size()){
            if(vec2d.get(row).size()>0){
                if(col<vec2d.get(row).size())
                    return true;
                else{
                    row++;
                    col = 0;
                }
            }else{
                row++;
            }
        }
        return false;
    }
}
