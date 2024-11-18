package com.decorators;


public class Main {
    

    public static void main(String[] args) {
        System.setProperty("jna.library.path", "/opt/homebrew/lib");
        // System.setProperty("TESSDATA_PREFIX", "/path/to/tesseract/data/directory/");
        // Шлях до зображення, яке будемо обробляти
        String imagePath = "/Users/ira/Downloads/2b64e80a4291fb0c9db1d0bf2b1aec62.jpg";
        
        // Створення SmartDocument для обробки зображення через Tesseract
        SmartDocument smartDocument = new SmartDocument(imagePath);

        // Створення CachedDocument для кешування результату
        CachedDocument cachedDocument = new CachedDocument(smartDocument);

        // Створення TimedDocument для вимірювання часу
        TimedDocument timedDocument = new TimedDocument(cachedDocument);

        // Виконання парсингу і виведення результату
        String parsedText = timedDocument.parse(imagePath);

        // Виведення результату
        System.out.println("Parsed Text: " + parsedText);
    }
}
