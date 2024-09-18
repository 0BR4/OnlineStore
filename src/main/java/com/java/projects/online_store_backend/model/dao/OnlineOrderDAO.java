package com.java.projects.online_store_backend.model.dao;

import com.java.projects.online_store_backend.model.LocalUser;
import com.java.projects.online_store_backend.model.OnlineOrder;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface OnlineOrderDAO extends ListCrudRepository<OnlineOrder, Long> {

    List<OnlineOrder> findByUser(LocalUser user);
}
