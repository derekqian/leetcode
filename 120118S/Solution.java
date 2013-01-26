import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Set<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
        if(num.length<3) {
            return new ArrayList<ArrayList<Integer>>(res);
        }
        ArrayList<Integer> neg = new ArrayList<Integer>();
        ArrayList<Integer> zero = new ArrayList<Integer>();
        ArrayList<Integer> pos = new ArrayList<Integer>();
        for(int i=0; i<num.length; i++) {
            if(num[i]<0) {
                neg.add(num[i]*-1);
            } else if(num[i]==0) {
                zero.add(num[i]);
            } else {
                pos.add(num[i]);
            }
        }
        Collections.sort(neg);
        Collections.sort(pos);
        ArrayList<Integer> temp = null;
        if(zero.size()>=3) {
            temp = new ArrayList<Integer>();
            temp.add(0);
            temp.add(0);
            temp.add(0);
            res.add(temp);
        }
        if(zero.size()>0) {
            int i=0, j=0;
            while(i<neg.size() && j<pos.size()) {
                if(neg.get(i).equals(pos.get(j))) {
                    temp = new ArrayList<Integer>();
                    temp.add(neg.get(i)*-1);
                    temp.add(0);
                    temp.add(pos.get(j));
                    res.add(temp);
                    i++;
                    j++;
                } else if(neg.get(i) < pos.get(j)) {
                    i++;
                } else {
                    j++;
                }
            }            
        }
        if(neg.size()==0 || pos.size()==0) {
            return new ArrayList<ArrayList<Integer>>(res);
        }
        for(int i=0; i<neg.size()-1; i++) {
            int k = 0;
            for(int j=i+1; j<neg.size(); j++) {
                if(neg.get(i)+neg.get(j)>pos.get(pos.size()-1)) {
                    break;
                } else {
                    while(k<pos.size() && pos.get(k)<neg.get(i)+neg.get(j)) {
                        k++;
                    }
                    if(k==pos.size()) {
                        break;
                    }
                    if(pos.get(k).equals(neg.get(i)+neg.get(j))) {
                        temp = new ArrayList<Integer>();
                        temp.add(neg.get(j)*-1);
                        temp.add(neg.get(i)*-1);
                        temp.add(pos.get(k));
                        res.add(temp);
                    }
                }
            }
        }
        for(int i=0; i<pos.size()-1; i++) {
            int k = 0;
            for(int j=i+1; j<pos.size(); j++) {
                if(pos.get(i)+pos.get(j)>neg.get(neg.size()-1)) {
                    break;
                } else {
                    while(k<neg.size() && neg.get(k)<pos.get(i)+pos.get(j)) {
                        k++;
                    }
                    if(k==neg.size()) {
                        break;
                    }
                    if(neg.get(k).equals(pos.get(i)+pos.get(j))) {
                        temp = new ArrayList<Integer>();
                        temp.add(neg.get(k)*-1);
                        temp.add(pos.get(i));
                        temp.add(pos.get(j));
                        res.add(temp);
                    }
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>(res);  
    }
}