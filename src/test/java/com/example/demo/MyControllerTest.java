package com.example.demo;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import com.example.demo.controller.MyController;
import com.example.demo.service.ServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class MyControllerTest {

    @Mock
    ServiceImpl service;

    @InjectMocks
    MyController myController;

    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(myController).build();
    }

    @Test
    void showCalculationResultTest() throws Exception {
        when(service.calculate(anyInt(), anyInt())).thenReturn(30);
        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("resultView"))
                .andExpect(model().attribute("result", 30));
    }

}