class Logger {
    HashMap<String, Integer> hm;

    public Logger() {
        hm = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!hm.containsKey(message)) {
            hm.put(message, timestamp);
            return true;
        }
        if (hm.get(message) + 10 > timestamp)
            return false;
        hm.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */