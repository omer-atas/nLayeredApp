package nLayeredApp.dataAccess.concretes.jdbcImpls;

import nLayeredApp.core.collections.MyArrayList;
import nLayeredApp.core.entities.Entity;
import nLayeredApp.dataAccess.abstracts.CategoryDao;
import nLayeredApp.entities.concretes.Category;

public class JdbcCategoryDao implements CategoryDao {

	private MyArrayList<Category> myArrayList;

	public JdbcCategoryDao() {
		super();
		myArrayList = new MyArrayList<Category>();
	}

	@Override
	public void add(Category category) {
		System.out.println("Kategori jdbc ile kullanýlarak eklendi : " + category.getName());
		this.myArrayList.add(category);
	}

	@Override
	public void update(Category category) {
		System.out.println("Kategori jdbc ile kullanýlarak güncellendi : " + category.getName());
		this.myArrayList.update(category.getId(), category);
	}

	@Override
	public void delete(Category category) {
		System.out.println("Kategori jdbc ile kullanýlarak silindi : " + category.getName());
		this.myArrayList.delete(category.getId());
	}

	@Override
	public <T> Category[] getAll() {
		if (this.myArrayList.getAll() != null) {
			Category[] categories = new Category[this.myArrayList.getAll().length];
			Entity[] entity = this.myArrayList.getAll();
			for (int i = 0; i < categories.length; i++) {
				categories[i] = (Category) entity[i];
			}
			return categories;
		} else {
			return null;
		}
	}
}
