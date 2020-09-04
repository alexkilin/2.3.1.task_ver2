package web.dao;

import web.model.User;

import java.util.List;


public interface UserDao {
        void add(User user);
        void deleteUser(User user);
        List<User> listUsers();
        void update(User user);

        User readUserById (Long id);
}