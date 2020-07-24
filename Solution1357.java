class Cashier {

    int n;
    int current;
    int discount;
    Map<Integer, Integer> priceByProductId;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.current = 0;
        this.discount = discount;
        this.priceByProductId = new HashMap();
        for (int i = 0; i < products.length; i++) priceByProductId.put(products[i], prices[i]);    
    }

    public double getBill(int[] product, int[] amount) {
        this.current++;

        double total = 0;
        for (int i = 0; i < product.length; i++) {
            int productPrice = this.priceByProductId.get(product[i]);
            int productAmount = amount[i];
            total += productPrice * productAmount;
        }

        if (current % n == 0) total = total - (this.discount * total) / 100;
        return total;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */