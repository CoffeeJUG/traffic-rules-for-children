package com.coffeejug.trafficrules.util;

import java.util.Random;

public class CodeGenerator {

    /**
     * Creates code from numeric (48-57), alphabetic uppercase 65-90) and lowercase (97-122) values
     */
    public static String generateCode(int length) {
        String password = "";
        for (int i = 0; i < length; i++) {
            Random random = new Random();
            int randInt = random.nextInt(62);
            randInt = (randInt < 10 ? randInt + 48 : (randInt < 36 ? randInt + 65 - 10 : randInt + 97 - 10 - 26));
            password += (char) randInt;
        }
        return password;
    }

    public static String generateCode() {
        return generateCode(10);
    }

}
