package hnr.piwnica.backend.utils;

public class MathUtil {
    public static double distanceFromCoordinates(double lat1, double lon1, double lat2, double lon2)
    {
        double earthRadius = 6371000;// in meters
        double angle1 = lat1 * Math.PI/180; // φ, λ in radians
        double angle2 = lat2 * Math.PI/180;
        double delta_angle1 = (lat2-lat1) * Math.PI/180;
        double delta_angle2 = (lon2-lon1) * Math.PI/180;

        double a = Math.sin(delta_angle1/2) * Math.sin(delta_angle1/2) +
                    Math.cos(angle1) * Math.cos(angle2) *
                            Math.sin(delta_angle2/2) * Math.sin(delta_angle2/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        double d = earthRadius * c; // in metres
        return d;
    }
}
