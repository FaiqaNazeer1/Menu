package com.example.parcelable_serializable;
import java.io.Serializable;

public class CountrySerializable implements Serializable {
    String countryName;
    String capital;
    String nationalLanguage;

    public CountrySerializable(String countryName, String capital, String nationalLanguage) {
        this.countryName = countryName;
        this.capital = capital;
        this.nationalLanguage = nationalLanguage;
    }

    public String getCountryName() { return countryName; }
    public String getCapital() { return capital; }
    public String getNationalLanguage() { return nationalLanguage; }
}
