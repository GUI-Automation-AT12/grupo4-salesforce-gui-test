package org.fundacionjala.core.utils;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * [RH] Json Reader.
 */
public class JsonReader {

    private static String filePath;

    /**
     *
     * @param filePathh
     */
    protected  JsonReader(final String filePathh) {
        this.filePath = filePathh;
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
}
