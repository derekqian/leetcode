public class Solution {
    public boolean isMatchAux(String s, String p) {
        if(s.length()==0) {
            if(p.length()%2==0) {
                int i=1;
                for(;i<p.length();) {
                    if(p.charAt(i)!='*') {
                        return false;
                    }
                    i++;i++;
                }
                return true;
            } else {
                return false;
            }
        } else {
            if(p.length()==0) {
                return false;
            } else {
                if(p.charAt(0)=='*') {
                    return false;
                }
                if(p.length()>1) {
                    if(p.charAt(1)=='*') {
                        if(p.charAt(0)=='.' || s.charAt(0)==p.charAt(0)) {
                            return isMatchAux(s,p.substring(2,p.length())) || isMatchAux(s.substring(1,s.length()),p);
                        } else {
                            return isMatchAux(s,p.substring(2,p.length()));
                        }
                    } else {
                        if(p.charAt(0)=='.' || s.charAt(0)==p.charAt(0)) {
                            return isMatchAux(s.substring(1,s.length()),p.substring(1,p.length()));
                        } else {
                            return false;
                        }
                    }
                } else {
                    if(p.charAt(0)=='.' || s.charAt(0)==p.charAt(0)) {
                        return isMatchAux(s.substring(1,s.length()),p.substring(1,p.length()));
                    } else {
                        return false;
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
        return isMatchAux(s,p);
    }
    public static void main(String[] args) {
	Solution soln = new Solution();
	soln.isMatch(new String("a"), new String("aa"));
    }
}