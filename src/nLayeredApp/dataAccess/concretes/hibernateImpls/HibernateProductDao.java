package nLayeredApp.dataAccess.concretes.hibernateImpls;

import nLayeredApp.core.collections.MyArrayList;
import nLayeredApp.core.entities.Entity;
import nLayeredApp.dataAccess.abstracts.ProductDao;
import nLayeredApp.entities.concretes.Product;

public class HibernateProductDao implements ProductDao {

	private MyArrayList<Product> myArrayList;

	public HibernateProductDao() {
		this.myArrayList = new MyArrayList<Product>();
	}

	@Override
	public void add(Product product) {
		System.out.println("Ürün hibernate kullanýlarak eklendi : " + product.getName());
		this.myArrayList.add(product);

	}

	@Override
	public void update(Product product) {
		System.out.println("Ürün hibernate kullanýlarak güncellendi : " + product.getName());
		this.myArrayList.update(product.getId(), product);

	}

	@Override
	public void delete(Product product) {
		System.out.println("Ürün hibernate kullanýlarak silindi : " + product.getName());
		this.myArrayList.delete(product.getId());

	}

	@Override
	public Product[] getAll() {

		if (this.myArrayList.getAll() != null) {

			Entity[] entity = this.myArrayList.getAll();
			Product[] products = new Product[this.myArrayList.getAll().length];

			for (int i = 0; i < products.length; i++) {
				products[i] = (Product) entity[i];
			}

			return products;

		} else {
			return null;
		}
	}

}
