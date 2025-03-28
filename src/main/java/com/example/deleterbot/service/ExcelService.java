package com.example.deleterbot.service;

import com.example.deleterbot.entity.Groups;
import com.example.deleterbot.entity.Users;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Service
public class ExcelService {

    public void generateExcelFile(List<Users> users, List<Groups> groups, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet userSheet = workbook.createSheet("Foydalanuvchilar");
            Sheet groupSheet = workbook.createSheet("Guruhlar");

            // **Foydalanuvchilar sahifasi**
            Row userHeader = userSheet.createRow(0);
            userHeader.createCell(0).setCellValue("ID");
            userHeader.createCell(1).setCellValue("Username");

            int userRowNum = 1;
            for (Users user : users) {
                Row row = userSheet.createRow(userRowNum++);
                row.createCell(0).setCellValue(user.getChatId());
                row.createCell(1).setCellValue(user.getUsername());
            }

            // **Guruhlar sahifasi**
            Row groupHeader = groupSheet.createRow(0);
            groupHeader.createCell(0).setCellValue("Guruh ID");
            groupHeader.createCell(1).setCellValue("Guruh nomi");

            int groupRowNum = 1;
            for (Groups group : groups) {
                Row row = groupSheet.createRow(groupRowNum++);
                row.createCell(0).setCellValue(group.getGroupId());
                row.createCell(1).setCellValue(group.getGroupName());
            }

            // **Faylni saqlash**
            FileOutputStream fileOut = new FileOutputStream(filePath);
            workbook.write(fileOut);
            fileOut.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
