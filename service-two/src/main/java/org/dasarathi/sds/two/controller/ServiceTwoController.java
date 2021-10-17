package org.dasarathi.sds.two.controller;

import org.dasarathi.sds.core.model.User;
import org.dasarathi.sds.two.controller.error.HttpTwoMessage;
import org.dasarathi.sds.two.data.MemoryDB;
import org.dasarathi.sds.two.service.ServicesTwoProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.logging.Logger;

@RestController
@RequestMapping("/serviceTwo/api/v1")
public class ServiceTwoController {
    private static final Logger LOG = Logger.getLogger(ServiceTwoController.class.getName());

    @Autowired
    ServicesTwoProvider servicesTwoProvider;

    @RequestMapping(method = RequestMethod.GET,
            value = "/user/{userID}")
    private User getUser(@PathVariable("userID") int userID) {
        User findUser;
        try {
            LOG.info("GET: /serviceTwo/api/v1/user/{userID}");
            findUser= MemoryDB.searchContents(userID);
        } catch (Exception ex) {
            LOG.severe("getUser(userID) failed with " + ex.getMessage());
            throw new HttpMessageNotReadableException("Unable to fetch UserTwo :" + userID, new HttpTwoMessage());
        }
        return findUser;
    }

    /* For Dev Test Mocked Data Only */
    @GetMapping("/users")
    private Set<User> searchAllUserFrom() {
        Set<User> userSet = null;
        try {
            LOG.info("GET: /serviceTwo/api/v1/users/{ALL}");
            userSet = servicesTwoProvider.searchAll();
        } catch (Exception ex) {
            LOG.severe("getAllUser() failed with " + ex.getMessage());
            throw new HttpMessageNotReadableException("Unable to fetch all user.", new HttpTwoMessage());
        }
        return userSet;
    }

    /* For Dev Test Only */
    @DeleteMapping("/user/{userID}")
    private void deleteUser(@PathVariable("userID") int userID) {
        LOG.info("DELETE: /serviceTwo/api/v1/user/{userID}");
        servicesTwoProvider.deleteByID(userID);
    }

}
