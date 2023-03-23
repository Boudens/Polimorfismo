package entities;

import java.time.LocalDate;

public final class UsedProduct extends Product{
	private LocalDate manufactureDate;
	
	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, LocalDate manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	
	public String priceTag() {
		super.setName(super.getName() + " (utilisé) ");
		return super.priceTag() + (" (Date de manufacture: " + manufactureDate + ")");
	}
}
