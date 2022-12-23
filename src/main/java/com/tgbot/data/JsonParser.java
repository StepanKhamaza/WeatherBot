package com.tgbot.data;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JsonParser {
    private final static Logger logger = Logger.getLogger(JsonParser.class);
    public JsonParser() {}
    public String getData(String doc) {
        try {
            StringBuilder result = new StringBuilder();
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(doc);
            JSONObject main = (JSONObject) jsonObject.get("main");
            JSONObject wind = (JSONObject) jsonObject.get("wind");

            float degrees = Float.parseFloat(main.get("temp").toString()) - 273.15f;
            float feelsLike = Float.parseFloat(main.get("feels_like").toString()) - 273.15f;
            float humidity = Float.parseFloat(main.get("humidity").toString());
            float windSpeed = Float.parseFloat(wind.get("speed").toString());
            String city = (String) jsonObject.get("name");

            result.append(city).append(" ").append(getDate()).append("\n");
            result.append("Temperature: <b><i>").append(String.format("%.0f", degrees)).append("°C\n</i></b>");
            result.append("Feels like: <b><i>").append(String.format("%.0f", feelsLike)).append("°C\n</i></b>");
            result.append("Humidity: <b><i>").append(String.format("%.0f", humidity)).append("%").append("\n</i></b>");
            result.append("Wind speed: <b><i>").append(String.format("%.0f", windSpeed)).append("m\\s\n</i></b>");

            return new String(result);
        } catch (ParseException e) {
            logger.error("Parsing error", e);
        }

        return null;
    }

    public String getDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return date.format(formatter);
    }
}