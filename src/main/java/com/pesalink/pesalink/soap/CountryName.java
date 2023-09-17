package com.pesalink.pesalink.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class CountryName {
    @XmlElement(namespace = "http://www.oorsprong.org/websamples.countryinfo")
    private String sCountryISOCode;

    public String getsCountryISOCode() {
        return sCountryISOCode;
    }

    public void setsCountryISOCode(String sCountryISOCode) {
        this.sCountryISOCode = sCountryISOCode;
    }
}
