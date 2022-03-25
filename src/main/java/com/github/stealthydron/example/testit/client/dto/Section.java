package com.github.stealthydron.example.testit.client.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Section {

    private String id;
    private String name;
    private String projectId;
    private String parentId;
}