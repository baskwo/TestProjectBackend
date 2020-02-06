package ca.baskwo.service.order;

import ca.baskwo.service.order.entity.Order;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RequestScoped
public class OrderService implements IOrderService {
    private Client client;

    private WebTarget baseTarget;

    @PostConstruct
    public void init() {
        client = ClientBuilder.newBuilder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();

        baseTarget = client.target("http://host.docker.internal:9081/api/order");
    }

    @PreDestroy
    public void tearDown() {
        client.close();
    }

    @Override
    public List<Order> getOrders() {
        return baseTarget.request()
                .accept(MediaType.APPLICATION_JSON)
                .get(new GenericType<>() {
                });
    }
}
