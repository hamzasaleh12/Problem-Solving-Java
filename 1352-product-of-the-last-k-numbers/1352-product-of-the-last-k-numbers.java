class ProductOfNumbers {
    private List<Integer> prefix;
    int zero = -1;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            zero = prefix.size(); // 2
            prefix.add(1); // [3,1]
        } else {
            int last = prefix.get(prefix.size() - 1);
            prefix.add(last * num); // [3,1,2,10,40] , zeros = 2
        }
    }

    public int getProduct(int k) {
        int n = prefix.size() - 1; // 4
        if (n - k < zero) {
            return 0;
        }
        return prefix.get(n) / prefix.get(n - k); // 40 / 2
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */