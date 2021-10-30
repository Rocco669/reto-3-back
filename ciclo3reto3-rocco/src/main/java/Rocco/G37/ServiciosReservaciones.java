/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rocco.G37;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rocco
 */

@Service
public class ServiciosReservaciones {
    @Autowired
    private RepositorioReservaciones metodosCrud;

    public List<Reservaciones> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Reservaciones> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    public Reservaciones save(Reservaciones reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservaciones> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }
}
