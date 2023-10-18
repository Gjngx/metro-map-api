package com.example.metromapapi.controllers;

import com.example.metromapapi.models.*;
import com.example.metromapapi.repositories.TrainLineRepository;
import com.example.metromapapi.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/trains")
public class TrainController {

    private final TrainRepository trainRepository;
    private final TrainLineRepository trainLineRepository;
    @Autowired
    public TrainController(TrainRepository trainRepository, TrainLineRepository trainLineRepository) {
        this.trainRepository = trainRepository;
        this.trainLineRepository = trainLineRepository;
    }
    @GetMapping("")
    List<Train> getAllTrains(){
        return trainRepository.findAll();
    }
    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id){
        Optional<Train> foundTrain = trainRepository.findById(id);
        if(foundTrain.isPresent()){
            Train train = foundTrain.get();
            String soTuyenTau = train.getTrainLine().getSoTuyenTau();
            ShowTrainDTO showTrainDTO = new ShowTrainDTO(
                    train.getId(),
                    train.getsTTGa(),
                    train.getTenGa(),
                    train.getThoiGian(),
                    train.getDiaChi(),
                    train.getLat(),
                    train.getLng(),
                    train.getMoTa(),
                    train.isTrangThai(),
                    soTuyenTau
            );
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Đã tìm thấy ga với id = " + id, showTrainDTO)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false", "không tìm thấy ga với id = " + id, "")
            );
        }
    }


    @GetMapping("/findname/{tenGa}")
    ResponseEntity<ResponseObject> findByTenGa(@PathVariable String tenGa) {
        List<Train> foundTrains = trainRepository.findBytenGa(tenGa);
        if (!foundTrains.isEmpty()) {
            List<ShowTrainDTO> showTrainDTOs = new ArrayList<>();
            for (Train train : foundTrains) {
                String soTuyenTau = train.getTrainLine().getSoTuyenTau();
                ShowTrainDTO showTrainDTO = new ShowTrainDTO(
                        train.getId(),
                        train.getsTTGa(),
                        train.getTenGa(),
                        train.getThoiGian(),
                        train.getDiaChi(),
                        train.getLat(),
                        train.getLng(),
                        train.getMoTa(),
                        train.isTrangThai(),
                        soTuyenTau
                );
                showTrainDTOs.add(showTrainDTO);
            }

            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Đã tìm thấy ga " + tenGa, showTrainDTOs)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false", "Không tìm thấy ga " + tenGa, "")
            );
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> insertTrain(@RequestBody TrainDTO trainDTO) {
        TrainLine trainLine = trainLineRepository.findById(trainDTO.getTrainLineId()).orElse(null);
        if (trainLine == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Không tìm thấy tuyến tàu với ID" + trainDTO.getTrainLineId(), "")
            );
        }
        Train train = new Train();
        train.setsTTGa(trainDTO.getsTTGa());
        train.setTenGa(trainDTO.getTenGa());
        train.setThoiGian(trainDTO.getThoiGian());
        train.setDiaChi(trainDTO.getDiaChi());
        train.setLat(trainDTO.getLat());
        train.setLng(trainDTO.getLng());
        train.setMoTa(trainDTO.getMoTa());
        train.setTrangThai(trainDTO.isTrangThai());
        train.setTrainLine(trainLine);
        Train savedTrain = trainRepository.save(train);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "Thêm ga thành công", savedTrain)
        );
    }

    @PutMapping("/{trainId}")
    public ResponseEntity<ResponseObject> updateTrain(@PathVariable Long trainId, @RequestBody TrainDTO updatedTrainDTO) {
        Optional<Train> trainOptional = trainRepository.findById(trainId);
        if (!trainOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Không tìm thấy Train với ID cung cấp", "")
            );
        }
        Train existingTrain = trainOptional.get();
        existingTrain.setsTTGa(updatedTrainDTO.getsTTGa());
        existingTrain.setTenGa(updatedTrainDTO.getTenGa());
        existingTrain.setThoiGian(updatedTrainDTO.getThoiGian());
        existingTrain.setDiaChi(updatedTrainDTO.getDiaChi());
        existingTrain.setLat(updatedTrainDTO.getLat());
        existingTrain.setLng(updatedTrainDTO.getLng());
        existingTrain.setMoTa(updatedTrainDTO.getMoTa());
        existingTrain.setTrangThai(updatedTrainDTO.isTrangThai());
        Long newTrainLineId = updatedTrainDTO.getTrainLineId();
        if (newTrainLineId != null) {
            Optional<TrainLine> trainLineOptional = trainLineRepository.findById(newTrainLineId);
            if (trainLineOptional.isPresent()) {
                TrainLine newTrainLine = trainLineOptional.get();
                existingTrain.setTrainLine(newTrainLine);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "Không tìm thấy tuyến tàu với ID = " + updatedTrainDTO.getTrainLineId(), "")
                );
            }
        }
        Train updatedTrain = trainRepository.save(existingTrain);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "Cập nhật thông tin Train thành công", updatedTrain)
        );
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteTrain(@PathVariable Long id){
        boolean exists = trainRepository.existsById(id);
        if(exists){
            trainRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok", "Xoá ga thành công", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Xoá ga thất bại", "")
        );
    }
}
