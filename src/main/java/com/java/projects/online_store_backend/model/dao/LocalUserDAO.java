package com.java.projects.online_store_backend.model.dao;

import com.java.projects.online_store_backend.model.LocalUser;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface LocalUserDAO extends ListCrudRepository<LocalUser, Long> {


    Optional<LocalUser> findByUsernameIgnoreCase(String username);

    Optional<LocalUser> findByEmailIgnoreCase(String email);
}
