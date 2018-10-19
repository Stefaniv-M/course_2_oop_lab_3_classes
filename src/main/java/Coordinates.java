import lombok.ToString;
import org.jsoup.select.Elements;

import javax.xml.bind.Element;


//TODO Create class that represents coordinates
@ToString
public class Coordinates {
    private double lat;
    private double lon;

    public void setLat(double newLat) {
        lat = newLat;
    }

    public void setLon(double newLon) {
        lon = newLon;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public Coordinates (double newLat, double newLon) {
        lat = newLat;
        lon = newLon;
    }

}
