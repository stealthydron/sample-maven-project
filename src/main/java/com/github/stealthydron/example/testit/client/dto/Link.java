package com.github.stealthydron.example.testit.client.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Link {

    private String title;
    private String url;
    private String description;
    private String type;
    private Boolean hasInfo;
}