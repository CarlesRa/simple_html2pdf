package com.carlesramos.html2pdf.services;
import com.itextpdf.html2pdf.HtmlConverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Util {

    public static boolean convertToPdf(String htmlTemplate, String filePath) {
        try {
            File file = new File(filePath);
            file.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(file);
            HtmlConverter.convertToPdf(htmlTemplate, outputStream);
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
