package com.example.controller;

import com.example.service.freeboard.FreeboardInfoService;
import com.example.service.freeboard.FreeboardListService;
import com.example.service.freeboard.FreeboardWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class FreeboardController {

    @Autowired
    private FreeboardListService freeboardListService;

    @Autowired
    private FreeboardWriteService freeboardWriteService;

    @Autowired
    private FreeboardInfoService freeboardInfoService;

    private int returnIntValue(String stringToInt) {
        return Integer.parseInt(stringToInt);
    }

    @GetMapping("/freeboard")
    public String freeboard(@RequestParam(value = "pageNum", defaultValue = "1")String pageNum) {
        String page = freeboardListService.freeboardList(returnIntValue(pageNum));
        return page;
    }

    @PostMapping("/freeboardWriteRequest")
    public String freeboardWriteRequest(@RequestParam Map<String, String> paramMap) {
        String content = paramMap.get("content");
        String title = paramMap.get("title");
        String writer = paramMap.get("writer");

        freeboardWriteService.write(title, content, writer);

        return "redirect:/freeboard";
    }

    public String getPost(@RequestParam(value = "freeid")String freeid) {

        String page = freeboardInfoService.getFreeboardPost(freeid);
        return page;
    }
}
