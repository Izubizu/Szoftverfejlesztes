package legoset;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlValue;
import java.util.List;

public class Minifig {

    @XmlAttribute
    private int count;

    @XmlValue
    private String name;

    private List<Minifig> minifigs;


    public Minifig(int count, String name) {
        this.count=count;
        this.name=name;
    }
}
