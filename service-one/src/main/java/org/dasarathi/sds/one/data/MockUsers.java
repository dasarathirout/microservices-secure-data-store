package org.dasarathi.sds.one.data;

import org.dasarathi.sds.one.model.User;

import java.util.ArrayList;
import java.util.List;

public class MockUsers {
    private MockUsers(){}
    private static final List<User> usersList = new ArrayList<>(16);

    static {
        for (int i = 0; i < 16; i++) {
            usersList.add(new User(100 + i, "NAME-" + i, "1987-06-" + (10 + i), 1000 + i * 1.5, 25 + i));
        }
    }

    public static List<User> lists() {
        return usersList;
    }
}
