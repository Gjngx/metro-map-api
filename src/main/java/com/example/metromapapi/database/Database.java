package com.example.metromapapi.database;

import com.example.metromapapi.models.Train;
import com.example.metromapapi.models.TrainLine;
import com.example.metromapapi.repositories.TrainLineRepository;
import com.example.metromapapi.repositories.TrainRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Time;

@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase (TrainLineRepository trainLinesRepository, TrainRepository trainRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                TrainLine trainLineA = new TrainLine("Tuyến số Metro 2A", "Cát Linh - Hà Đông", 13.1, Time.valueOf("05:00:00"), Time.valueOf("23:00:00"), 300000, "Hà nội", "Tuyến thuộc khu vực Hà Nội", true);
//                TrainLine trainLineB = new TrainLine("Tuyến số Metro 3", "Ga Nhổn - Ga Hà Nội", 12.5, Time.valueOf("05:00:00"), Time.valueOf("23:00:00"), 300000, "Hà nội", "Tuyến thuộc khu vực Hà Nội", false);
//                logger.info ("insert data: "+ trainLinesRepository.save(trainLineA));
//                logger.info ("insert data: "+ trainLinesRepository.save(trainLineB));
//                Train trainA = new Train(trainLineA, 1, "Ga cát linh", Time.valueOf("00:10:00"), "192 P. Hào Nam, Chợ Dừa, Đống Đa, Hà Nội, Việt Nam",21.0283377, 105.8247348, "Chưa có", true);
//                Train trainB = new Train(trainLineB, 1, "Ga Nhổn", Time.valueOf("00:10:00"), "P.Tu Hoàng, Nhổn, Từ Liêm, Hà Nội, Việt Nam",21.0537501,105.7309665, "Chưa có", false);
//                logger.info ("insert data: "+ trainRepository.save(trainA));
//                logger.info ("insert data: "+ trainRepository.save(trainB));
            }
        };
    }
}
