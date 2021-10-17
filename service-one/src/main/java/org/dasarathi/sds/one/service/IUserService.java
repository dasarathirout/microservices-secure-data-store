package org.dasarathi.sds.one.service;

import org.dasarathi.sds.core.model.User;

import java.util.List;
import java.util.Set;

public interface IUserService {

    public abstract Set<User> getAll();

    public abstract User search(int userID);

    public abstract User save(User user, String fileType);

    public abstract User delete(int userID);

    public abstract User edit(User user);
}
