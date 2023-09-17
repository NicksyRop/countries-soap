package com.pesalink.pesalink.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@XmlRootElement(name = "CountryName", namespace = "http://www.oorsprong.org/websamples.countryinfo")
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class CountryName {
    @XmlAttribute(name = "sCountryISOCode")
    private String sCountryISOCode;
    public String getsCountryISOCode() {
        return sCountryISOCode;
    }

    public void setsCountryISOCode(String sCountryISOCode) {
        this.sCountryISOCode = sCountryISOCode;
    }
}
