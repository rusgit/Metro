package ua.me.metro.dao.impl;

import java.util.List;
import javax.inject.Inject;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.me.metro.dao.IUserDAO;
import ua.me.metro.domain.User;
import ua.me.metro.exceptions.NotFoundException;
import ua.me.metro.exceptions.IllegalParameterException;

@Repository("userDAOImpl")
public class UserDAOImpl implements IUserDAO{

	@Inject
	private SessionFactory sessionFactory;

	public void addUser(User user) throws IllegalParameterException {
		if (user==null) { 
			throw new IllegalParameterException("ADD USER FAILED: You are trying to add a null user");
		}
		if (user.getUsername()  == null) {
			throw new IllegalParameterException("ADD USER FAILED: no login");
		}
		if (user.getPassword()  == null) {
			throw new IllegalParameterException("ADD USER FAILED: no password");
		}
		if (user.getUsername().length() < 5) {
			throw new IllegalParameterException("ADD USER FAILED: login must be more then 5 symbols");
		}
		if (user.getPassword().length() < 5) {
			throw new IllegalParameterException("ADD USER FAILED: password must be more then 5 symbols");
		}
			
		sessionFactory.getCurrentSession().save(user);
	}
		


	public User getUserByUsername(String username) throws IllegalParameterException, NotFoundException{
		if (username==null) {
			throw new IllegalParameterException("GET USER FAILED: login cannot be null");
		}
	
		Query query = sessionFactory.getCurrentSession().
				createQuery("from User where username =:username");
				query.setParameter("username", username);
				
				@SuppressWarnings("unchecked")
				List<User> users = (List<User>) query.list();
			
		if (users==null) {
			throw new NotFoundException("GET USER FAILED: User by " + username + " not found");
		} 
		
		User user = users.get(0);
		return user;
	}

}
