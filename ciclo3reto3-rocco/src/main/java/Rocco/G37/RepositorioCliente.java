/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rocco.G37;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rocco
 */

@Repository
public class RepositorioCliente {
    @Autowired
    private InterfaceCliente crud2;

    public List<Cliente> getAll(){
        return (List<Cliente>) crud2.findAll();
    }
    public Optional<Cliente> getCliente(int id){
        return crud2.findById(id);
    }

    public Cliente save(Cliente cliente){
        return crud2.save(cliente);
    }
    public void delete(Cliente cliente){
        crud2.delete(cliente);
    }
}
