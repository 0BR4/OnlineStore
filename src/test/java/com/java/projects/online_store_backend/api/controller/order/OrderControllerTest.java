package com.java.projects.online_store_backend.api.controller.order;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.projects.online_store_backend.model.OnlineOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @WithUserDetails("UserA")
    public void testUserAAuthenticatedOrderList() throws Exception {
        mvc.perform(get("/order")).andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(result -> {
                   String json = result.getResponse().getContentAsString();
                    List<OnlineOrder> orders = new ObjectMapper().readValue(json, new TypeReference<List<OnlineOrder>>() {});
                    for (OnlineOrder order : orders) {
                        Assertions.assertEquals("UserA", order.getUser().getUsername(), "Order list should only be orders belonging to the user.");
                    }
                });
    }

    @Test
    public void testUnauthenticatedOrderList() throws Exception {
        mvc.perform(get("/order")).andExpect(status().is(HttpStatus.FORBIDDEN.value()));
    }
}
