public class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void addStock(int stock) {
        if (stock > 0){
            this.stock += stock;
        }
    }

    public void reduceStock() {
        if (this.stock > 0) {
            this.stock--;
        }
    }

}
