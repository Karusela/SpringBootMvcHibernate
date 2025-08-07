package com.karusela.springmvc.SpringBootMvcHibernate.dao;

import com.karusela.springmvc.SpringBootMvcHibernate.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();
    public void saveUser(User user);
    public User getUser(int id);
    public void deleteUser(int id);
}