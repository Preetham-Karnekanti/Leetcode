class AuthenticationManager {

    int timeToLive;
    HashMap<String, Integer> hm;
    int count;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        hm = new HashMap<>();
        count = 0;
    }

    public void generate(String tokenId, int currentTime) {
        hm.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if (hm.containsKey(tokenId) && hm.get(tokenId) > currentTime)
            hm.put(tokenId, currentTime + timeToLive);

    }

    public int countUnexpiredTokens(int currentTime) {
        count = 0;
        for (int value : hm.values()) {
            if (value > currentTime)
                count++;
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */