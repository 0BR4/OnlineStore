package com.java.projects.online_store_backend.model.dao;

import com.java.projects.online_store_backend.model.LocalUser;
import com.java.projects.online_store_backend.model.VerificationToken;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface VerificationTokenDAO extends ListCrudRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token);

    void deleteByUser(LocalUser user);
}
