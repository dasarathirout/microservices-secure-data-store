package org.dasarathi.sds.two.service;

import org.dasarathi.sds.core.data.MemoryDB;
import org.dasarathi.sds.core.model.User;
import org.dasarathi.sds.two.data.MockedUser;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.logging.Logger;


@Service
public class ServicesTwoProvider implements ServicesTwoI {
    private static final Logger LOF = Logger.getLogger(ServicesTwoProvider.class.getName());

    static {
        MockedUser.update();
    }

    public User searchByID(int ID) {
        return (User) MemoryDB.searchContents(ID);
    }

    public Set<User> searchAll() {
        return MemoryDB.getAllContents();
    }

    public User deleteByID(int ID) {
        return new User();
    }

}
