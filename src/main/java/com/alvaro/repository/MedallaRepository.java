package com.alvaro.repository;

import com.alvaro.Domain.Medalla;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created by DAM on 9/12/16.
 */
public interface MedallaRepository extends JpaRepository<Medalla, Long>  {
}
