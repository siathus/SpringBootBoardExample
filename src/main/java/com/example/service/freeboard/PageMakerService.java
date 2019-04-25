package com.example.service.freeboard;

import com.example.model.Freeboard;
import com.example.pageMaker.PageMaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PageMakerService {

    public PageMaker generatePageMaker(int pageNum, int contentNum, JpaRepository<Freeboard, Long> repository) {
        PageMaker pageMaker = new PageMaker();

        int totalCount = (int) repository.count();
        pageMaker.setTotalCount(totalCount);
        pageMaker.setPageNum(pageNum - 1);
        pageMaker.setContentNum(contentNum);
        pageMaker.setCurrentBlock(pageNum);
        pageMaker.setLastBlock(pageMaker.getTotalCount());
        pageMaker.prevNext(pageNum);
        pageMaker.setStartPage(pageMaker.getCurrentBlock());
        pageMaker.setEndPage(pageMaker.getLastBlock(), pageMaker.getCurrentBlock());

        return pageMaker;
    }
}
