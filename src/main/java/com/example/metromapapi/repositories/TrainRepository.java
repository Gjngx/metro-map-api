package com.example.metromapapi.repositories;

import com.example.metromapapi.models.Train;
import com.example.metromapapi.models.TrainLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainRepository extends JpaRepository<Train, Long> {
    List<Train> findBytenGa(String tenGa);
    List<Train> findBytrainLine(TrainLine trainLine);
}
