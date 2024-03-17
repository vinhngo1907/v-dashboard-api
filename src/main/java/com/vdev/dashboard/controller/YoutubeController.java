package com.vdev.dashboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vdev.dashboard.models.YoutubeStatistic;
import com.vdev.dashboard.services.YoutubeService;

@RestController
@RequestMapping("/youtube/")
public class YoutubeController {
    private final Logger logger = LoggerFactory.getLogger(YoutubeController.class);

    @Autowired
    YoutubeService youtubeService;

    @GetMapping
    public YoutubeStatistic getYoutubeStatistic() {
        logger.info("Getting youtube statistic...");
        YoutubeStatistic res = null;
        try {
            res = youtubeService.getChannelStatistic();
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("Error when getting youtube statistics", e);
        }

        return res;
    }
}
