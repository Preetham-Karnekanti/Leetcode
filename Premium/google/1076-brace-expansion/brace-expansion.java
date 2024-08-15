class Solution {
    public String[] expand(String s) {
        String[] ans = helper(s);
        Arrays.sort(ans);
        return ans;
    }

    public String[] helper(String s){
        int n = s.length();
        if(n == 0)
            return new String[]{""};
        if(n == 1)
            return new String[]{s};
        ArrayList<String> res = new ArrayList<>();
        if(s.charAt(0) =='{'){
            int i = 0;
            while(i < s.length() && s.charAt(i)!='}')
                i++;
            String[] left = s.substring(1, i).split(",");
            String right[] = helper(s.substring(i+1));
            for(String l : left){
                for(String r: right)
                    res.add(l + r);
            }
        }else{
            String right[] = helper(s.substring(1));
            for(String r: right){
                res.add(s.charAt(0) + r);
            }
        }
        return res.toArray(new String[0]);
    }
}