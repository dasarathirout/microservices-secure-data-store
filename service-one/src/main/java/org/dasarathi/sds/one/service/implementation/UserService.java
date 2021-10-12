package org.dasarathi.sds.one.service.implementation;

import org.dasarathi.sds.one.model.User;
import org.dasarathi.sds.one.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<User> listPerson() {
        return null;
    }

    @Override
    public User search(int findBy) {
        return null;
    }

    @Override
    public String add(User user) {
        return null;
    }

    @Override
    public String delete(int user) {
        return null;
    }

    @Override
    public String edit(User user) {
        return null;
    }
}
