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
public class ServiciosCabin {
    @Autowired
    private RepositorioCabin metodosCrud;

    public List<Cabin> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Cabin> getCabin(int cabinId) {
        return metodosCrud.getCabin(cabinId);
    }

    public Cabin save(Cabin cabin){
        if(cabin.getId()==null){
            return metodosCrud.save(cabin);
        }else{
            Optional<Cabin> e=metodosCrud.getCabin(cabin.getId());
            if(e.isEmpty()){
                return metodosCrud.save(cabin);
            }else{
                return cabin;
            }
        }
    }
    
}
