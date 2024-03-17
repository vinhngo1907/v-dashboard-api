package com.vdev.dashboard.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class YoutubeStatistic {
    private String viewCount;
    private String videoCount;
    private String hiddenSubcriberCount;
    private String subScriberCount;
}
