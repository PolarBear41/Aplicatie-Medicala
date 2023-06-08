/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WebScraper;

import java.util.List;

public class WebScraperToJavaDB {

    public static void main(String[] args) {
        String url = "https://www.drg.ro/DocDRG/ListaTabelara_Boli_ICD_10_AM.pdf";
        WebScraper webScraper = new WebScraper();
        DatabaseManager databaseManager = new DatabaseManager();

        // Scrape data from the website
        List<MentalDisorder> disorders = webScraper.scrapeData(url);

        // Insert data into the database
        databaseManager.insertData(disorders);

        System.out.println("Data successfully scraped and inserted into the database!");
    }

}
