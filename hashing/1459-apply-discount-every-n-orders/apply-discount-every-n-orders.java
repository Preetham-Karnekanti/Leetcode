class Cashier {
    int n;
    int discount;
    int count;
    HashMap<Integer, Integer> productsToPrices;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.count = 0;
        this.discount = discount;
        productsToPrices = new HashMap<>();
        for (int i = 0; i < products.length; i++)
            productsToPrices.put(products[i], prices[i]);
    }

    public double getBill(int[] product, int[] amount) {
        count++;
        double bill = 0;
        for (int i = 0; i < product.length; i++) {
            bill += amount[i] * productsToPrices.get(product[i]);
        }
        if (count == n) {
            bill = bill * (100 - discount) / 100;
            count = 0;
        }
        return bill;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */