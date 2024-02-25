package com.example.patternrecognition.repository;

import com.example.patternrecognition.model.Point;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PointRepository {
    private final List<Point> points = new ArrayList<>();

    public Point save(Point point) {
        points.add(point);
        return point;
    }

    public List<Point> findAll() {
        return points;
    }

    public void deleteAll() {
        points.clear();
    }

}
