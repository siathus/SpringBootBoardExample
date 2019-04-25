package com.example.service.freeboard;

import com.example.model.Freeboard;
import com.example.pageMaker.PageMaker;
import com.example.repository.FreeboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class FreeboardListService {

    @Autowired
    private FreeboardRepository freeboardRepository;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private PageMakerService pageMakerService;

    public String freeboardList(int pageNum) {

        PageMaker pageMaker = pageMakerService.generatePageMaker(pageNum, 10, freeboardRepository);

        PageRequest pageRequest = PageRequest.of(pageNum-1, 10, Sort.Direction.DESC, "freeid");
        Page<Freeboard> freeboardPage = freeboardRepository.findAll(pageRequest);

        if (freeboardPage.getSize() == 0) {
            new ArrayList<Freeboard>();
            httpSession.setAttribute("boardList", new ArrayList<Freeboard>());
            httpSession.setAttribute("pageMaker", pageMaker);
            return "freeboard";
        }

        List<Freeboard> freeboardList = freeboardPage.getContent();

        httpSession.setAttribute("boardList", freeboardList);
        httpSession.setAttribute("pageMaker", pageMaker);

        return "freeboard";
    }
}
