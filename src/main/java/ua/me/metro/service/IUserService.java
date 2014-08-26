package ua.me.metro.service;

import ua.me.metro.domain.User;

public interface IUserService {

	public boolean addUser(User user);
    public User getUserByUsername(String login);

}
