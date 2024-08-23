class StockPrice {

    int latestTime;
    HashMap<Integer, Integer> timeToPriceMap;
    TreeMap<Integer, Integer>  priceFrequency;

    public StockPrice() {
        latestTime = 0;
        priceFrequency = new TreeMap<>();
        timeToPriceMap = new HashMap<>();
    }

    public void update(int timestamp, int price) {
        latestTime = Math.max(latestTime, timestamp);
        if (timeToPriceMap.containsKey(timestamp)) {
            int oldPrice = timeToPriceMap.get(timestamp);
            priceFrequency.put(oldPrice, priceFrequency.get(oldPrice) - 1);
            if (priceFrequency.get(oldPrice) == 0)
                priceFrequency.remove(oldPrice);
        }
        timeToPriceMap.put(timestamp, price);
        priceFrequency.put(price, priceFrequency.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return timeToPriceMap.get(latestTime);
    }

    public int maximum() {
        return priceFrequency.lastKey();
    }

    public int minimum() {
        return priceFrequency.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */