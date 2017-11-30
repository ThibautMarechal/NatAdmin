package com.helmo.NatAdmin.services;

import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.services.crudServices.ICrudService;

import java.util.ArrayList;
import java.util.List;

public class UserService implements ICrudService<User>
{
    public UserService(){}
    @Override
    public List<User> getAll()
    {
        //TODO REST CALL
        List<User> users = new ArrayList<User>();
        for (int i =1; i <= 10; ++i){
            users.add(getById(i));
        }
        return users;
    }

    @Override
    public User getById(long id)
    {
        //TODO REST CALL
        User u = new User();
        u.setFullName("fullname #"+id);
        u.setEmail("email #"+id);
        u.setId(id);
        u.setProfilePictureUrl("http://thibautmarechal.be/natagora/QuentinGriGri.jpg");
        return u;
    }

    @Override
    public void update(User toUpdate)
    {
        //TODO REST CALL
    }

    @Override
    public long create(User toUpdate)
    {
        //TODO REST CALL
        return 1;
    }

    @Override
    public void delete(User toUpdate)
    {
        //TODO REST CALL
    }

    @Override
    public void delete(long idToDelete) {
        //TODO REST CALL
    }
}
