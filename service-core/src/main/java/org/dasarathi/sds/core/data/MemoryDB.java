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
        return hashSet.stream().
                filter(item -> item.getId() == ID).
                collect(Collectors.toList()).
                get(0);
    }

    public static Set<User> getAllContents() {
        return hashSet;
    }
}
