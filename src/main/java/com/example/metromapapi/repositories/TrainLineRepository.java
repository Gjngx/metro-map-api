package com.example.metromapapi.repositories;

import com.example.metromapapi.models.TrainLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainLineRepository extends JpaRepository<TrainLine, Long> {
    List<TrainLine> findBysoTuyenTau(String soTuyenTau);
    List<TrainLine> findBySoTuyenTauContaining(String soTuyenTau);
}
