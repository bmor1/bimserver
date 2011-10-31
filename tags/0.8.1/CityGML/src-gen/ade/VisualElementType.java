
package ade;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.citygml4j.jaxb.citygml.core._1.AbstractCityObjectType;
import org.citygml4j.jaxb.gml._3_1_1.MultiSurfacePropertyType;


/**
 * <p>Java class for VisualElementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VisualElementType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/citygml/1.0}AbstractCityObjectType">
 *       &lt;sequence>
 *         &lt;element name="Lod3MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VisualElementType", propOrder = {
    "lod3MultiSurface"
})
@XmlSeeAlso({
    TransportElementType.class,
    RailingType.class,
    OpeningElementType.class,
    ColumnType.class,
    FlowTerminalType.class,
    StairType.class,
    AnnotationType.class,
    BeamType.class,
    StairFlightType.class
})
public class VisualElementType
    extends AbstractCityObjectType
{

    @XmlElement(name = "Lod3MultiSurface", required = true)
    protected MultiSurfacePropertyType lod3MultiSurface;

    /**
     * Gets the value of the lod3MultiSurface property.
     * 
     * @return
     *     possible object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public MultiSurfacePropertyType getLod3MultiSurface() {
        return lod3MultiSurface;
    }

    /**
     * Sets the value of the lod3MultiSurface property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public void setLod3MultiSurface(MultiSurfacePropertyType value) {
        this.lod3MultiSurface = value;
    }

    public boolean isSetLod3MultiSurface() {
        return (this.lod3MultiSurface!= null);
    }

}