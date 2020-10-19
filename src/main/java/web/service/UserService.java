package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void deleteUser(User user);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUserById(Long id);
    User readUserById (Long id);


}
