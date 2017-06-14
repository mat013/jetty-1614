package com.domain.rest;

import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PortfolioResource {

    @RequestMapping("/portfolio")
    public List<String> portfolios() {
        return Lists.newArrayList("abc");
    }
}