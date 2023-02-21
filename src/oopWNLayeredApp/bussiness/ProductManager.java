package oopWNLayeredApp.bussiness;

import oopWNLayeredApp.core.logging.Logger;
import oopWNLayeredApp.dataAccess.HibernateProductDao;
import oopWNLayeredApp.dataAccess.JdbcProductDao;
import oopWNLayeredApp.dataAccess.ProductDao;
import oopWNLayeredApp.entities.Product;

import java.util.List;

public class ProductManager {
    private ProductDao productDao;
    private Logger[] loggers;
    public ProductManager(ProductDao productDao, Logger[] loggers) {
        this.productDao = productDao;
        this.loggers = loggers;
    }

    public void add(Product product) throws Exception {
        if(product.getUnitPrice()<10){
            throw new Exception("Ürün fiyatı 10'dan küçük olamaz");
        }

        productDao.add(product);

        for (Logger logger: loggers){
            logger.log(product.getName());
        }
    }
}
