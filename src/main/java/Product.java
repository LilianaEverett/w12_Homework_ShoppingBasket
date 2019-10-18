public class Product {

    private String name;
    private double price;
    private boolean discount2For1;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.discount2For1 = false;
    }


    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean getDiscount2For1() {
        return this.discount2For1;
    }

    public void changeDiscountStatus() {
        this.discount2For1 = !discount2For1;
    }


}
