package com.decorators;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.io.File;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SmartDocument implements Document {
    private String imagePath;

    @Override
    public String parse(String path) {
        File imageFile = new File(imagePath);
        ITesseract instance = new Tesseract();
        instance.setDatapath("/opt/homebrew/share/tessdata/");

        try {
            return instance.doOCR(imageFile);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return "";
    }
}