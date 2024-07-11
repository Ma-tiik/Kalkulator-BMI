package com.grabiec.kalkulator_bmi;
import java.text.DecimalFormat;

import jakarta.validation.constraints.*;

public class KalkulatorBMI {

    @NotNull(message = "Pole nie może być puste")
    @Min(value = 18, message = "Waga musi być większa lub równa 18")
    @Max(value = 220, message = "Waga musi być mniejsza lub równa 220")
    private Double waga;

    @NotNull(message = "Pole nie może być puste")
    @Min(value = 50, message = "Wzrost musi być większy lub równy 50")
    @Max(value = 290, message = "Wzrost musi być mniejszy lub równy 290")
    private Double wzrost;

    @NotNull(message = "Pole nie może być puste")
    @Min(value = 1, message = "Wiek musi być większy lub równy 1")
    @Max(value = 120, message = "Wiek musi być mniejszy lub równy 120")
    private Integer wiek;

    @NotNull(message = "Pole nie może być puste")
    @Pattern(regexp = "^(Mężczyzna|Kobieta)$", message = "Płeć musi być 'Mężczyzna' lub 'Kobieta'")
    private String plec;

    @NotNull(message = "Pole nie może być puste")
    @Min(value = 1, message = "Poziom aktywności musi być większy lub równy 1")
    @Max(value = 4, message = "Poziom aktywności musi być mniejszy lub równy 4")
    private Integer poziomAktywnosci;

    public Double getWaga() {
        return waga;
    }

    public void setWaga(Double waga) {
        this.waga = waga;
    }

    public Double getWzrost() {
        return wzrost;
    }

    public void setWzrost(Double wzrost) {
        this.wzrost = wzrost;
    }

    public Integer getWiek() {
        return wiek;
    }

    public void setWiek(Integer wiek) {
        this.wiek = wiek;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public Integer getPoziomAktywnosci() {
        return poziomAktywnosci;
    }

    public void setPoziomAktywnosci(Integer poziomAktywnosci) {
        this.poziomAktywnosci = poziomAktywnosci;
    }

    public Double obliczBMI() {
        if (waga == null) {
            throw new IllegalArgumentException("Waga nie może być pusta");
        }
        if (wzrost == null) {
            throw new IllegalArgumentException("Wzrost nie może być pusty");
        }
        if (wiek == null) {
            throw new IllegalArgumentException("Wiek nie może być pusty");
        }
        if (plec == null) {
            throw new IllegalArgumentException("Płeć nie może być pusta");
        }
        if (poziomAktywnosci == null) {
            throw new IllegalArgumentException("Poziom aktywności nie może być pusty");
        }

        double bmi;

        if (plec.equals("Mężczyzna")) {
            bmi = 88.362 + (13.397 * waga) + (4.799 * wzrost) - (5.677 * wiek);
        } else {
            bmi = 447.593 + (9.247 * waga) + (3.098 * wzrost) - (4.330 * wiek);
        }

        bmi *= (1.0 + (0.175 * (poziomAktywnosci - 1))) / 100;

        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(bmi));
    }
}