package service.category;

import dao.category.CategoryDao;
import dao.category.ICategoryDao;
import model.Category;

import java.util.List;

public class CategoryService implements ICategoryService{
    private ICategoryDao categoryDao = new CategoryDao();

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public boolean save(Category category) {
        return false;
    }

    @Override
    public boolean edit(int id, Category category) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Category getById(int id) {
        return null;
    }
}
