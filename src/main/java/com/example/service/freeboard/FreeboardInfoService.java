package com.example.service.freeboard;

import com.example.model.Freeboard;
import com.example.repository.FreeboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class FreeboardInfoService {

    @Autowired
    private FreeboardRepository freeboardRepository;

    @Autowired
    private HttpSession httpSession;

    public String getFreeboardPost(String stringFreeId){
        Long freeId = Long.parseLong(stringFreeId);
        Freeboard freeboard = freeboardRepository.findByFreeId(freeId);
        if (freeboard == null) {
            return "freeboard";
        }
        httpSession.setAttribute("freeboard", freeboard);
        return "freeBoardInfo";
    }
}
