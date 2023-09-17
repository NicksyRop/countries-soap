package com.pesalink.pesalink.service;

import com.pesalink.pesalink.soap.Body;
import com.pesalink.pesalink.soap.CountryName;
import com.pesalink.pesalink.soap.Envelop;
import com.pesalink.pesalink.util.Helper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class PesaLinkService {
    private final RestTemplate restTemplate;

    public PesaLinkService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String testXml(){
        CountryName name = new CountryName();
        name.setsCountryISOCode("US");
        Body body = new Body();
        Envelop envelop = new Envelop();
        envelop.setBody(body);
        body.setCountryName(name);
        String xmlString = Helper.objectToXml(envelop, Envelop.class);
//        String xmlString = """
//                <?xml version="1.0" encoding="utf-8"?>
//                <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
//                  <soap:Body>
//                    <CountryName xmlns="http://www.oorsprong.org/websamples.countryinfo">
//                      <sCountryISOCode>US</sCountryISOCode>
//                    </CountryName>
//                  </soap:Body>
//                </soap:Envelope>
//                """;
        log.info("RQUEST IS {}", xmlString);
        sendSoapRequest(xmlString);
        return xmlString;
    }

    private void sendSoapRequest(String xml){
        log.info("xmlString {}" ,xml );
        String uri = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_XML);
        HttpEntity<String> httpEntity = new HttpEntity<>(xml,headers);
        ResponseEntity<String> response = restTemplate.postForEntity(uri ,httpEntity, String.class);
        log.info(response.getStatusCode().toString());
        log.info("Results is {}",response.getBody());
    }
}
