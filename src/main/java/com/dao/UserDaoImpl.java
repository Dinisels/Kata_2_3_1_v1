package com.dao;

import com.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl() {}

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(int userId) {
        return entityManager.find(User.class, userId);
    }

    public void deleteUser(int userId) {
        User u = entityManager.find(User.class, userId);
        if (u == null) {
            throw new javax.persistence.EntityNotFoundException("User not found: " + userId);
        }
        entityManager.remove(u);
    }
}
