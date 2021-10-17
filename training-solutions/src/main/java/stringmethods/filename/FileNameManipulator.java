package stringmethods.filename;

import javax.swing.*;
import java.util.Locale;

public class FileNameManipulator {
    private String removeWhiteSpaces(String fileName) {
        return fileName.trim();
    }

    public char findLastCharacter(String str) {
        return str.charAt(str.length()-1);
    }

    public String findFileExtension(String fileName) {
        fileName = removeWhiteSpaces(fileName);
        int pointPosition;
        String result = "";
        pointPosition = fileName.lastIndexOf(".");
        if (pointPosition != -1) {
            result = fileName.substring(pointPosition+1,fileName.length());
        }
        return result;
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        fileName = removeWhiteSpaces(fileName);
        String fileExt = findFileExtension(fileName);
        return ext.equals(fileExt);
    }

    public boolean compareFilesByName(String searchedFileName, String actualFilename) {
        return searchedFileName.equals(actualFilename);
    }

    public String changeExtensionToLowerCase(String fileName) {
        fileName = removeWhiteSpaces(fileName);
        String extension = findFileExtension(fileName);
        String lowerCaseExtension = extension.toLowerCase();
        return fileName.replace(extension,lowerCaseExtension);
    }

    public String replaceStringPart(String fileName, String present, String target) {
        fileName = removeWhiteSpaces(fileName);
        return fileName.replace(present,target);
    }

    public static void main(String[] args) {
        FileNameManipulator fileNameManipulator = new FileNameManipulator();
        String fileName = " FileNameManipulator.JAVA ";
        System.out.println("Utolsó karakter: " + fileNameManipulator.findLastCharacter(fileName));
        System.out.println("Kiterjesztés: " + fileNameManipulator.findFileExtension(fileName));
        System.out.println("Egyező kiterjesztés: " + fileNameManipulator.identifyFilesByExtension("JAVA", fileName));
        System.out.println("Eltérő kiterjesztés: " + fileNameManipulator.identifyFilesByExtension("py", fileName));
        System.out.println("Egyező fájlnév: " + fileNameManipulator.compareFilesByName(fileName, fileName));
        System.out.println("Eltérő fájlnév: " + fileNameManipulator.compareFilesByName("FileNameManipulator.py", fileName));
        System.out.println("Kiterjesztés kisbetűsítése: " + fileNameManipulator.changeExtensionToLowerCase(fileName));
        System.out.println("Részlet cseréje: " + fileNameManipulator.replaceStringPart(fileName,"Manipulator", "Methods"));
    }
}
