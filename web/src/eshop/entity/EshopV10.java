package eshop.entity;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class EshopV10 {

	/**
	 * @param args
	 */
	public static Session openSession() {
		org.hibernate.cfg.Configuration config = new AnnotationConfiguration()
				.configure("eshop.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}

	public static void main(String[] args) {
		/* Load configuration file */
		// demo1();
		// demo2();
		 //demo3();
		demo4();
	}
/**
 * test chức năng đăng nhập
 */
	private static void demo4() {
		Session session = EshopV10.openSession();
		Scanner x = new Scanner(System.in);
		System.out.print("Username: ");
		String id = x.nextLine();
		System.out.print("Password: ");
		String pw = x.nextLine();
		
		try {
			Customer user = (Customer) session.load(Customer.class, id);
			if (pw.equals(user.getPassword())) {
				System.out.println("Login successfully!!!");
			} else {
				System.out.println("Wrong password!!");
			}
		} catch (Exception e) {
			System.out.println("Invalid username!!!");
		}

	}

	/**
	 * thêm một category mới
	 */
	private static void demo3() {
		Session session = EshopV10.openSession();
		Transaction t = session.beginTransaction();
		Category entity = new Category();
		entity.setName("Computer");
		entity.setNameVN("May tinh");

		try {
			session.save(entity);
			t.commit();
			System.out.println("Thêm thành công");
		} catch (Exception e) {
			t.rollback();
		}

	}

	/**
	 * lấy ra giá có giá 5 đến 10
	 */
	private static void demo2() {
		Session session = EshopV10.openSession();
		String hql = "From Product where unitPrice between :min and :max ";

		Query query = session.createQuery(hql);
		query.setDouble("min", 5);
		query.setDouble("max", 10);
		List<Product> list = query.list();
		for (Product p : list) {
			System.out.println(">Name: " + p.getName());
			System.out.println(">Price: " + p.getUnitPrice());
			System.out.println();
		}

	}

	private static void demo1() {
		Session session = EshopV10.openSession();
		OrderDetail entiry = (OrderDetail) session.get(OrderDetail.class,
				100007);

		Order o = entiry.getOrder();
		Product p = entiry.getProduct();
		Customer c = o.getCustomer();
		Category category = p.getCategory();

		System.out.println(">Detail: " + entiry.getId());
		System.out.println(">Order: " + o.getId());
		System.out.println(">Product: " + p.getName());
		System.out.println(">Customer: " + c.getFullname());
		System.out.println(">Category: " + category.getName());
	}

}
