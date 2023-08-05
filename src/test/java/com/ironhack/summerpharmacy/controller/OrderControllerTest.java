package com.ironhack.summerpharmacy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.summerpharmacy.dto.MedicationDto;
import com.ironhack.summerpharmacy.dto.OrderDto;
import com.ironhack.summerpharmacy.model.Medication;
import com.ironhack.summerpharmacy.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private OrderService orderService;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetAllOrders() throws Exception {
        var medicationDto = new MedicationDto();
        medicationDto.setId(1);
        medicationDto.setName("Medication 1");
        var medicationDto2 = new MedicationDto();
        medicationDto.setName("Medication 2");
        medicationDto.setId(2);
        OrderDto orderDto1 = new OrderDto(UUID.randomUUID(), List.of(medicationDto), "customer1", BigDecimal.TEN, ZonedDateTime.now());
        OrderDto orderDto2 = new OrderDto(UUID.randomUUID(), List.of(medicationDto, medicationDto2), "customer1", new BigDecimal("42.00"), ZonedDateTime.now());

        List<OrderDto> orderDtos = Arrays.asList(orderDto1, orderDto2);

        when(orderService.getAllOrders()).thenReturn(orderDtos);

        mockMvc.perform(get("/api/v1/orders"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(orderDtos)));
    }

    @Test
    public void testCreateOrder() throws Exception {
        var medicationDto = new MedicationDto();
        medicationDto.setId(1);

        var medicationSaved = new Medication();
        medicationSaved.setId(1);
        OrderDto orderDto = new OrderDto(null, List.of(medicationDto), "customer1", BigDecimal.TEN, null);
        OrderDto savedOrderDto = new OrderDto(UUID.randomUUID(), List.of(medicationDto), "customer1", BigDecimal.TEN, ZonedDateTime.now());

        when(orderService.createOrder(any())).thenReturn(savedOrderDto);

        mockMvc.perform(post("/api/v1/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.totalPrice").value(BigDecimal.TEN)) //https://github.com/json-path/JsonPath
                .andExpect(content().json(objectMapper.writeValueAsString(savedOrderDto)));
    }
}
