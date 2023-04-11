package com.movie.page.example.moviepage.serviceImpl;

import com.movie.page.example.moviepage.dto.HallDTO;
import com.movie.page.example.moviepage.entities.Hall;
import com.movie.page.example.moviepage.repositories.HallRepository;
import com.movie.page.example.moviepage.service.HallService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HallServiceImpl implements HallService {
    private final HallRepository hallRepository;

    public HallServiceImpl(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    @Override
    public Hall createNewHall(HallDTO hallDTO) {
        Hall hall = new Hall();
        hall.setHallId(hallDTO.getHallId());
        hall.setNumberOfSeat(hallDTO.getNumberOfSeat());
        return hallRepository.save(hall);
    }

    @Override
    public List<Hall> getAllHalls() {
        return hallRepository.findAll();
    }

    @Override
    public Optional<Hall> getHallById(Long hallId) {
        return hallRepository.findById(hallId);
    }

    @Override
    public Hall updateHall(HallDTO hallDTO) {
        Optional<Hall> hallControl = hallRepository.findById(hallDTO.getHallId());
        Hall changedHall;
        if (hallControl.isPresent()) {
            changedHall = hallControl.get();
            changedHall.setNumberOfSeat(hallDTO.getNumberOfSeat());
            return hallRepository.save(changedHall);
        }
        return null;
    }

    @Override
    public String deleteHall(Long hallId) {
        Optional<Hall> hall = hallRepository.findById(hallId);
        if (hall.isPresent()) {
            hallRepository.deleteById(hallId);
            return "Salon Silme İşlemi Başarılı...";
        }
        return "Böyle Bir Salon Bulunamadı!";
    }
}
