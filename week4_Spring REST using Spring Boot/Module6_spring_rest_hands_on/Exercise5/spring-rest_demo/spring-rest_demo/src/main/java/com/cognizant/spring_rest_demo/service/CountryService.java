package com.cognizant.spring_rest_demo.service;

import java.io.FileInputStream;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import com.cognizant.spring_rest_demo.model.Country;
import com.cognizant.spring_rest_demo.model.CountryList;

@Service
public class CountryService {

    public Country getCountry(String code) throws Exception {
        FileInputStream file = new FileInputStream("src/main/resources/country.xml");

        JAXBContext context = JAXBContext.newInstance(CountryList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        CountryList countryList = (CountryList) unmarshaller.unmarshal(file);

        List<Country> countries = countryList.getCountry();

        Optional<Country> country = countries.stream()
            .filter(c -> c.getCode().equalsIgnoreCase(code))
            .findFirst();

        return country.orElseThrow(() -> new Exception("Country not found"));
    }
}

