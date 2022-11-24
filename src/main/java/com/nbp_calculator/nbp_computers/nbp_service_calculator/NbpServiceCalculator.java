package com.nbp_calculator.nbp_computers.nbp_service_calculator;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NbpServiceCalculator {


    public static String getPriceFromDate(String date) throws JSONException {





    /*    // Setting URL
        String url_str = "https://exchange-rates.abstractapi.com/v1/live/?api_key=b6a8bcb345604115860567d046e93199&base=USD&target=PLN";

// Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

// Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

// Accessing object
        String req_result = jsonobj.get("result").getAsString();*/


      //  Date must be in format "yyyy-MM-dd"
        String Url_to_Nbp = "http://api.nbp.pl/api/exchangerates/rates/c/usd/"+date+"/?format=json";
        StringBuffer response = new StringBuffer();
        try{
            URL object = new URL(Url_to_Nbp);
            HttpURLConnection connection = (HttpURLConnection) object.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = new JSONObject(response.toString());
       String dolarValue = (jsonObject.getJSONArray("rates").getJSONObject(0).getString("ask"));
        System.out.println();
        return dolarValue;



      /*  try {
            InputStreamReader reader = new InputStreamReader(url.openStream());
            NbpModel nbpModel = new Gson().fromJson(reader, NbpModel.class);
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }
}
