package org.dasarathi.sds.one.service.implementation;

import org.dasarathi.sds.one.data.MockUsers;
import org.dasarathi.sds.one.model.User;
import org.dasarathi.sds.one.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Override
    public List<User> getAll() {
        return MockUsers.lists();
    }

    @Override
    public User search(int findBy) {
        return MockUsers.lists().
                stream().
                filter(item -> item.getId() == findBy).
                collect(Collectors.toList()).
                get(0);
    }

    @Override
    public User save(User user) {
        getAll().add(user);
        return user;
    }

    @Override
    public String edit(User user) {
        return null;
    }


    @Override
    public String delete(int user) {
        return null;
    }
}
