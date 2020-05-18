package home;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPU");
		EntityManager em = emf.createEntityManager();


		Category c1 = new Category("ELECTRONIC");
		Category c2 = new Category("FOOD");
		Category c3 = new Category("MEDICINE");
		
		Product p1 = new Product("TV", 20, 500000);
		Product p2 = new Product("PHONE", 20, 400000);
		
		Product p3 = new Product("MILK", 200, 1000);
		
		Product p4 = new Product("B2", 500, 3000);
		Product p5 = new Product("V2", 500, 4000);
		
		
		//mapping
		c1.getProduct().add(p1);
		c1.getProduct().add(p2);
		p1.setCategory(c1);
		p2.setCategory(c1);
		
		c2.getProduct().add(p3);
		p3.setCategory(c2);
		
		c3.getProduct().add(p4);
		c3.getProduct().add(p5);
		p4.setCategory(c3);
		p5.setCategory(c3);
		
		
		em.getTransaction().begin();
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.getTransaction().commit();
		
		//querrry
		
	 // query = "select p from Product p where p.category.name =:name";
		 
	  String query="select c from Category c inner join "
		 		+ "c.product p where p.name=:name";
		
		
		
		em.createQuery(query,Category.class)
		.setParameter("name", "B2")
		.getResultList()
		.forEach(e->{
			System.out.println(e);
		});
		
		
		
		
		em.close();
		emf.close();
		util.JPAUtil.checkData("select * from category");
		util.JPAUtil.checkData("select * from product");
		
		
	}

}
