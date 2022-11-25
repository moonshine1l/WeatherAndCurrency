package ru.moonshine1l.weather;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controller {

    public static final Logger logger = Logger.getGlobal();



    @FXML
    private TextField city;

    @FXML
    private Text dollar;

    @FXML
    private Text euro;

    @FXML
    private Button getData;

    @FXML
    private Text tempInfo;

    @FXML
    void initialize() {

        getData.setOnAction(event -> {
            String getUserCity = city.getText().trim();
            if (!getUserCity.equals("")) {
                String output = getUrlContent("http://api.openweathermap.org/data/2.5/weather?q=" + getUserCity + "&appid=2be94e563128dfa5e9a8ae3ca0e08d8d&units=metric");

                if (!output.isEmpty()) {
                    JSONObject obj = new JSONObject(output);

                    tempInfo.setText("Температура: " + obj.getJSONObject("main").getDouble("temp"));
                }
            }
        });


        String cur = getUrlContent("https://www.cbr-xml-daily.ru/daily_json.js");
        if (!cur.isEmpty()) {
            JSONObject currencyData = new JSONObject(cur);

            dollar.setText(currencyData.getJSONObject("Valute").getJSONObject("USD").getDouble("Value") + " руб");
            euro.setText(currencyData.getJSONObject("Valute").getJSONObject("EUR").getDouble("Value") + " руб");
        }
    }


    private static String getUrlContent(String urlAdress) {
        StringBuffer content = new StringBuffer();

        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            urlConn.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            logger.log(Level.INFO,"Такой город не был найден!");

        }
        return content.toString();
    }


}


