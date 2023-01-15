package nLayeredApp.dataAccess.concretes.jdbcImpls;

import nLayeredApp.core.collections.MyArrayList;
import nLayeredApp.core.entities.Entity;
import nLayeredApp.dataAccess.abstracts.ProductDao;
import nLayeredApp.entities.concretes.Product;

public class JdbcProductDao implements ProductDao {

	private MyArrayList<Product> myArrayList;

	public JdbcProductDao() {
		this.myArrayList = new MyArrayList<Product>();
	}

	@Override
	public void add(Product product) {
		System.out.println("Ürün jdbc kullanýlarak eklendi : " + product.getName());
		this.myArrayList.add(product);

	}

	@Override
	public void update(Product product) {
		System.out.println("Ürün jdbc kullanýlarak güncellendi : " + product.getName());
		this.myArrayList.update(product.getId(), product);

	}

	@Override
	public void delete(Product product) {
		System.out.println("Ürün jdbc kullanýlarak silindi : " + product.getName());
		this.myArrayList.delete(product.getId());

	}

	@Override
	public <T> Product[] getAll() {
		if (this.myArrayList.getAll() != null) {
			Product[] products = new Product[this.myArrayList.getAll().length];
			Entity[] entity = this.myArrayList.getAll();
			for (int i = 0; i < products.length; i++) {
				products[i] = (Product) entity[i];
			}
			return products;
		} else {
			return null;
		}
	}

}
