public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs.length==0) {
            return "";
        }
        String res = strs[0];
        for(int i=1; i<strs.length; i++) {
            StringBuffer sb = new StringBuffer();
            for(int j=0; j<res.length()&&j<strs[i].length(); j++) {
                if(res.charAt(j)==strs[i].charAt(j)) {
                    sb.append(res.charAt(j));
                } else {
                    break;
                }
            }
            res = sb.toString();
        }
        return res;
    }
}