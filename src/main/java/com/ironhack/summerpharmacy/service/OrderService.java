package com.ironhack.summerpharmacy.service;

import com.ironhack.summerpharmacy.dto.OrderDto;
import com.ironhack.summerpharmacy.mapper.OrderMapper;
import com.ironhack.summerpharmacy.model.Medication;
import com.ironhack.summerpharmacy.model.Order;
import com.ironhack.summerpharmacy.repository.MedicationRepository;
import com.ironhack.summerpharmacy.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final MedicationRepository medicationRepository;
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    @Transactional
    public OrderDto createOrder(OrderDto orderDto) {

        List<Medication> medications = orderDto.getMedications().stream()
                .map(medication -> medicationRepository.findById(medication.getId())
                        .orElseThrow(() -> new IllegalArgumentException("Medication with id " + medication.getId() + " does not exist")))
                .toList();
        Order order = orderMapper.toEntity(orderDto);
        order.setMedications(medications);

        orderRepository.save(order);
        return orderMapper.toDto(order);
    }

    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toDto)
                .toList();
    }
}
