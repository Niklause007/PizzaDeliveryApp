package com.example.PizzaDelivery.service;

import com.example.PizzaDelivery.exception.PaymentFailedException;
import com.example.PizzaDelivery.model.Customer;
import com.example.PizzaDelivery.model.Order;
import com.example.PizzaDelivery.model.Payment;
import com.example.PizzaDelivery.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired private PaymentRepository paymentRepository;
    @Autowired private OrderService orderService;
    @Autowired private CustomerService customerService;

    public Payment updatePaymentStatus(Long orderId) throws PaymentFailedException {
        Order order = orderService.getOrderByOrderId(orderId);
        Customer customer = order.getCustomer();
        Payment payment = new Payment();
        payment.setStatus(true);
        order.setPayment(payment);
        List<Payment> paymentList = customer.getPaymentList();
        paymentList.add(payment);
        customer.setPaymentList(paymentList);
        payment = paymentRepository.save(payment);
        orderService.updateOrder(order);
        customerService.updateCustomer(customer);
        return payment;
    }

    public boolean getPaymentStatus(Long orderId) {
        Order order = orderService.getOrderByOrderId(orderId);
        Payment payment = order.getPayment();
        if(payment == null){
            return false;
        }
        return payment.getStatus();
    }
}
