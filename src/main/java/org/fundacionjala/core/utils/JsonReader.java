package org.fundacionjala.core.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * [RH] Json Reader.
 */
public class JsonReader {

    private static String filePath;

    /**
     *This method returns the file's path.
     * @param path
     */
    protected JsonReader(final String path) {
        filePath = path;
    }

    /**
     * Try to read a json file and return a JSONArray with the read info.
     * @return JSONArray
     * */
    public static JSONArray jsonArrayFromJsonFile() throws ParseException {
        try {
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(filePath);
            Object obj = jsonParser.parse(reader);
            return (JSONArray) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONArray();
    }

    /**
     * Get data from json file.
     * @param alias
     * @return value
     */
    public static Map<String, String> getData(final String alias) {
        try {
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            JSONObject jsonData = (JSONObject) jsonObject.get(alias);
            return (Map<String, String>) jsonData;
        } catch (FileNotFoundException fe) {
            throw new RuntimeException("Error when reading JSON file");
        } catch (IOException ioe) {
            throw new RuntimeException("Error when reading JSON file");
        } catch (ParseException pe) {
            throw new RuntimeException("Error Parse JSON file");
        } catch (Exception e) {
            throw new RuntimeException("Error in JSON reader file");
        }
    }
}
