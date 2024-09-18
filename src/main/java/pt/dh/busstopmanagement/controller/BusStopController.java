package pt.dh.busstopmanagement.controller;

import org.springframework.web.bind.annotation.*;
import pt.dh.busstopmanagement.model.Position;

import java.util.List;

@RestController
public class BusStopController {

    @PostMapping("/getNearestBusStop/v1")
    Position getNearestBusStopCapped(@RequestParam String longitude, @RequestParam String latitude , @RequestBody List<Position> busStop) {

        return getNearestCapped(new Position(Integer.parseInt(longitude), Integer.parseInt(latitude)), busStop);
    }

    private static Position getNearestCapped(final Position currentLocation, final List<Position> busStop) {
        var minDistance = 90;
        var nearestBusStop = currentLocation;

        for (Position current: busStop) {
            var distance = current.distanceTo(currentLocation);
            if(distance < minDistance) {
                nearestBusStop = current;
                minDistance = distance;
            }
        }

        return nearestBusStop;
    }

    @PostMapping("/getNearestBusStop/v2")
    Position getNearestBusStopNoAbsolute(@RequestParam Integer longitude, @RequestParam Integer latitude , @RequestBody List<Position> busStop) {

        return getNearestNoAbsolute(new Position(longitude, latitude), busStop);
    }

    private static Position getNearestNoAbsolute(final Position currentLocation, final List<Position> busStop) {
        var minDistance = Integer.MAX_VALUE;
        var nearestBusStop = currentLocation;

        for (Position current: busStop) {
            var distance = current.distanceToNoAbsolute(currentLocation);
            if(distance < minDistance) {
                nearestBusStop = current;
                minDistance = distance;
            }
        }

        return nearestBusStop;
    }

    @PostMapping("/getNearestBusStop/v3")
    Position getNearestBusStop(@RequestParam Integer longitude, @RequestParam Integer latitude , @RequestBody List<Position> busStop) {

        return getNearest(new Position(longitude, latitude), busStop);
    }

    private static Position getNearest(final Position currentLocation, final List<Position> busStop) {
        var minDistance = Integer.MAX_VALUE;
        var nearestBusStop = currentLocation;

        for (Position current: busStop) {
            var distance = current.distanceTo(currentLocation);
            if(distance < minDistance) {
                nearestBusStop = current;
                minDistance = distance;
            }
        }

        return nearestBusStop;
    }
}
