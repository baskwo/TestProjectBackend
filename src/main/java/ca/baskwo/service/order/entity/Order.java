package ca.baskwo.service.order.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private int id;

    private LocalDateTime creationTime;

    private List<Merchandise> merchandises;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public List<Merchandise> getMerchandises() {
        return merchandises;
    }

    public void setMerchandises(List<Merchandise> merchandises) {
        this.merchandises = merchandises;
    }
}
