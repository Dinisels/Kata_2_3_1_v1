package com.dao;


import com.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDao {


    @PersistenceContext
    private EntityManager entityManager;

    public UserDao() {}

    public List<User> getAllUsers(){
        return null;
    }



public void addUser(User user){
    //sessionFactory.getCurrentSession().save(user);
    entityManager.persist(user);
}






}
