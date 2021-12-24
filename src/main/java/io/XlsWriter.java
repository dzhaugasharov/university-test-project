package io;

import model.Statistics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class XlsWriter {

    private static final Logger log = LogManager.getLogger(XlsWriter.class);

    public static void writeToXlsx(List<Statistics> data, String filePath) throws IOException {

        log.info("writing data to xlsx file: " + filePath);

        FileOutputStream outputStream = new FileOutputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Statistics");
        XSSFRow headerRow = sheet.createRow(0);

        // headers
        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.getFontAt(0);
        font.setBold(true);
        headerStyle.setFont(font);
        String[] headers = {"профиль обучения", "средний балл за экзамен", "количество студентов по профилю",
                "количество университетов по профилю", "названия университетов"};
        for (int i = 0; i < headers.length; i++) {
            XSSFCell cell = headerRow.createCell(i);
            cell.setCellStyle(headerStyle);
            cell.setCellValue(headers[i]);
        }

        // data
        int rowIndex = 1;
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        XSSFFont rowFont = cellStyle.getFont();
        rowFont.setBold(false);
        cellStyle.setFont(rowFont);
        for (Statistics s : data) {
            XSSFRow row = sheet.createRow(rowIndex);
            row.setRowStyle(cellStyle);
            row.createCell(0).setCellValue(s.getStudyProfile().getValue());
            if (s.getAverageExamMark() != null) row.createCell(1).setCellValue(s.getAverageExamMark());
            row.createCell(2).setCellValue(s.getTotalStudents());
            row.createCell(3).setCellValue(s.getTotalUniversities());
            row.createCell(4).setCellValue(Arrays.toString(s.getUniversityTitles()));
            rowIndex++;
        }

        workbook.write(outputStream);
    }
}
