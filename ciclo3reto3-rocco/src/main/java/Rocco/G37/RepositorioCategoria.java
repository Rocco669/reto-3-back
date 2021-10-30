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
public class RepositorioCategoria {
    @Autowired
    private InterfaceCategoria crud1;
    public List<Categoria> getAll(){
        return (List<Categoria>) crud1.findAll();
    }
    public Optional<Categoria> getCategoria(int id){
        return crud1.findById(id);
    }

    public Categoria save(Categoria Categoria){
        return crud1.save(Categoria);
    }
    public void delete(Categoria Categoria){
       crud1.delete(Categoria);
    }
}
