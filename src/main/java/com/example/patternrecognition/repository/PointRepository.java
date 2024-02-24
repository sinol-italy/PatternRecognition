package com.example.patternrecognition.repository;

import com.example.patternrecognition.model.Point;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PointRepository {
    private final List<Point> points = new ArrayList<>();

    public void addPoint(Point point) {
        points.add(point);
    }

    public List<Point> getAll() {
        return points;
    }

    public void removeAll() {
        points.clear();
    }

}
