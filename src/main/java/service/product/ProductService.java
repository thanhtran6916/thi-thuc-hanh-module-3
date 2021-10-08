package service.product;

import dao.Product.IProductDao;
import dao.Product.ProductDao;
import model.Product;

import java.util.List;

public class ProductService implements IProductService {
    private IProductDao productDao = new ProductDao();


    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public boolean save(Product product) {
        return productDao.save(product);
    }

    @Override
    public boolean edit(int id, Product product) {
        return productDao.edit(id, product);
    }

    @Override
    public boolean delete(int id) {
        return productDao.delete(id);
    }

    @Override
    public Product getById(int id) {
        return productDao.getById(id);
    }

    @Override
    public List<Product> getProductByName(String name) {
        name = "%" + name + "%";
        return productDao.getProductByName(name);
    }
}
