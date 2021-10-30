/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rocco.G37;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rocco
 */

/*
*Anotaciones de entidad y tabla
*/
@Entity
@Table(name = "cabin")

/** serializable:especifica que todo el estado de un objeto instanciado pueda ser escrito
o enviado en la red como una trama de bytes*/

public class Cabin implements Serializable {
    
    /**generador de valores */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer rooms;
    private String description;
    
    /**inicio ManyToOne y OneToMany*/
    /**muchos a uno: nos permite mapear una entidad con otra*/
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("cabins")
    private Categoria category;
    
    /*
    *uno a muchos: se caracteriza por Entidad donde tenemos un objeto principal y colección de
    objetos de otra Entidad relacionados directamente
    */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "cabin")
    @JsonIgnoreProperties({"cabin", "client"})
    private List<Mensaje> messages;

    /*
    * uno a muchos
    */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "cabin")
    @JsonIgnoreProperties({"cabin", "client"})
    private List<Reservaciones> reservations;
     /**fin ManyToOne y OneToMany*/
    
    /** inicio de Getter an setter:permiten acceder al valor de un atributo se denominan "getters" (obtener) y los que fijan el valor 
    de un atributo se denominan "setters" (fijar).*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public List<Mensaje> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    public List<Reservaciones> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservaciones> reservations) {
        this.reservations = reservations;
    }
    /**fin de Getter an setter*/
}
