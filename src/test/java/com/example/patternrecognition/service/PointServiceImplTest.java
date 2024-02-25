package com.example.patternrecognition.service;

import com.example.patternrecognition.model.Line;
import com.example.patternrecognition.model.Point;
import com.example.patternrecognition.repository.PointRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PointServiceImplTest {

    @Mock
    private PointRepository pointRepository;

    @InjectMocks
    private PointServiceImpl pointService;

    private static final Point POINT_1 = new Point(0d, 0d);
    private static final Point POINT_2 = new Point(3d, 1d);
    private static final Point POINT_3 = new Point(6d, 2d);
    private static final Point POINT_4 = new Point(3d, 3d);

    private static final List<Point> points = new ArrayList<>(List.of(POINT_1, POINT_2, POINT_3, POINT_4));

    @Test
    void addPoint() {
        when(pointRepository.save(POINT_1)).thenReturn(POINT_1);
        Point point = pointService.addPoint(POINT_1);
        verify(pointRepository, times(1)).save(any(Point.class));
        assertEquals(POINT_1.getX(), point.getX());
        assertEquals(POINT_1.getY(), point.getY());
    }

    @Test
    void getAllPoints() {
        when(pointRepository.findAll()).thenReturn(points);
        List<Point> allPoints = pointService.getAllPoints();
        verify(pointRepository, times(1)).findAll();
        assertEquals(points, allPoints);
    }

    @Test
    void getLines() {
        int n =3;
        when(pointRepository.findAll()).thenReturn(points);
        List<Line> result = pointService.getLines(n);
        verify(pointRepository, times(1)).findAll();
        assertEquals(1, result.size());
        assertEquals(3, result.get(0).getPoints().size());
        n = 2;
        result = pointService.getLines(n);
        assertEquals(4, result.size());
        assertEquals(9, result.stream().map(Line::getPoints).flatMap(Set::stream).toList().size());
    }

    @Test
    void removeAllPoints() {
        pointService.removeAllPoints();
        verify(pointRepository, times(1)).deleteAll();
    }

}