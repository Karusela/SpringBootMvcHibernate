package com.karusela.springmvc.SpringBootMvcHibernate.dao;

import com.karusela.springmvc.SpringBootMvcHibernate.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        List<User> allUsers = entityManager
                .createQuery("SELECT u FROM User u", User.class)
                .getResultList();

        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        User merged = entityManager.merge(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        Query query = entityManager.createQuery("delete from User where id =:userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }
}