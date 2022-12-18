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
            String result = "";
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(doc);
            JSONObject main = (JSONObject) jsonObject.get("main");
            JSONObject wind = (JSONObject) jsonObject.get("wind");

            Double degrees = Double.parseDouble(main.get("temp").toString()) - 273.15;
            Double feelsLike = Double.parseDouble(main.get("feels_like").toString()) - 273.15;
            Double humidity = Double.parseDouble(main.get("humidity").toString());
            Double windSpeed = Double.parseDouble(wind.get("speed").toString());
            String city = (String) jsonObject.get("name");

            result += city + " " + getDate() + '\n';
            result += "Temperature: <b><i> %s°C\n</i></b>".formatted(String.format("%.0f", degrees));
            result += "Feels like: <b><i>%s°C\n</i></b>".formatted(String.format("%.0f", feelsLike));
            result += "Humidity: <b><i>%s%s\n</i></b>".formatted(String.format("%.0f", humidity), "%");
            result += "Wind speed: <b><i>%sm\\s\n</i></b>".formatted(String.format("%.0f", windSpeed));

            return result;
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