package com.example.currency_converter;

public class CurrencyConverter {
    private float currency;

    public float getCurrency() {
        return currency;
    }

    public void setCurrency(float currency) {
        this.currency = currency;
    }

    public float converToDollar()
    {
        return (currency/22);
    }

    public float converToEgyPound()
    {
        return (currency*22);
    }
}
