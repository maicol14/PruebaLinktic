package com.PruebaLinktic.service;

import java.lang.module.ResolutionException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.AotInitializerNotFoundException;
import org.springframework.stereotype.Service;

import com.PruebaLinktic.model.Customer;
import com.PruebaLinktic.model.Reservation;
import com.PruebaLinktic.repository.CustomerRepository;
import com.PruebaLinktic.repository.ReservationRepository;
import com.PruebaLinktic.repository.ServiceRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ServiceRepository serviceRepository;

    public Reservation createReservation(Long customerId, Long serviceId, LocalDateTime date) {
        // Buscar el cliente por ID, si no se encuentra, devolver null
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isEmpty()) {
            return null;  // No se encontró el cliente
        }
        Customer customer = customerOptional.get();

        // Buscar el servicio por ID, si no se encuentra, devolver null
        Optional<Service> serviceOptional = Optional.empty(); // `Service` es de tu modelo
        if (serviceOptional.isEmpty()) {
            return null;  // No se encontró el servicio
        }
        Service service = serviceOptional.get(); // `Service` es de tu modelo
        // Crear la reserva
        Reservation reservation = new Reservation();
        reservation.setCustomer(customer);
        reservation.setService(service);
        reservation.setDate(date);

        // Guardar la reserva en el repositorio
        return reservationRepository.save(reservation);
    }
    
    public Reservation updateReservation(Long id, LocalDateTime newDate) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new AotInitializerNotFoundException(null, "Reservation not found"));
        reservation.setDate(newDate);
        return reservationRepository.save(reservation);
    }

    public void cancelReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new AotInitializerNotFoundException(null, "Reservation not found"));
        reservationRepository.delete(reservation);
    }

    public List<Reservation> getReservations(Long customerId, Long serviceId, LocalDateTime startDate, LocalDateTime endDate) {
        if (customerId != null) {
            return reservationRepository.findByCustomerId(customerId);
        } else if (serviceId != null) {
            return reservationRepository.findByServiceId(serviceId);
        } else if (startDate != null && endDate != null) {
            return reservationRepository.findByDateBetween(startDate, endDate);
        }
        return reservationRepository.findAll();
    }

}

