package com.vdev.dashboard.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vdev.dashboard.models.YoutubeStatistic;

public interface YoutubeService {
    YoutubeStatistic getChannelStatistic() throws JsonProcessingException;
    
}