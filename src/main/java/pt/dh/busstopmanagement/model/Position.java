package pt.dh.busstopmanagement.model;

public record Position(int longitude, int latitude)  {

    public int distanceTo(Position toCompare) {
        var xs = Math.abs(toCompare.longitude() - longitude());
        var ys = Math.abs(toCompare.latitude() - latitude());

        return xs + ys;
    }

    public int distanceToSwitched(Position toCompare) {
        var xs = Math.abs(toCompare.latitude() - longitude());
        var ys = Math.abs(toCompare.latitude() - longitude());

        return xs + ys;
    }

    public int distanceToNoAbsolute(Position toCompare) {
        var xs = toCompare.longitude() - longitude();
        var ys = toCompare.latitude() - latitude();

        return xs + ys;
    }
}
