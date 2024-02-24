package com.example.patternrecognition.service;

import com.example.patternrecognition.model.Line;
import com.example.patternrecognition.model.Point;
import com.example.patternrecognition.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointServiceImpl implements IPointService {

    @Autowired
    private PointRepository pointRepository;

    @Override
    public void addPoint(Point point) {
        pointRepository.addPoint(point);
    }

    @Override
    public List<Point> getAllPoints() {
        return pointRepository.getAll();
    }

    @Override
    public List<Line> getLines(int n) {
        //todo
        return null;
    }

    @Override
    public void removeAllPoints() {
        pointRepository.removeAll();
    }
}
