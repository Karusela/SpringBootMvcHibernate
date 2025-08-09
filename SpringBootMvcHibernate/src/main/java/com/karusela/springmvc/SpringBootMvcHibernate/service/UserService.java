package com.karusela.springmvc.SpringBootMvcHibernate.service;


import com.karusela.springmvc.SpringBootMvcHibernate.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);
}