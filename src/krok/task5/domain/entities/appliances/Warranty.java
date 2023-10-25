package krok.task5.domain.entities.appliances;

import krok.task5.domain.enums.WarrantyStatus;
import krok.common.exceptions.ValidationException;
import java.time.LocalDate;

public class Warranty {
    private WarrantyStatus status;
    private LocalDate expirationDate;
    public Warranty(WarrantyStatus status, LocalDate expirationDate) {
        this.status = status;
        setExpirationDate(expirationDate);
    }
    public WarrantyStatus getStatus() {
        return status;
    }
    public void setStatus(WarrantyStatus status) {
        this.status = status;
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(LocalDate expirationDate) {
        if (expirationDate.isBefore(LocalDate.now())) {
            throw new ValidationException("Expiration date cannot be in the past");
        }
        this.expirationDate = expirationDate;
    }
    @Override
    public String toString() {
        return String.format("Status: %s, Expiration: %s", status, expirationDate);
    }
}