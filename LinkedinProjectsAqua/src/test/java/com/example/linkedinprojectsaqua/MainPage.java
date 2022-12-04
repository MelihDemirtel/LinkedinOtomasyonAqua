package com.example.linkedinprojectsaqua;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.title;

// page_url = https://demoqa.com
public class MainPage {
    public SelenideElement elementsButton = $x("(//div[@class='card mt-4 top-card'])[1]");

    public SelenideElement formsButton = $x("(//div[@class='card mt-4 top-card'])[2]");
}
