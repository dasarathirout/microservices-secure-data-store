package org.dasarathi.sds.one.service;

import org.dasarathi.sds.one.model.User;

import java.util.List;

public interface IUserService {

    public abstract List<User> getAll();

    public abstract List<User> listPerson();

    public abstract User search(int userID);

    public abstract String add(User user);

    public abstract String delete(int userID);

    public abstract String edit(User user);
}
