package org.dasarathi.sds.two.data;

import org.dasarathi.sds.core.model.User;

import java.util.ArrayList;
import java.util.List;

public class MockedUser {
    private static final List<User> usersList = new ArrayList<>(16);

    static {
        for (int i = 0; i < 10; i++) {
            usersList.add(new User(200 + i, "NAME-" + i, "1987-06-" + (20 + i), 2000 + i * 1.5, 35 + i));
        }
    }

    private MockedUser() {
    }

    public static List<User> lists() {
        return usersList;
    }
}
