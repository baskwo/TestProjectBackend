package ca.baskwo.service.client;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.concurrent.TimeUnit;

@RequestScoped
public class ClientService implements IClientService {
    private Client client;

    private WebTarget baseTarget;

    @PostConstruct
    public void init() {
        client = ClientBuilder.newBuilder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();

        baseTarget = client.target("http://host.docker.internal:9081/api/client");
    }
}
