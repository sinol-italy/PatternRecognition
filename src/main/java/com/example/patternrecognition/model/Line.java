package com.example.patternrecognition.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Line {
    private Set<Point> points;
}
