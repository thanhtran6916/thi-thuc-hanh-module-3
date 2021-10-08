package dao.Product;

import dao.IGeneralDao;
import model.Category;
import model.Product;

import java.util.List;

public interface IProductDao extends IGeneralDao<Product> {
    List<Product> getProductByName(String name);
}
