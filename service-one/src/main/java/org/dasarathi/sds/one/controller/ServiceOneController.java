package org.dasarathi.sds.one.controller;

import org.dasarathi.sds.one.controller.helper.OneHelper;
import org.dasarathi.sds.one.model.User;
import org.dasarathi.sds.one.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
        LOG.info("getAllUser()");
        return userService.getAll();
    }

    @GetMapping("/user/{userID}")
    private User getUser(@PathVariable("userID") int userID) {
        LOG.info("getUser()");
        return userService.search(userID);
    }

    @PostMapping(value = "/user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    private User saveUser(@RequestHeader(name = "fileType", required = false) String fileTypeByHeader,
                          @RequestParam(name = "fileType", required = false) String fileTypeByParameter,
                          @RequestBody User user) {
        LOG.info("saveUser()" + user);
        boolean hasValidFileType = OneHelper.checkFileTypeInRequest(fileTypeByHeader, fileTypeByParameter);
        userService.save(user);
        return userService.search(user.getId());
    }

    @PutMapping(value = "/user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    private User updateUser(@RequestBody User user) {
        LOG.info("updateUser()" + user);
        userService.edit(user);
        return user;
    }

    @DeleteMapping("/user/{userID}")
    private void deleteUser(@PathVariable("userID") int userID) {
        LOG.info("deleteUser()" + userID);
        userService.delete(userID);
    }

}
