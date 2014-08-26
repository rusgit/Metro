package ua.me.metro.dao;

import ua.me.metro.domain.User;
import ua.me.metro.domain.UserRole;
import ua.me.metro.exceptions.IllegalParameterException;
import ua.me.metro.exceptions.NotFoundException;

import java.util.Set;

public interface IUserDAO {
	
	/**
	 * 
	 * @param user
	 * @throws IllegalParameterException
	 */
	public void addUser(User user) throws IllegalParameterException;

	/**
	 * 
	 * @param login
	 * @return
	 * @throws IllegalParameterException
	 * @throws NotFoundException
	 */
    public User getUserByUsername(String login) throws IllegalParameterException, NotFoundException;

    /**
     *
     * @param user
     * @return
     * @throws IllegalParameterException
     * @throws NotFoundException
     */

}
