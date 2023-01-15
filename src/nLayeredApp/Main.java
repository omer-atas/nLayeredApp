package nLayeredApp;

import nLayeredApp.business.abstracts.CategoryService;

import nLayeredApp.business.abstracts.ProductService;
import nLayeredApp.business.concretes.CategoryManager;
import nLayeredApp.business.concretes.ProductManager;
import nLayeredApp.dataAccess.concretes.hibernateImpls.*;
import nLayeredApp.entities.concretes.Category;
import nLayeredApp.entities.concretes.Product;

public class Main {
	
	public static void main(String[] args) {

		Product product = new Product(0, "Java", 5);
		Product product2 = new Product(1, "Python", 6);
		Product product3 = new Product(2, "C#", 7);
		Product product4 = new Product(0, "Php", 5);

		ProductService productManager = new ProductManager(new HibernateProductDao());
		productManager.add(product);
		productManager.add(product2);
		productManager.add(product3);
		productManager.update(product4);

		System.out.println("---------------------------------------------------");
		
		System.out.println("Ürünler listeleniyor...");
		Product obj[] = productManager.getAll();
		
		for (Product products : obj) {
			System.out.print(products.getName() + " ");
		}

		System.out.println("\n---------------------------------------------------");

		CategoryService categoryManager = new CategoryManager(new HibernateCategoryDao());
		Category category = new Category(1, "Android");
		Category category1 = new Category(2, "ÝOS");
		Category category2 = new Category(1, "Desktop");

		categoryManager.add(category);
		categoryManager.add(category1);
		categoryManager.update(category2);
		categoryManager.delete(category1);

		System.out.println("---------------------------------------------------");
		System.out.println("Kategoriler listeleniyor...");
		
		Category obj1[] = categoryManager.getAll();
		if (obj1 != null) {
			for (Category categories : obj1) {

				System.out.print(categories.getName() + " ");
			}
		}

	}
}
