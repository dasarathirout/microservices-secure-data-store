package org.dasarathi.sds.one.client;

import org.dasarathi.sds.core.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "searchUserFromServiceTwoByID", url = "http://localhost:8282/serviceTwo/api/v1")
public interface FeignClientTwoProxy {
    @RequestMapping(method = RequestMethod.GET,
            value = "/user/{userID}")
    User getUserByID(@PathVariable("userID") int userID);
}
