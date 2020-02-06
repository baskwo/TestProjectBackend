package ca.baskwo.controller;

import ca.baskwo.service.order.entity.Order;
import ca.baskwo.service.order.IOrderService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class IndexController {
    private IOrderService orderService;

    @Inject
    public IndexController(IOrderService orderService) {
        this.orderService = orderService;
    }

    private List<Order> orders;

    @PostConstruct
    public void init() {
        orders = orderService.getOrders();
    }

    public List<Order> getOrders() {
        return orders;
    }
}
