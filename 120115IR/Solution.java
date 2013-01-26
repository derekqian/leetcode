import java.util.*;
public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num<1 || num>3999) {
            return null;
        }
        int power = 1;
        while(num/power != 0) {
            power = power * 10;
        }
        power = power / 10;
        Vector<Integer> intvec = new Vector<Integer>();
        while(power != 0) {
            int i = num/power*power;
	    // important point
            if(i!=0) {
                intvec.add(new Integer(num/power*power));                
            }
            num = num % power;
            power = power / 10;
        }
        Map<Integer,String> tab = new HashMap<Integer,String>();
        tab.put(1,new String("I"));
        tab.put(2,new String("II"));
        tab.put(3,new String("III"));
        tab.put(4,new String("IV"));
        tab.put(5,new String("V"));
        tab.put(6,new String("VI"));
        tab.put(7,new String("VII"));
        tab.put(8,new String("VIII"));
        tab.put(9,new String("IX"));
        tab.put(10,new String("X"));
        tab.put(20,new String("XX"));
        tab.put(30,new String("XXX"));
        tab.put(40,new String("XL"));
        tab.put(50,new String("L"));
        tab.put(60,new String("LX"));
        tab.put(70,new String("LXX"));
        tab.put(80,new String("LXXX"));
        tab.put(90,new String("XC"));
        tab.put(100,new String("C"));
        tab.put(200,new String("CC"));
        tab.put(300,new String("CCC"));
        tab.put(400,new String("CD"));
        tab.put(500,new String("D"));
        tab.put(600,new String("DC"));
        tab.put(700,new String("DCC"));
        tab.put(800,new String("DCCC"));
        tab.put(900,new String("CM"));
        tab.put(1000,new String("M"));
        tab.put(2000,new String("MM"));
        tab.put(3000,new String("MMM"));
        String res = new String();
        for(int i=0; i<intvec.size(); i++) {
            int digit = intvec.get(i);
            String temp = tab.get(digit);
            if(temp==null) {
                return null;
            } else {
                res = res.concat(temp);
            }
        }
        return res;
    }
}