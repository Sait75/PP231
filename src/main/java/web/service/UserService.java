package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public void addUser(User user);
    public void delUser(int id);
    public void updUser(User user, int id);


}
