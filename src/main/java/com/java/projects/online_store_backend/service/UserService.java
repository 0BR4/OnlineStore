package com.java.projects.online_store_backend.service;

import com.java.projects.online_store_backend.api.model.RegistrationBody;
import com.java.projects.online_store_backend.exception.UserAlreadyExistsException;
import com.java.projects.online_store_backend.model.LocalUser;
import com.java.projects.online_store_backend.model.dao.LocalUserDAO;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private LocalUserDAO localUserDAO;

    public UserService(LocalUserDAO localUserDAO) {
        this.localUserDAO = localUserDAO;
    }

    public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {
        if(localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
                || localUserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()){
            throw new UserAlreadyExistsException();
        }

        LocalUser user = new LocalUser();
        user.setUsername(registrationBody.getUsername());
        user.setEmail(registrationBody.getEmail());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        //TODO: Enkriptuj sifre!!
        user.setPassword(registrationBody.getPassword());

        return localUserDAO.save(user);
    }

}
