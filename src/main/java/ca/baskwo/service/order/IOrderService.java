package ca.baskwo.service.order;

import ca.baskwo.service.order.entity.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getOrders();
}
