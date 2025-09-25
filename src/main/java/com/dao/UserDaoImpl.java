package com.dao;


import com.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO{


    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl() {}

    @Override
    public List<User> getAllUsers(){

        return entityManager.createQuery("select u from User u",User.class).getResultList();
    }


@Override
public void saveUser(User user){
    //sessionFactory.getCurrentSession().save(user);

    if (user.getId() == null){
        entityManager.persist(user);
    }else {
        entityManager.merge(user);
    }

}

    @Override
    public User getUserById(int userId) {
        return entityManager.find(User.class,userId);
    }

    @Override
    public void deleteUser(int userId) {

        entityManager.remove(getUserById(userId));

    }


}
