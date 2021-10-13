package org.dasarathi.sds.one.service.implementation;

import org.dasarathi.sds.one.data.MockUsers;
import org.dasarathi.sds.one.model.User;
import org.dasarathi.sds.one.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    Logger LOG = Logger.getLogger(UserService.class.getName());

    @Override
    public List<User> getAll() {
        List<User> allUserList = null;
        try {
            allUserList = MockUsers.lists();
        } catch (Exception ex) {
            LOG.severe("Error getAll() user " + ex.getMessage());
            throw new RuntimeException("Error getAll()");
        } finally {

        }
        return allUserList;
    }

    @Override
    public User search(int findBy) {
        User result = null;
        try {
            result = MockUsers.lists().
                    stream().
                    filter(item -> item.getId() == findBy).
                    collect(Collectors.toList()).
                    get(0);
            LOG.info("Search Result Found For  " + findBy + result);
        } catch (Exception ex) {
            LOG.severe("Error At User search(int findBy = " + findBy + " ) => " + ex.getMessage());
            throw new RuntimeException("Error search(int findBy = " + findBy + " )");
        } finally {

        }
        return result;
    }

    @Override
    public User save(User newSavedUser) {
        try {
            getAll().add(newSavedUser);
            LOG.info("Saved : " + newSavedUser);
        } catch (Exception ex) {
            LOG.severe("Error During Save User : " + ex.getMessage());
            throw new RuntimeException("Unable to Save uew User");
        } finally {

        }
        return newSavedUser;
    }

    @Override
    public User edit(User updatedUser) {
        User currentUser = null;
        try {
            currentUser = search(updatedUser.getId());
            LOG.info("Updating From " + currentUser + "=> To =>" + updatedUser);
            currentUser.setId(updatedUser.getId());
            currentUser.setName(updatedUser.getName());
            currentUser.setDateOfBirth(updatedUser.getDateOfBirth());
            currentUser.setSalary(updatedUser.getSalary());
            currentUser.setCurrentAge(updatedUser.getCurrentAge());
        } catch (Exception ex) {
            LOG.severe("Error During Update User : " + ex.getMessage());
            throw new RuntimeException("Error During Update User :" + updatedUser.getId());
        } finally {

        }
        return currentUser;
    }

    @Override
    public User delete(int userID) {
        User result = null;
        try {
            LOG.info("Deleting User " + userID);
            result = MockUsers.lists().
                    stream().
                    filter(item -> item.getId() == userID).
                    collect(Collectors.toList()).
                    remove(userID);
        } catch (Exception ex) {
            LOG.severe("Error During Delete User : " + ex.getMessage());
            throw new RuntimeException("Error During Update User :" + userID);
        } finally {

        }
        return result;
    }

}
