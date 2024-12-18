package com.enicar.soc.services;

import com.enicar.soc.entities.Court;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICourtService {

    Court getById(Long id);

    List<Court> getAllCourts();

    Court addCourt(Court court);

    Court deletecourt(Long id);

}
