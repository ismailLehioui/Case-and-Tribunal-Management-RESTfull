package com.enicar.soc.services;

import com.enicar.soc.entities.Court;
import com.enicar.soc.exceptions.NotFoundException;
import com.enicar.soc.repositories.CourtRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourtService {
    CourtRepository courtRepository;

    public Court getCourtById(Long id){
        Court court = courtRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Court not found !!")
        );
        return court;
    }

    public List<Court> getAllCourts(){
        return courtRepository.findAll();
    }

    public Court deleteCourt(Long  id){
        Court court = courtRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("court not fount !!")
        );
        courtRepository.deleteById(id);
        return court;

    }
}
