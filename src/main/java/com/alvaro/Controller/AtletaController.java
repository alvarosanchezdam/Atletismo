package com.alvaro.Controller;


import com.alvaro.Domain.Atleta;
import com.alvaro.Domain.tipoMedalla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.alvaro.repository.AtletaRepository;
import com.alvaro.repository.MedallaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@RestController
@RequestMapping("/atletas")
public class AtletaController {

    @Autowired
    private AtletaRepository atletaRepository;
    @Autowired
    private MedallaRepository medallaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atleta createPlayer(@RequestBody Atleta atleta) {
        return atletaRepository.save(atleta);
    }

    @PutMapping
    public Atleta updatePlayer(@RequestBody Atleta atleta) {
        return atletaRepository.save(atleta);
    }

    @GetMapping
    public List<Atleta> findAll() {
        return atletaRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteAtleta(@PathVariable Long id){
        atletaRepository.delete(id);
    }

    @GetMapping("/{id}")
    public Atleta findById(@PathVariable Long id) {
        Atleta atleta = atletaRepository.findOne(id);
        return atleta;
    }
    @GetMapping("/byNacionalidad/{nacionalidad}")
    public List<Atleta> findByNacionalidad(@PathVariable String nacionalidad) {
        List<Atleta> atletaList=atletaRepository.findByNacionalidad(nacionalidad);
        return atletaList;
    }
    @GetMapping("/byFecha/{fecha}")
    public List<Atleta> findByFechaNacimientoBefore(@PathVariable LocalDate fecha) {
        List<Atleta> atletaList=atletaRepository.findByFechaNacimientoBefore(fecha);
        return atletaList;
    }
    @GetMapping("/GroupByNacionalidad")
    public Map<String, List<Atleta>> getAtletasGroupByNacionalidad() {
        return atletaRepository
                .findAll()
                .parallelStream()
                .collect(groupingBy(Atleta::getNacionalidad));
    }
    @GetMapping("/GroupByMedalType")
    public Map<tipoMedalla, List<Atleta>> getAthleteGroupByMedalType(){
        //Buscas todos los atletas
        //Los preparas para el procesamiento en paralelo
        //Con la clase collect agrupas los atletas mediante un lambda
        //Al lambda le pasas un atleta
        //entonces con estas dos lineas en la clase Athlete :
        // "@OneToMany(mappedBy = "athlete")" que indica la relación 1 medalla para muchos, y dice que esta mapeado por el atributo "athlete" de la clase Medal y
        //"private List<Medal> medals;"  atributo que guarda todas las medallas de un athleta;
        //Obtenemos las medallas que tiene este athleta, las procesamos y si en el "anyMatch" (En el cual tenemos un lambda de medalla, donde le pasamos una medalla
        // y la compara con el tipo GOLD, SILVER, BRONCE o NONE(tipo que creamos para que si un atleta no tiene ninguna medalla, no dé un error
        // al crear el JSON) y devuelve true o false) devuelve true, se guardara en la agrupación correspondiente (en este if sería la de GOLD)

        return atletaRepository
                .findAll()
                .parallelStream()
                .collect(groupingBy(athlete -> {
                    if(athlete.getMedallas().stream().anyMatch(medal -> medal.getTipoMedalla() == tipoMedalla.ORO)){
                        return tipoMedalla.ORO;
                    }else if(athlete.getMedallas().stream().anyMatch(medal -> medal.getTipoMedalla() == tipoMedalla.PLATA)){
                        return tipoMedalla.PLATA;
                    }else if(athlete.getMedallas().stream().anyMatch(medal -> medal.getTipoMedalla() == tipoMedalla.BRONCE)){
                        return tipoMedalla.BRONCE.BRONCE;
                    }else {
                        return tipoMedalla.NONE;
                    }
                }));
    }
}