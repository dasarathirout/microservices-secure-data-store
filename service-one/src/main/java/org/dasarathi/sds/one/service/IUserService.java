package org.dasarathi.sds.one.service;

import org.dasarathi.sds.one.model.User;

import java.util.List;

public interface IUserService {

    public abstract List<User> getAll();

    public abstract User search(int userID);

    public abstract User save(User user);

    public abstract User delete(int userID);

    public abstract User edit(User user);
}
