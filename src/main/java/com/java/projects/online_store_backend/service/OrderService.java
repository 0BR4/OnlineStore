package com.java.projects.online_store_backend.service;

import com.java.projects.online_store_backend.model.LocalUser;
import com.java.projects.online_store_backend.model.OnlineOrder;
import com.java.projects.online_store_backend.model.dao.OnlineOrderDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OnlineOrderDAO onlineOrderDAO;

    public OrderService(OnlineOrderDAO onlineOrderDAO) {
        this.onlineOrderDAO = onlineOrderDAO;
    }

    public List<OnlineOrder> getOrders(LocalUser user){
        return onlineOrderDAO.findByUser(user);
    }

}
