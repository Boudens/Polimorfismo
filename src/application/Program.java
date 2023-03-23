package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> products = new ArrayList<>();
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Saisir le nombre de produits: ");
		int numberOfProducts = sc.nextInt();		
		for (int i = 0; i < numberOfProducts; i++) {
			System.out.println("Produit #" + (i+1));
			System.out.print("Commun, utilisé or importé (c/u/i) ? ");
			char opcao = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Nom du produit: ");
			String name = sc.nextLine();
			System.out.print("Prix: ");
			double price = sc.nextDouble();
			
			switch(opcao) {
			case 'u':
				System.out.print("Saisir la date de manufacture: ");
				LocalDate manufacureDate = LocalDate.parse(sc.next(),fmt1);
				products.add(new UsedProduct(name, price, manufacureDate));
				break;
			case 'i':
				System.out.print("Saisir les frais de douane: ");
				double customsFee = sc.nextDouble();
				products.add(new ImportedProduct(name, price, customsFee));
				break;
			default:
				products.add(new Product(name, price));	
			}
			
		}
		
		System.out.println("Étiquettes de prix");
		for(Product e: products) {
			 System.out.println(e.priceTag());  
		}

		sc.close();
	}

}
