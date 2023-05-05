package org.jsp.userproductapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.userproductapp.dto.Product;
import org.jsp.userproductapp.dto.User;

public class ProductDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();

	public Product saveProduct(Product product, int user_id) {
		User u = manager.find(User.class, user_id);
		if (u != null) {
			u.getProducts().add(product); // adding the products
			product.setUser(u); // setting user to product
			EntityTransaction transaction = manager.getTransaction();
			manager.persist(product);
			transaction.begin();
			transaction.commit();
			return product;
		}
		return null;
	}

	public Product updateProduct(Product product, int user_id) {
		User u = manager.find(User.class, user_id);
		if (u != null) {
			u.getProducts().add(product);
			product.setUser(u);
			EntityTransaction transaction = manager.getTransaction();
			manager.merge(product);
			transaction.begin();
			transaction.commit();
			return product;
		}
		return null;
	}

	public Product findProductById(int id) {
		return manager.find(Product.class, id);
	}

	public boolean deleteProduct(int id) {
		Product u = findProductById(id);
		if (u != null) {
			manager.remove(u);
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			transaction.commit();
			return true;
		}
		return false;
	}

	public List<Product> findProductByUserId(int user_id) {
		Query q = manager.createQuery("select u.products from User u where u.id=?1");
		q.setParameter(1, user_id);
		return q.getResultList();
	}
}
