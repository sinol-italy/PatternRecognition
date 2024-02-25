package com.example.patternrecognition.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Point {
    private double x;
    private double y;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass() || this != o) {
            return false;
        }
        Point point = (Point) o;
        return x == point.getX() && y == point.getY();
    }

}
