package com.tyss.assignment.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.assignment.dto.QuizQuestions;
import com.tyss.assignment.dto.Register;
import com.tyss.assignment.dto.Results;

public class LoginDetails implements Quiz {

	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@Override
	public Register login(String username, String Password) {

		try {
			Register login = null;
			entityManagerFactory = Persistence.createEntityManagerFactory("quiz");
			entityManager = entityManagerFactory.createEntityManager();
			login = entityManager.find(Register.class, username);
			return login;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (entityManagerFactory != null) {
					entityManagerFactory.close();
				}
				if (entityManager != null) {
					entityManager.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;

	}// End of the Method

	@Override
	public Register register(Register register) {

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("quiz");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(register);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			try {
				if (entityManagerFactory != null) {
					entityManagerFactory.close();
				}
				if (entityManager != null) {
					entityManager.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		return register;

	}// End of the Method

	@Override
	public QuizQuestions questions(int id) {

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("quiz");
			entityManager = entityManagerFactory.createEntityManager();
			QuizQuestions questions = entityManager.find(QuizQuestions.class, id);
			return questions;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (entityManagerFactory != null) {
					entityManagerFactory.close();
				}
				if (entityManager != null) {
					entityManager.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return null;
	}// End of the Method

	@Override
	public void results(Results results) {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("quiz");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(results);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			try {
				if (entityManagerFactory != null) {
					entityManagerFactory.close();
				}
				if (entityManager != null) {
					entityManager.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}

	}// End of the Method

	@Override
	public Results getResults(Date date) {
		Results results = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("quiz");
			entityManager = entityManagerFactory.createEntityManager();
			results = entityManager.find(Results.class, date);
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (entityManagerFactory != null) {
					entityManagerFactory.close();
				}
				if (entityManager != null) {
					entityManager.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return results;
	}// End of the Method

	public List<Results> getAllResults() {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("quiz");
			entityManager = entityManagerFactory.createEntityManager();
			String read = " from Results ";
			Query query = entityManager.createQuery(read);
			List<Results> list = query.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (entityManagerFactory != null) {
					entityManagerFactory.close();
				}
				if (entityManager != null) {
					entityManager.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return null;
	}
}// End of the Class
