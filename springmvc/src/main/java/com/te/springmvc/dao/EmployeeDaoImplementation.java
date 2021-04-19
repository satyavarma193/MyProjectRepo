package com.te.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.springmvc.beans.EmployeeBean;

@Repository
public class EmployeeDaoImplementation implements EmployeeDao {

	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;

	@Override
	public EmployeeBean authenticate(int id, String password) {

		try {
			factory = Persistence.createEntityManagerFactory("spring");
			manager = factory.createEntityManager();
			EmployeeBean bean = manager.find(EmployeeBean.class, id);
			if (bean != null) {
				if (bean.getPassword().equals(password)) {
					System.out.println("Login Sucess");
					return bean;
				} else {
					System.out.println("wrong password");
					return null;
				}

			} else {
				System.out.println("Invalid credentials");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (factory != null) {
				factory.close();
			}
			if (manager != null) {
				manager.close();
			}
		}
		return null;
	}

	@Override
	public EmployeeBean getEmployeeData(int id) {
		try {
			factory = Persistence.createEntityManagerFactory("spring");
			manager = factory.createEntityManager();
			EmployeeBean bean = manager.find(EmployeeBean.class, id);
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (factory != null) {
				factory.close();
			}
			if (manager != null) {
				manager.close();
			}
		}
		return null;
	}

	@Override
	public boolean deleteEmpData(int id) {
		factory = Persistence.createEntityManagerFactory("spring");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		EmployeeBean bean = manager.find(EmployeeBean.class, id);
		transaction.begin();
		try {
			if (bean != null) {
				manager.remove(bean);
				transaction.commit();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (factory != null) {
				factory.close();
			}
			if (manager != null) {
				manager.close();
			}
		}
		return false;
	}

	@Override
	public List<EmployeeBean> getAllEmp() {
		try {
			factory = Persistence.createEntityManagerFactory("spring");
			manager = factory.createEntityManager();
			String read = " from EmployeeBean ";
			Query query = manager.createQuery(read);
			List<EmployeeBean> data = query.getResultList();
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (factory != null) {
				factory.close();
			}
			if (manager != null) {
				manager.close();
			}
		}
		return null;
	}

}
