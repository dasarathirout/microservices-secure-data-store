package org.dasarathi.sds.core.data;

import org.dasarathi.sds.core.model.User;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MemoryDB {
    private static final Logger LOG = Logger.getLogger(MemoryDB.class.getName());
    private static final HashSet<User> hashSet = new LinkedHashSet<User>();

    private MemoryDB() {
    }

    public static boolean addContents(User model) {
        return hashSet.add(model);
    }

    public static User searchContents(int ID) {
        User result = new User(0, "UNDEFINED", "NA", 0.0, 0);
        for (User element : hashSet) {
            if (element.getId() == ID) {
                return element;
            }
        }
        return result;
    }

    public static Set<User> getAllContents() {
        return hashSet;
    }
}
