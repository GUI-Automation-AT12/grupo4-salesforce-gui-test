package org.fundacionjala.core.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;


public class ExcelReaderTest {

    @Test
    public void testReadExcel() {
        SetupReader setupReader =  new SetupReader();
        List<JSONObject> contactList = setupReader.getConvertedContactSheet();
       System.out.println(contactList.toString());
       String expected ="[{\"firstName\":\"JhordanAPI-Contact \",\"LastName\":\"SotoAPI-Contact\"}," +
               " {\"firstName\":\"RodrigoAPI-Contact\",\"LastName\":\"HuancaAPI-Contact\"}," +
               " {\"firstName\":\"ElyAPI-Contact\",\"LastName\":\"BravoAPI-Contact\"}]";
        Assert.assertEquals(contactList.toString(), expected);
    }

}