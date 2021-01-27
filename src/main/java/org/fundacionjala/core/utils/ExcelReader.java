package org.fundacionjala.core.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * [RH] Excel reader class.
 */
public class ExcelReader {

    private final String filePath;
    private Workbook workbook;

    protected ExcelReader(final String path) {
        try {
            filePath = path;
            workbook = WorkbookFactory.create(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * [RH] This method returns the read workbook.
     * @return workbook.
     */
    public Workbook getWorkbook() {
        return workbook;
    }

    /**
     * [RH] This method search a sheet.
     * @param sheetName
     * @return sheet
     */
    protected Sheet searchSheet(final String sheetName) {
        Sheet searchedSheet = null;
        for (Sheet sheet: workbook) {
            if (sheet.getSheetName().equals(sheetName)) {
                searchedSheet = sheet;
            }
        }
       return searchedSheet;
    }

    /**
     * [RH] This method converts a sheet to json list.
     * @param sheet
     * @return list
     */
    protected List<JSONObject> convertToJson(final Sheet sheet) {
        DataFormatter dataFormatter = new DataFormatter();
        List<JSONObject> data = new ArrayList<>();
        for (Row row : sheet) {
            if (row.getRowNum() != 0) {
                JSONObject jsonObject = new JSONObject();
                for (Cell cell : row) {
                    jsonObject.put(dataFormatter.formatCellValue(sheet.getRow(sheet.getFirstRowNum())
                            .getCell(cell.getColumnIndex())), dataFormatter.formatCellValue(cell));
                }
                data.add(jsonObject);
            }
        }
        return data;
    }
}
