package org.dasarathi.sds.two.service;

import org.dasarathi.sds.core.model.User;
import org.dasarathi.sds.two.data.MemoryDB;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class ServicesTwoProvider implements ServicesTwoI {
    private static final Logger LOF = Logger.getLogger(ServicesTwoProvider.class.getName());

    public User searchByID(int ID) {
        return (User) MemoryDB.searchContents(ID);
    }

    public User deleteByID(int ID) {
        return new User();
    }

}
