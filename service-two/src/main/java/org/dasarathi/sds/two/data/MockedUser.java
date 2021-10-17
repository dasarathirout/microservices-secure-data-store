package org.dasarathi.sds.two.data;

import org.dasarathi.sds.core.model.User;

import java.util.Random;

public class MockedUser {
    private static final int SIZE = 100;
    private static final Random CRAZY = new Random();

    public static int update() {
        for (int i = 0; i < SIZE; i++) {
            User mocked = new User();
            mocked.setId(CRAZY.nextInt(9999) + 1111);
            mocked.setName("User Mocked " + i);
            mocked.setDateOfBirth(CRAZY.nextInt(25) + 1999
                    + "-" + (CRAZY.nextInt(6) + 6) +
                    "-" + (CRAZY.nextInt(15) + 14));
            mocked.setSalary(CRAZY.nextDouble() + 9999);
            mocked.setCurrentAge(CRAZY.nextInt(50) + 20);
            MemoryDB.addContents(mocked);
        }
        User canSeeMe = new User(111, "Dr.Rout.", "11-11-1999", 9999.0, 30);
        MemoryDB.addContents(canSeeMe);
        return SIZE;
    }
}
