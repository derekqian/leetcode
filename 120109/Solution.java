public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height.length<=1) {
            return 0;
        }
        int capacity = 0;
        for(int i=0; i<height.length-1; i++) {
            for(int j=i+1; j<height.length; j++) {
                int cap = height[i]<height[j]?height[i]:height[j];
                cap = cap*(j-i);
                if(cap>capacity) {
                    capacity = cap;
                }
            }
        }
        return capacity;
    }
}