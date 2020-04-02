package legoset;

import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.net.URL;
import java.time.Year;
import java.util.List;

@XmlRootElement
@XmlType(propOrder={"name", "theme", "subtheme", "year", "pieces", "tags", "minifigs","weight","url"})
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class LegoSet {
    @XmlAttribute
    private String number;

    private String name;
    private String theme;
    private String subtheme;

    @XmlJavaTypeAdapter(YearAdapter.class)
    private Year year;

    private int pieces;

    @XmlElementWrapper(name="tags")
    @XmlElement(name="tag")
    private List<String> tags;

    @XmlElementWrapper(name="minifigs")
    @XmlElement(name="minifig")
    private List<Minifig> minifigs;


    private List<Weight> weight;
    private URL url;

}

