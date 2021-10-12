package org.dasarathi.sds.one.controller;

import org.dasarathi.sds.one.model.User;
import org.dasarathi.sds.one.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private List<User> getAllBooks() {
        LOG.info("getAllBooks()");
        return userService.getAll();
    }

    @GetMapping("/user/{userID}")
    private User getBooks(@PathVariable("userID") int userID) {
        LOG.info("getBooks()");
        return userService.search(userID);
    }

    @DeleteMapping("/user/{userID}")
    private void deleteBook(@PathVariable("userID") int userID) {
        LOG.info("deleteBook()");
        userService.delete(userID);
    }

    @PostMapping("/user")
    private User saveUser(@RequestBody User user) {
        LOG.info("saveUser()");
        userService.edit(user);
        return userService.search(user.getId());
    }

    @PutMapping("/user")
    private User update(@RequestBody User user) {
        LOG.info("update()");
        userService.edit(user);
        return user;
    }
}
