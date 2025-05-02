package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class UserHouse extends Keys {
    // Создание логера
    private static final Logger logger = LogManager.getLogger(UserHouse.class);
    private static final String hashpassword = "0f27dda9ae120790a018399a2ec345b06844cbe59a0dc5ba145fe41020ddbd9a";
    private String password;

    private boolean access;

    public void House(String password) {
        if(checkPassword(password, hashpassword)){
            logger.info("Password House successful");
            System.out.println("Password House successful");
            access = true;
        }
    }


}
