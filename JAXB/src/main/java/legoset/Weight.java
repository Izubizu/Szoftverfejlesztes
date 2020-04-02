package legoset;

import java.math.BigDecimal;
import java.net.URL;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class Weight {

    @XmlAttribute
    private String unit;

    @XmlValue
    private double value;

    public Weight(String unit, double value) {
        this.unit = unit;
        this.value = value;
    }
}
