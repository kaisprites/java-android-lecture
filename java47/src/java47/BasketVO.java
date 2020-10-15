package java47;

public class BasketVO {
	private String product;
	private String price;
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return "BasketVO [product=" + product + ", price=" + price + "]";
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
