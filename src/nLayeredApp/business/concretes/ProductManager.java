package nLayeredApp.business.concretes;

import nLayeredApp.business.abstracts.ProductService;
import nLayeredApp.dataAccess.abstracts.ProductDao;
import nLayeredApp.entities.concretes.Product;

public class ProductManager implements ProductService {

	private ProductDao productDao;

	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public void add(Product product) {
		if (product.getUnitPrice() >= 0) {
			System.out.println("Ürün ekleniyor...");
			this.productDao.add(product);
		} else {
			System.out.println("Ürün fiyatı 0'dan küçük olamaz.");
		}

	}

	@Override
	public void update(Product product) {
		System.out.println("Ürün güncelleniyor...");
		this.productDao.update(product);
	}

	@Override
	public void delete(Product product) {
		System.out.println("Ürün siliniyor...");
		this.productDao.delete(product);
	}

	@Override
	public Product[] getAll() {
		return (Product[]) this.productDao.getAll();
	}

}