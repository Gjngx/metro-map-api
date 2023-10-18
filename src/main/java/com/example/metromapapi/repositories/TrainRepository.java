package com.example.metromapapi.repositories;

import com.example.metromapapi.models.Train;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrainRepository extends JpaRepository<Train, Long> {
    List<Train> findBytenGa(String tenGa);
    Optional<Train> findByTenGa(String tenGa);
}
