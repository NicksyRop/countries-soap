package com.pesalink.pesalink.service;

import com.pesalink.pesalink.soap.Body;
import com.pesalink.pesalink.soap.CountryName;
import com.pesalink.pesalink.soap.Envelop;
import com.pesalink.pesalink.util.Helper;
import org.springframework.stereotype.Service;

@Service
public class PesaLinkService {
    public String testXml(){
        CountryName name = new CountryName();
        name.setsCountryISOCode("US");
        Envelop envelop = new Envelop();
        Body body = new Body();
        envelop.setBody(body);
        body.setCountryName(name);
        String xmlString = Helper.objectToXml(envelop, Envelop.class);
        sendSoapRequest(xmlString);
        return xmlString;
    }

    private void sendSoapRequest(String xml){
        String uri = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";
    }
}
