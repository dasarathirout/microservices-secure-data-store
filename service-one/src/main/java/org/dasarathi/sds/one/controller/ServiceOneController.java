package org.dasarathi.sds.one.controller;

import org.dasarathi.sds.one.controller.helper.OneHelper;
import org.dasarathi.sds.one.model.User;
import org.dasarathi.sds.one.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/serviceOne/api/v1")
public class ServiceOneController {
    Logger LOG = Logger.getLogger(ServiceOneController.class.getName());

    @Autowired
    IUserService userService;

    @GetMapping("/users")
    private List<User> getAllUser() {
        List<User> allUsers = null;
        try {
            LOG.info("getAllUser()");
            allUsers = userService.getAll();
        } catch (Exception ex) {
            LOG.severe("getAllUser() failed with " + ex.getMessage());
            throw new HttpMessageNotReadableException("Unable to fetch all user.");
        }
        return allUsers;
    }

    @GetMapping("/user/{userID}")
    private User getUser(@PathVariable("userID") int userID) {
        User findUser;
        try {
            LOG.info("getUser()");
            findUser = userService.search(userID);
        } catch (Exception ex) {
            LOG.severe("getAllUser() failed with " + ex.getMessage());
            throw new HttpMessageNotReadableException("Unable to fetch user :" + userID);
        }
        return findUser;
    }

    @PostMapping(value = "/user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    private User saveUser(@RequestHeader(name = "fileType", required = false) String fileTypeByHeader,
                          @RequestParam(name = "fileType", required = false) String fileTypeByParameter,
                          @RequestBody User user) throws MissingServletRequestParameterException {

        LOG.info("saveUser()" + user);
        OneHelper.checkFileTypeInRequest(fileTypeByHeader, fileTypeByParameter);
        userService.save(user);
        return userService.search(user.getId());
    }

    @PutMapping(value = "/user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    private User updateUser(@RequestHeader(name = "fileType", required = false) String fileTypeByHeader,
                            @RequestParam(name = "fileType", required = false) String fileTypeByParameter,
                            @RequestBody User user) throws MissingServletRequestParameterException {
        LOG.info("updateUser()");
        OneHelper.checkFileTypeInRequest(fileTypeByHeader, fileTypeByParameter);
        userService.edit(user);
        return user;
    }

    /* For Dev Test Only*/
    @DeleteMapping("/user/{userID}")
    private void deleteUser(@PathVariable("userID") int userID) {
        LOG.info("deleteUser()" + userID);
        userService.delete(userID);
    }

}
