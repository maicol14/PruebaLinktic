package com.PruebaLinktic.repository;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.PruebaLinktic.model.*;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByCustomerId(Long customerId);
    List<Reservation> findByServiceId(Long serviceId);
    List<Reservation> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}