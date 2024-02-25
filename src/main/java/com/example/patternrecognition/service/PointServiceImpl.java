package com.example.patternrecognition.service;

import com.example.patternrecognition.model.Line;
import com.example.patternrecognition.model.Point;
import com.example.patternrecognition.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PointServiceImpl implements IPointService {

    @Autowired
    private PointRepository pointRepository;

    @Override
    public Point addPoint(Point point) {
        return pointRepository.save(point);
    }

    @Override
    public List<Point> getAllPoints() {
        return pointRepository.findAll();
    }

    @Override
    public List<Line> getLines(int n) {
        Set<Line> result = new HashSet<>();
        List<Point> allPoints = getAllPoints();
        for (Point point1 : allPoints) {
            for (Point point2 : allPoints) {
                Set<Point> points = new HashSet<>();
                points.add(point1);
                points.add(point2);
                for (Point point3 : allPoints) {
                    if (!point1.equals(point2) && !point1.equals(point3) && !point2.equals(point3) && isPointsInLine(point1, point2, point3)) {
                        points.add(point3);
                    }
                }
                if (points.size() >= n) {
                    result.add(new Line(points));
                }
            }
        }
        return result.stream().toList();
    }

    @Override
    public void removeAllPoints() {
        pointRepository.deleteAll();
    }

    private boolean isPointsInLine(Point first, Point second, Point third) {
        double xDistanceFirstSecond = getDistance(first.getX(), second.getX());
        double yDistanceFirstSecond = getDistance(first.getY(), second.getY());
        double xDistanceSecondThird = getDistance(second.getX(), third.getX());
        double yDistanceSecondThird = getDistance(second.getY(), third.getY());
        return yDistanceFirstSecond * xDistanceSecondThird == yDistanceSecondThird * xDistanceFirstSecond;
    }

    private double getDistance(double coordinate1, double coordinate2) {
        return coordinate2 - coordinate1;
    }
}
