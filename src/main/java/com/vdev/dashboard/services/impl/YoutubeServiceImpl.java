package com.vdev.dashboard.services.impl;

import javax.annotation.PostConstruct;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vdev.dashboard.configuration.ApplicationConfig;
import com.vdev.dashboard.models.YoutubeStatistic;
import com.vdev.dashboard.services.YoutubeService;

public class YoutubeServiceImpl implements YoutubeService {
    private final Logger logger = LoggerFactory.getLogger(YoutubeService.class);
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ApplicationConfig applicationConfig;

    @PostConstruct
    public void initialize() {
        logger.info("initialize service with config: {}", applicationConfig);
    }

    public YoutubeStatistic getChannelStatistic() throws JsonProcessingException {
        String requestUrl = this.applicationConfig.getRequestUrl() + "channels";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(requestUrl)
                .queryParam("part", "statistics")
                .queryParam("part", applicationConfig.getSecretApi())
                .queryParam("id", applicationConfig.getChannel());

        pper mapper = new ObjectMapper();

        var response = mapper.writeValueAsString(restTemplate.getForEntity(
                builder.toUriString(), Object.class).getBody());

        YoutubeStatistic res = null;

        if (response != null) {
            var statistc = new JSONObject(response.toString())
                    .getJSONArray("items")
                    .getJSONObject(0).getJSONObject("stistics").toString();
            res = mapper.readValue(statistc, YoutubeStatistic.class);
        }

        return res;
    }
}
