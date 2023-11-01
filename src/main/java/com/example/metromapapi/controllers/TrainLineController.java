package com.example.metromapapi.controllers;

import com.example.metromapapi.models.ResponseObject;
import com.example.metromapapi.models.TrainLine;
import com.example.metromapapi.repositories.TrainLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/v1/trainlines")
public class TrainLineController {

    @Autowired
    private TrainLineRepository trainLinesRepository;
    @GetMapping("")
    List<TrainLine> getAllTrainLines(){
        return trainLinesRepository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id){
        Optional<TrainLine> foundTrainLine = trainLinesRepository.findById(id);
        if(foundTrainLine.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Tìm thấy tuyến tàu với id = "+ id , foundTrainLine)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false", "không tìm thấy tuyến tàu với id = " + id, "")
            );
        }
    }

    @GetMapping("/findByNameTrain/{soTuyenTau}")
    ResponseEntity<ResponseObject> findByNameTrain(@PathVariable String soTuyenTau) {
        List<TrainLine> foundTrainLines = trainLinesRepository.findBySoTuyenTauContaining(soTuyenTau);
        if (!foundTrainLines.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Tìm thấy tuyến tàu có số tuyến tàu chứa " + soTuyenTau, foundTrainLines)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false", "Không tìm thấy tuyến tàu có số tuyến tàu chứa " + soTuyenTau, "")
            );
        }
    }


    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertTrainLine(@RequestBody TrainLine newTrainLine){
        List <TrainLine> foundTrainLine = trainLinesRepository.findBysoTuyenTau(newTrainLine.getSoTuyenTau().trim());
        if(foundTrainLine.size() > 0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Số tuyến tàu đã tồn tại", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "Thêm tuyến tàu thành công", trainLinesRepository.save(newTrainLine))
        );
    }
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateTrainLine(@RequestBody TrainLine newTrainLine, @PathVariable Long id){
        TrainLine updateTrainLine = trainLinesRepository.findById(id)
                .map(trainLine -> {
                    trainLine.setSoTuyenTau(newTrainLine.getSoTuyenTau());
                    trainLine.setTenTuyenTau(newTrainLine.getTenTuyenTau());
                    trainLine.setDoDaiTuyenTau(newTrainLine.getDoDaiTuyenTau());
                    trainLine.setThoiGianBatDau(newTrainLine.getThoiGianBatDau());
                    trainLine.setThoiGianKetThuc(newTrainLine.getThoiGianKetThuc());
                    trainLine.setGiaVe(newTrainLine.getGiaVe());
                    trainLine.setKhuVuc(newTrainLine.getKhuVuc());
                    trainLine.setMoTa(newTrainLine.getMoTa());
                    trainLine.setTrangThai(newTrainLine.isTrangThai());
                    return trainLinesRepository.save(trainLine);
                }).orElseGet(()->{
                    newTrainLine.setId(id);
                    return trainLinesRepository.save(newTrainLine);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "Cập nhật tuyến tàu thành công", updateTrainLine)
        );
    }
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteTrainLine(@PathVariable Long id){
        boolean exists = trainLinesRepository.existsById(id);
        if(exists){
            trainLinesRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok", "Xoá tuyến tàu thành công", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Xoá tuyến tàu thất bại thất bại", "")
        );
    }
}
