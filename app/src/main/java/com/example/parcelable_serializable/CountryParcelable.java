package com.example.parcelable_serializable;

import android.os.Parcel;
import android.os.Parcelable;

public class CountryParcelable implements Parcelable {
    String countryName;
    String capital;
    String nationalLanguage;

    public CountryParcelable(String countryName, String capital, String nationalLanguage) {
        this.countryName = countryName;
        this.capital = capital;
        this.nationalLanguage = nationalLanguage;
    }

    protected CountryParcelable(Parcel in) {
        countryName = in.readString();
        capital = in.readString();
        nationalLanguage = in.readString();
    }

    public static final Creator<CountryParcelable> CREATOR = new Creator<CountryParcelable>() {
        @Override
        public CountryParcelable createFromParcel(Parcel in) {
            return new CountryParcelable(in);
        }
        @Override
        public CountryParcelable[] newArray(int size) {
            return new CountryParcelable[size];
        }
    };

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(countryName);
        dest.writeString(capital);
        dest.writeString(nationalLanguage);
    }

    public String getCountryName() { return countryName; }
    public String getCapital() { return capital; }
    public String getNationalLanguage() { return nationalLanguage; }
}
