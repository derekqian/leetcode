import java.util.*;
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        float base = ((float)target) / 3;
        Vector<Float> fvec = new Vector<Float>();
        for(int i=0; i<num.length; i++) {
            fvec.add(num[i]-base);
        }
        Vector<Float> neg = new Vector<Float>();
        Vector<Float> pos = new Vector<Float>();
        Iterator<Float> it = fvec.iterator();
        while(it.hasNext()) {
            Float temp = it.next();
            if(temp<0) {
                neg.add(temp*-1);
            } else {
                pos.add(temp);
            }
        }
        Collections.sort(neg);
        Collections.sort(pos);
        Float fres = null;
        if(neg.size()==0) {
            fres = pos.get(0)+pos.get(1)+pos.get(2);
        } else if(pos.size()==0) {
            fres = neg.get(0)+neg.get(1)+neg.get(2);
            fres = -1 * fres;
        } else {
            fres = neg.get(0)*-1+pos.get(0);
            if(neg.size()>1) {
                fres = fres + neg.get(1)*-1;
            } else {
                fres = fres + pos.get(1);
            }
            for(int i=0; i<neg.size()-1; i++) {
                for(int j=i+1; j<neg.size(); j++) {
                    Float temp = neg.get(i)+neg.get(j);
                    int m=0;
                    int n=pos.size()-1;
                    if(temp<pos.get(m)) {
                        if(pos.get(m)-temp<Math.abs(fres)) {
                            fres = pos.get(m)-temp;
                        }
                    } else if(temp>pos.get(n)) {
                        if(temp-pos.get(n)<Math.abs(fres)){
                            fres = pos.get(n)-temp;
                        }
                    } else {
                        while(n-m>1) {
                            int mid = (m+n)/2;
                            if(pos.get(mid)<temp) {
                                m = mid;
                            } else {
                                n = mid;
                            }
                        }
                        if(temp-pos.get(m)<Math.abs(fres)) {
                            fres = pos.get(m)-temp;
                        }
                        if(pos.get(n)-temp<Math.abs(fres)) {
                            fres = pos.get(n)-temp;
                        }
                    }
                }
            }
            for(int i=0; i<pos.size()-1; i++) {
                for(int j=i+1; j<pos.size(); j++) {
                    Float temp = pos.get(i)+pos.get(j);
                    int m=0;
                    int n=neg.size()-1;
                    if(temp<neg.get(m)) {
                        if(neg.get(m)-temp<Math.abs(fres)){
                            fres = temp - neg.get(m);
                        }
                    } else if(temp>neg.get(n)) {
                        if(temp-neg.get(n)<Math.abs(fres)) {
                            fres = temp - neg.get(n);
                        }
                    } else {
                        while(n-m>1) {
                            int mid = (m+n)/2;
                            if(neg.get(mid)<temp) {
                                m = mid;
                            } else {
                                n = mid;
                            }
                        }
                        if(temp-neg.get(m)<Math.abs(fres)) {
                            fres = temp - neg.get(m);
                        }
                        if(neg.get(n)-temp<Math.abs(fres)) {
                            fres = temp - neg.get(n);
                        }
                    }
                }
            }
        }
        return Math.round(fres)+target;
    }
}