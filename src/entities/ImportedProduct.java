package entities;

public final class ImportedProduct extends Product{
	private Double customsFee;
	
	public ImportedProduct(){
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	public String priceTag() {
		return super.priceTag() + (" (Frais de douane: $" + customsFee + ")");
	}
	
	public Double totalPrice() {
		return super.getPrice() + customsFee;
	}
}
