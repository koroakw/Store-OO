package entities;

public class OrderItem {
    private Integer quantity;//é recomendado usar wrapper class quando se usa em banco de dados, pois wrapper class se usa nulo, e é bom para usar em herança e polimorfismo
    private Double price;

    private Product product;//faz uma referência a outra classe, pois esta é dependente de outras classes

    public OrderItem(){

    }

    public OrderItem(Integer quantity, Double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public Double subTotal(){
        return price * quantity;
    }

    @Override
    public String toString() {
        return getProduct().getName() + ", $" + String.format("%.2f", price) + ", Quantity: " + quantity + ", Subtotal: $" + String.format("%.2f", subTotal());
    }
}
