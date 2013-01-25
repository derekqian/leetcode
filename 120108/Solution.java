public class Solution {
    public boolean isMatchAux(String s, String p) {
        if(s.length()==0) {
            if(p.length()==0 || (p.length()==1 && p.charAt(0)=='*')) {
                return true;
            } else {
                return false;
            }
        } else {
            if(p.length()==0) {
                return false;
            } else {
                switch(p.charAt(0)) {
		case '*':
		    return isMatchAux(s.substring(1,s.length()),p) || isMatchAux(s.substring(1,s.length()),p.substring(1,p.length()));
		case '.':
		    return isMatchAux(s.substring(1,s.length()),p.substring(1,p.length()));
		default:
		    if(s.charAt(0)!=p.charAt(0)) {
			return false;
		    } else {
			return isMatchAux(s.substring(1,s.length()),p.substring(1,p.length()));
		    }
                }
            }
        }
    }
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p.length() == 0) {
            if(s.length() == 0) {
                return true;
            } else {
                return false;
            }
        }
        boolean star = (p.charAt(0)=='*');
        String temp = new String();
        temp = temp.concat(p.substring(0,1));
        for(int i=1; i<p.length(); i++) {
            if(star) {
                if(p.charAt(i)!='*') {
                    star = !star;
                    temp = temp.concat(p.substring(i,i+1));
                }
            } else {
                temp = temp.concat(p.substring(i,i+1));
                if(p.charAt(i)=='*') {
                    star = true;
                }
            }
        }
        return isMatchAux(s,temp);
    }
    public static void main(String[] args) {
	Solution soln = new Solution();
	soln.isMatch(new String("a"), new String("aa"));
    }
}