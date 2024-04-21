package Grupo6.VoluntariadoEmergencias.controllers;

import Grupo6.VoluntariadoEmergencias.entities.VoluntarioEntity;

import Grupo6.VoluntariadoEmergencias.services.VoluntarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoluntarioController {

    private final VoluntarioService voluntarioService;

    VoluntarioController(VoluntarioService voluntarioService){
        this.voluntarioService = voluntarioService;
    }
    // crear C
    @PostMapping("/voluntarios/save")
    @ResponseBody
    public VoluntarioEntity crearVoluntario(@RequestBody VoluntarioEntity voluntario){
        VoluntarioEntity voluntario1 = voluntarioService.crearVoluntario(voluntario);
        return voluntario1;
    }
    // get R
    @GetMapping("/voluntarios/getAll")
    @ResponseBody
    public List<VoluntarioEntity> getAllVoluntarios(){
        return voluntarioService.getAllVoluntarios();
    }
    //get by
    @GetMapping("/voluntarios/getById/{id}")
    @ResponseBody
    public List<VoluntarioEntity> getVoluntarioById(@PathVariable Long id){
        return voluntarioService.getVoluntarioById(id);
    }


    // actualizar U
    @PutMapping("/voluntarios/update/{id}")
    @ResponseBody
    public String updateVoluntario(@RequestBody VoluntarioEntity voluntario, @PathVariable Long id){
        String retorno = voluntarioService.updateVoluntario(voluntario,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/voluntarios/delete/{id}")
    public void deleteVoluntario(@PathVariable Long id){
        voluntarioService.deleteVoluntario(id);
    }

}