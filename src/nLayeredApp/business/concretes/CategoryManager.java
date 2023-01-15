package nLayeredApp.business.concretes;

import nLayeredApp.business.abstracts.CategoryService;
import nLayeredApp.dataAccess.abstracts.CategoryDao;
import nLayeredApp.entities.concretes.Category;

public class CategoryManager implements CategoryService {
	
	private CategoryDao categoryDao;

	public CategoryManager(CategoryDao categoryDao) {
		
		this.categoryDao = categoryDao;
	}

	@Override
	public void add(Category category) {
		System.out.println("Kategori ekleniyor...");
		this.categoryDao.add(category);
	}

	public void update(Category category) {
		System.out.println("Kategori güncelleniyor...");
		this.categoryDao.update(category);
	}

	@Override
	public void delete(Category category) {
		System.out.println("Kategori siliniyor...");
		this.categoryDao.delete(category);
	}

	@Override
	public Category[] getAll() {
		return (Category[]) this.categoryDao.getAll();
	}

}