package org.fundacionjala.core.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class ExcelReaderTest {

    @Test
    public void testReadExcel() throws IOException, InvalidFormatException {
        ExcelReader excel =  new ExcelReader();
        excel.readFile();
    }

}