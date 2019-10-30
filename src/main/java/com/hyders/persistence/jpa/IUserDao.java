package com.hyders.persistence.jpa;

import com.hyders.persistence.model.User.User;
import java.util.List;

public interface IUserDao {


    public User findOne(long id);

    public List<User>findAll();

    public User create(User user);

    public User update(User user);

    public void delete(User user);

    public void deleteById(long entityId);


}
