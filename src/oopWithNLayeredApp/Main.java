package oopWithNLayeredApp;

import oopWNLayeredApp.bussiness.ProductManager;
import oopWNLayeredApp.core.logging.DataBaseLogger;
import oopWNLayeredApp.core.logging.FileLogger;
import oopWNLayeredApp.core.logging.Logger;
import oopWNLayeredApp.dataAccess.JdbcProductDao;
import oopWNLayeredApp.entities.Product;

import java.util.List;

public class Main {
    public static void main(String[] args)  throws Exception{

        Product product1 = new Product(17,"Sercan",11);

        Logger[] loggers = {new DataBaseLogger(), new FileLogger()};

        ProductManager productManager = new ProductManager(new JdbcProductDao(), (Logger[]) loggers);
        productManager.add(product1);
    }
}