package com.example.patternrecognition.controller;

import com.example.patternrecognition.api.IPointApi;
import com.example.patternrecognition.model.Line;
import com.example.patternrecognition.model.Point;
import com.example.patternrecognition.service.IPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class PatternRecognitionController implements IPointApi {

    @Autowired
    private IPointService pointService;

    @Override
    public void addPoint(Point point) {
        pointService.addPoint(point);
    }

    @Override
    public List<Point> getAllPoints() {
        return pointService.getAllPoints();
    }

    @Override
    public List<Line> getLines(int n) {
        return pointService.getLines(n);
    }

    @Override
    public void deleteAll() {
        pointService.removeAllPoints();
    }

    @Override
    public List<String> getErrors(Exception e) {
        return List.of(e.getMessage());
    }
}
