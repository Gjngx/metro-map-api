package com.example.metromapapi.repositories;

import com.example.metromapapi.models.TrainLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrainLineRepository extends JpaRepository<TrainLine, Long> {
    List<TrainLine> findBysoTuyenTau(String soTuyenTau);
    Optional<TrainLine> findBySoTuyenTau(String soTuyenTau);
}
