package com.example.patternrecognition.service;

import com.example.patternrecognition.model.Line;
import com.example.patternrecognition.model.Point;

import java.util.List;

public interface IPointService {

    void addPoint(Point point);

    List<Point> getAllPoints();

    List<Line> getLines(int n);

    void removeAllPoints();

}
