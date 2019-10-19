import java.util.ArrayList;

public class ShoppingBasket {

    private double total;
    private ArrayList<Product> products;
    private ArrayList<Product> productsWithDiscount;
    private boolean loyaltyCard;

    public ShoppingBasket() {
        this.total = 0;
        this.products = new ArrayList<Product>();
        this.productsWithDiscount = new ArrayList<Product>();
        this.loyaltyCard = false;
    }

    public boolean getLoyaltyCard() {
        return this.loyaltyCard;
    }

    public void changeLoyaltyCardStatus() {
        this.loyaltyCard = !loyaltyCard;
    }

    public double getTotal() {
        double total1 = 0;
        double total2 = 0;
        for (Product prod : products) {
            total1 += prod.getPrice();
        }
        for (Product prodDisc : productsWithDiscount) {
            total2 += prodDisc.getPrice();
        }
        return this.total = total1 + total2;
    }

    public ArrayList<Product> getProductsToBuy() {
        return this.products;
    }

    public ArrayList<Product> getProductsToBuyWithDiscount() {
        return this.productsWithDiscount;
    }

    public int countProductsToBuyNoDiscount() {
        return this.getProductsToBuy().size();
    }

    public int countProductsToBuyDiscount() {
        return this.getProductsToBuyWithDiscount().size();
    }


    public void addProduct(Product product) {
        if (product.getDiscount2For1()) {
            this.productsWithDiscount.add(product);
        } else {
            this.products.add(product);
        }
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public void empty() {
        this.products.clear();
    }

    public double checkOut() {
        double freeProducts = this.countProductsToBuyDiscount() / 2;
        double discount = 0;
        for (Product prod : productsWithDiscount) {
            discount = prod.getPrice() * freeProducts;
        }
        double newTotal = this.getTotal() - discount;
        if (newTotal >= 20.00) {
            double discountAmount = (newTotal * 0.1);
            newTotal -= discountAmount;
        }
        if (this.loyaltyCard == true) {
            double loyaltyAmount = (newTotal * 0.02);
            newTotal -= loyaltyAmount;
        }
        return newTotal;
    }
}
