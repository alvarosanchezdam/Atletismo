package com.alvaro.Service;


import com.alvaro.Domain.Atleta;
import com.alvaro.Domain.Medalla;
import com.alvaro.Domain.tipoMedalla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alvaro.repository.AtletaRepository;
import com.alvaro.repository.MedallaRepository;

import java.time.LocalDate;

@Service
public class AtletismoService {

    @Autowired
    private AtletaRepository atletaRepository;

    @Autowired
    private MedallaRepository medallaRepository;


    public void testAtletismo() {

        Atleta a1 = new Atleta("Alvaro", "Sanchez", LocalDate.of(1995, 2, 26), "España");
        Atleta a2 = new Atleta("Sara", "Guallar", LocalDate.of(1993, 3, 4), "España");
        Atleta a3 = new Atleta("Pepe", "Petrov", LocalDate.of(1998, 2, 2), "Rusia");
        Atleta a4 = new Atleta("Fabio", "Gomes", LocalDate.of(1995, 2, 26), "Brasil");
        Atleta a5 = new Atleta("Jun", "Li", LocalDate.of(1992, 5, 6), "China");
        Atleta a6 = new Atleta("Juan", "Perez", LocalDate.of(1997, 5, 30), "España");
        Atleta a7 = new Atleta("Fernando", "", LocalDate.of(1990, 1, 3), "España");
        atletaRepository.save(a1);
        atletaRepository.save(a2);
        atletaRepository.save(a3);
        atletaRepository.save(a4);
        atletaRepository.save(a5);
        atletaRepository.save(a6);
        atletaRepository.save(a7);
        Medalla m1=new Medalla("Natación", tipoMedalla.ORO, "Juegos Olimpicos", a1);
        Medalla m2=new Medalla("100 metros", tipoMedalla.BRONCE, "Mundiales", a2);
        Medalla m3=new Medalla("Lanzamiento javalina", tipoMedalla.PLATA, "Europeos", a3);
        Medalla m4=new Medalla("Natacion", tipoMedalla.ORO, "Mundiales", a4);
        Medalla m5=new Medalla("Ciclismo en ruta", tipoMedalla.BRONCE, "Juegos Olimpicos", a5);
        Medalla m6=new Medalla("Baloncesto", tipoMedalla.ORO, "EuroBasket", a6);
        Medalla m7=new Medalla("100 metros", tipoMedalla.BRONCE, "Campeonato Nacional", a7);
        medallaRepository.save(m1);
        medallaRepository.save(m2);
        medallaRepository.save(m3);
        medallaRepository.save(m4);
        medallaRepository.save(m5);
        medallaRepository.save(m6);
        medallaRepository.save(m7);
        a1.getMedallas().add(m1);
        a2.getMedallas().add(m2);
        a3.getMedallas().add(m3);
        a4.getMedallas().add(m4);
        a5.getMedallas().add(m5);
        a6.getMedallas().add(m6);
        a7.getMedallas().add(m7);

    }
}