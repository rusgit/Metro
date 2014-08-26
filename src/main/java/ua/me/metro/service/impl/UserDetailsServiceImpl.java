package ua.me.metro.service.impl;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.me.metro.domain.User;

import javax.inject.Inject;
import javax.inject.Named;

@Named("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Inject
    private SessionFactory sessionFactory;

    public UserDetailsServiceImpl() {
    }

    @Transactional(propagation= Propagation.REQUIRED)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.username=:username ");
        query.setParameter("username", username);

        User result = (User) query.uniqueResult();

        if(result==null) throw new UsernameNotFoundException("username: " + username + "not found!");

        return result;

    }
}
