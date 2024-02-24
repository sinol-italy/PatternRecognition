package com.example.patternrecognition.api;

import com.example.patternrecognition.model.Point;
import com.example.patternrecognition.model.Line;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IPointApi {

    @PostMapping("point")
    @ResponseStatus(HttpStatus.OK)
    void addPoint(@RequestBody Point point);

    @GetMapping("space")
    @ResponseStatus(HttpStatus.OK)
    List<Point> getAllPoints();

    @GetMapping("lines/{n}")
    @ResponseStatus(HttpStatus.OK)
    List<Line> getLines(@PathVariable int n);

    @DeleteMapping("space")
    @ResponseStatus(HttpStatus.OK)
    void deleteAll();

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    List<String> getErrors(Exception e);

}
