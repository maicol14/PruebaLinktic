package com.PruebaLinktic.model;

import java.time.LocalDateTime;

public class ReservationRequest {

    private Long customerId;
    private Long serviceId;
    private LocalDateTime date;

    // Constructor
    public ReservationRequest() {
    }

    // Getters y Setters
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
