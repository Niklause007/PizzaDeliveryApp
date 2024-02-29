package com.example.PizzaDelivery.service;

import com.example.PizzaDelivery.exception.CartNotFoundException;
import com.example.PizzaDelivery.model.Cart;
import com.example.PizzaDelivery.model.CartItem;
import com.example.PizzaDelivery.model.Customer;
import com.example.PizzaDelivery.model.Order;
import com.example.PizzaDelivery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired private OrderRepository orderRepository;
    @Autowired private CartService cartService;
    @Autowired private CustomerService customerService;
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order createNewOrder(Integer cartId) throws CartNotFoundException {
        Cart cart;
        try {
             cart = cartService.getCartByCartId(cartId);
        }catch (Exception e){
            throw new CartNotFoundException("Cart not Found!");
        }
        List<CartItem> cartItems = cart.getPizzas();
        List<CartItem> cartItems1 = new ArrayList<>(cartItems);
        Order order=new Order();
        order.setOrderedItems(cartItems1);
        order.setPayment(null);
        Customer customer = customerService.findCustomerByCart(cart);
        List<Order> orders = customer.getOrders();
        orders.add(order);
        customer.setOrders(orders);
        customer.setCart(null);
        order.setCustomer(customer);
        Order order1 = orderRepository.save(order);
        cartService.deleteCart(cart);
        customerService.updateCustomer(customer);
        return order1;
    }

    public Double getTotalPrice(Long orderId) {
        Order order = orderRepository.getReferenceById(orderId.intValue());
        double price = 0.0d;
        for(CartItem ci: order.getOrderedItems()){
            double cost = ci.getPizza().getPrice();
            int quantity = ci.getQuantity();
            price += (cost*quantity);
        }
        return price;
    }

    public Order getOrderByOrderId(Long orderId) {
        return orderRepository.findOrderByOrderId(orderId);
    }

    public Order updateOrder(Order order){
        return orderRepository.save(order);
    }
}
