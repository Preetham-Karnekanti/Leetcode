//{ Driver Code Starts
import java.util.*;
class GenIP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution sln = new Solution();
            ArrayList<String> str = sln.genIp(s);
            Collections.sort(str);
            if(str.size() == 0)
                System.out.println(-1);
            else{
                for (String u : str) {
                    System.out.println(u);
                }
            }
        }
    }
}
// } Driver Code Ends


/*complete the Function*/

class Solution {
    public ArrayList<String> genIp(String s) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12){
            res.add("-1");
            return res;
        }
        HashSet<String> hs = new HashSet<>();
        helper(s, hs, 1, 0);
        return new ArrayList<>(hs);
    }
    
    public void helper(String s,HashSet<String> res, int idx, int dots){
        if(dots == 3){
            // System.out.println("p "+ s);
            if(isValid(s))
                res.add(s);
        }
        if(idx >= s.length())
            return;
        helper(s.substring(0, idx) +"." + s.substring(idx), res, idx+2, dots+1);
        helper(s, res, idx+1, dots);
    }
    
    public boolean isValid(String s){
        String add[] = s.split("\\.");
        for(String str: add){
            if(hasLeadingZeros(str))
                return false;
            if(str.length() > 3)
                return false;
            int num = Integer.parseInt(str);
            if(num > 255)
                return false;
        }
        return true;
    }
    public boolean hasLeadingZeros(String str){
        return str.length() > 1 && str.charAt(0) == '0';
    }
}