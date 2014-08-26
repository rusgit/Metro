package ua.me.metro.service.impl;

import javax.inject.Inject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.me.metro.dao.IUserDAO;
import ua.me.metro.domain.User;
import ua.me.metro.exceptions.IllegalParameterException;
import ua.me.metro.exceptions.NotFoundException;
import ua.me.metro.service.IUserService;

import java.util.Set;

@Service("userService")
public class UserService implements IUserService{
	private static final Logger LOG = Logger.getLogger(UserService.class);
	
	@Inject
	private IUserDAO iUserDAO;

	@Transactional(propagation=Propagation.REQUIRED)
	public boolean addUser(User user) {

        try {
            LOG.debug("START ADDING USER...");
            iUserDAO.addUser(user);
            LOG.info("Add User successfully");
            return true;

        } catch (IllegalParameterException e) {
            LOG.error(e);
        }
        return false;
		
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public User getUserByUsername(String username) {

        try {
            LOG.debug("START GET USER...");
            User user = iUserDAO.getUserByUsername(username);
            LOG.info("Get User successfully");
            return user;

        } catch (IllegalParameterException | NotFoundException | IndexOutOfBoundsException e) {
            LOG.error(e);
        }
        return null;
    }

}
