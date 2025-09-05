package com.example.myproject.runners;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/web", // Hanya fitur Web UI
        glue = {"com.example.myproject.stepdefinitions", "com.example.myproject.utilities"}, // Step defs Web UI dan Hooks
        plugin = {
                "pretty",
                "html:build/cucumber-reports/web/web-report.html", // Laporan HTML terpisah
                "json:build/cucumber-reports/web/web-report.json"   // Laporan JSON terpisah
        },
        monochrome = true,
        tags = "@web" // Hanya jalankan skenario dengan tag @web
)

public class WebTestsRunner {
}
