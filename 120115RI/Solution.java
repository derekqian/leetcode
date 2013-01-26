import java.util.*;
public class Solution {
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() == 0) {
            return 0;
        }
        Map<Character,Integer> tab = new HashMap<Character,Integer>();
        tab.put('I',1);
        tab.put('V',5);
        tab.put('X',10);
        tab.put('L',50);
        tab.put('C',100);
        tab.put('D',500);
        tab.put('M',1000);
        Vector<Integer> intvec = new Vector<Integer>();
        for(int i=0; i<s.length(); i++) {
            int temp = tab.get(s.charAt(i));
            intvec.add(new Integer(temp));
        }
        int res = 0;
        for(int i=0; i<intvec.size()-1; i++) {
            int i1 = intvec.get(i);
            int i2 = intvec.get(i+1);
            if(i1<i2) {
                res = res - i1;
            } else {
                res = res + i1;
            }
        }
        res = res + intvec.lastElement();
        return res;
    }
}