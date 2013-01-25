import java.util.*;
public class Solution {
    class Coord {
        public int index;
        public int value;
        public Coord(int ind, int val) {
            index = ind;
            value = val;
        }
    }
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height.length<=1) {
            return 0;
        }
        Vector<Coord> visited = new Vector<Coord>();
        visited.add(new Coord(0,height[0]));
        int capacity = 0;
        for(int i=1; i<height.length; i++) {
            Iterator<Coord> it = visited.iterator();
            Coord c = null;
            while(it.hasNext()) {
                c = it.next();
                int cap = (i-c.index)*(height[i]<c.value?height[i]:c.value);
                if(cap>capacity) {
                    capacity = cap;
                }
            }
            if(height[i]>c.value) {
                visited.add(new Coord(i,height[i]));
            }
        }
        return capacity;
    }
}