package org.dasarathi.sds.two.controller;

import org.dasarathi.sds.two.controller.error.HttpTwoMessage;
import org.dasarathi.sds.core.model.User;
import org.dasarathi.sds.two.service.ServicesTwoProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/serviceTwo/api/v1")
public class ServiceTwoController {
    private static final Logger LOG = Logger.getLogger(ServiceTwoController.class.getName());

    @Autowired
    ServicesTwoProvider servicesTwoProvider;

    @GetMapping("/user/{userID}")
    private User getUser(@PathVariable("userID") int userID) {
        User findUser = new User();
        try {
            LOG.info("GET /serviceTwo/api/v1/user/{userID}");
        } catch (Exception ex) {
            LOG.severe("getUser(userID) failed with " + ex.getMessage());
            throw new HttpMessageNotReadableException("Unable to fetch UserTwo :" + userID, new HttpTwoMessage());
        }
        return findUser;
    }

    /* For Dev Test Only*/
    @DeleteMapping("/user/{userID}")
    private void deleteUser(@PathVariable("userID") int userID) {
        LOG.info("DELETE /serviceTwo/api/v1/user/{userID}");
        servicesTwoProvider.deleteByID(userID);
    }

}
