package oop.products;

public class Product {
    protected String name;
    protected String category;
    protected int stock;
    protected Double price;

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
    }
    public Product(String name,  String category, int stock) {
        this.name = name;
        this.stock = stock;
        this.category = category;
    }
    public Product(String name, String category, int stock, Double price) {
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        if(stock >= 0) this.stock = stock; else System.out.println("Počet kusů nemůže být záporný");
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        if (price > 0) this.price = price; else System.out.println("Cena nemůže být záporná nebo 0");
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}
