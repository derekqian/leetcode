mport java.util.*;
class Coord implements Comparable<Coord> {
    public int index;
    public int value;
    public Coord(int ind, int val) {
	index = ind;
	value = val;
    }
    public int compareTo(Coord c) {
	return c.value-value;
    }
    static public Comparator<Coord> COMPARE_BY_INDEX = new Comparator<Coord>() {
	public int compare(Coord one, Coord other) {
	    return one.index-other.index;
	}
    };
}

public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height.length<=1) {
            return 0;
        }
        Vector<Coord> heightvec = new Vector<Coord>();
        for(int i=0; i<height.length; i++) {
            heightvec.add(new Coord(i,height[i]));
        }
        Collections.sort(heightvec);
        Vector<Coord> visited = new Vector<Coord>();
        visited.add(heightvec.get(0));
        int capacity = 0;
        for(int i=1; i<heightvec.size(); i++) {
            visited.add(heightvec.get(i));
            Collections.sort(visited,Coord.COMPARE_BY_INDEX);
            Coord c1 = visited.get(0);
            Coord c2 = visited.get(visited.size()-1);
            int cap = (c2.index-c1.index)*(c1.value<c2.value?c1.value:c2.value);
            if(cap>capacity) {
                capacity = cap;
            }
        }
        return capacity;
    }
}