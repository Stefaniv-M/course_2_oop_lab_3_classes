/**
 * Created by Victor on 03.10.2018.
 */
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.concurrent.Executors;


@Getter
@Setter
@ToString
public class City {
    private String name;
    private String url;
    private String administrativeArea;
    private int numberOfCitizens;
    private String yearOfFound;
    private Coordinates coordinates; // Set this
    private double area;

    private static final int INFO_SIZE = 6;




    public static City parse(Element city) {
        Elements info = city.select("td");
        if (info.size() == INFO_SIZE) {
            Element anchor = info.get(1).select("a").get(0);
            City myCity = new City();
            myCity.setName(anchor.attr("title"));
            myCity.setUrl(String.format("https://uk.wikipedia.org%s", anchor.attr("href")));

            anchor = info.get(2).select("a").get(0);
            myCity.setAdministrativeArea(anchor.attr("title"));

            String tempString = info.get(3).ownText();
            tempString = tempString.replaceAll("[^0-9]","");
            if (tempString.equals("")) {
                tempString = info.get(3).child(0).ownText().replaceAll("[^0-9]","");
            }
            myCity.setNumberOfCitizens(Integer.parseInt(tempString));

            anchor = info.get(4).select("a").get(0);
            myCity.setYearOfFound(anchor.attr("title"));

            myCity.setArea(Double.parseDouble(info.get(5).ownText()));

            //TODO  set all other attributes
            return myCity;
        }
        return null;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setUrl(String newUrl) {
        url = newUrl;
    }

    public void setAdministrativeArea(String newAdministrativeArea) {
        administrativeArea = newAdministrativeArea;
    }

    public void setNumberOfCitizens(int numberOfCitizens) {
        this.numberOfCitizens = numberOfCitizens;
    }

    public void setYearOfFound(String newYearOfFound) {
        yearOfFound = newYearOfFound;
    }

    public void setArea(double newArea) {
        area = newArea;
    }

    public void setCoordinates(Coordinates newCoordinates) {
        coordinates = newCoordinates;
    }

}