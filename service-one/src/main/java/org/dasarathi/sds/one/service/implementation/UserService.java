package org.dasarathi.sds.one.service.implementation;

import org.dasarathi.sds.core.encrypt.UserEncryption;
import org.dasarathi.sds.core.grpc.client.UpdateUserClient;
import org.dasarathi.sds.core.model.User;
import org.dasarathi.sds.one.data.MockedUser;
import org.dasarathi.sds.one.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.dasarathi.sds.core.encrypt.UserEncryption.*;

@Service
public class UserService implements IUserService {
    private static final Logger LOG = Logger.getLogger(UserService.class.getName());

    @Override
    public Set<User> getAll() {
        Set<User> userList = null;
        try {
            userList = MockedUser.searchAllUser();
        } catch (Exception ex) {
            LOG.severe("Error getAll() user " + ex.getMessage());
            throw new RuntimeException("Error getAll()");
        } finally {

        }
        return userList;
    }

    @Override
    public User search(int findBy) {
        User result;
        try {
            result = MockedUser.searchAllUser().
                    stream().
                    filter(item -> item.getId() == findBy).
                    collect(Collectors.toList()).
                    get(0);
            doEncryptAndDecrypt(result);
        } catch (Exception ex) {
            LOG.severe("Error At User search(int findBy = " + findBy + " ) => " + ex.getMessage());
            throw new RuntimeException("Error search(int findBy = " + findBy + " )");
        } finally {

        }
        return result;
    }

    @Override
    public User save(User newSavedUser, String fileType) {
        fileType = fileType.toUpperCase();
        try {
            //getAll().add(newSavedUser);// For Mocked Suer List Local.
            String encryptedUserValues = null;
            switch (fileType) {
                case "CSV":
                    LOG.info("Save encryptUserContents with CSV Format");
                    encryptedUserValues = UserEncryption.encryptUserContents(UserEncryption.withCSVFormat(newSavedUser));
                    break;
                case "JSON":
                    LOG.info("Save encryptUserContents with JSON Format");
                    encryptedUserValues = UserEncryption.encryptUserContents(UserEncryption.withJSONFormat(newSavedUser));
                    break;
                case "XML":
                    LOG.info("Save encryptUserContents with XML Format");
                    encryptedUserValues = UserEncryption.encryptUserContents(UserEncryption.withXMLFormat(newSavedUser));
                    break;
                default:
                    LOG.severe("NO IDEA! For FGiven File Type");
                    break;
            }
            if(encryptedUserValues!= null){
                UpdateUserClient.executeSaveUpdateClient(newSavedUser.getId(), fileType, encryptedUserValues);
            }else {
                LOG.severe("NO IDEA! For NULL Contents Save.");
            }
        } catch (Exception ex) {
            LOG.severe("Error During Save User : " + ex.getMessage());
            throw new RuntimeException("Unable to Save uew User");
        }
        return newSavedUser;
    }

    @Override
    public User edit(User updatedUser) {
        User currentUser = null;
        try {
            currentUser = search(updatedUser.getId());
            LOG.info("Updating From " + currentUser + " => To => " + updatedUser);
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
            result = MockedUser.searchAllUser().
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

    private void doEncryptAndDecrypt(User inUser) {
        decryptUserContents(encryptUserContents(withJSONFormat(inUser)));
        decryptUserContents(encryptUserContents(withXMLFormat(inUser)));
        decryptUserContents(encryptUserContents(withCSVFormat(inUser)));
    }

}
