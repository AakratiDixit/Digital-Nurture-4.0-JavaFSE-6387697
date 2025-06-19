package Module1_DesignPatternsandPrinciples.FactoryMethodPatternExample.Code;
// Java automatically folder hierarchy ko package name bana deta hai. Matlab: Tumhari file Design_Patterns/FactoryMethodPatternExample folder ke andar hai.
// Package = Folder path in Java

public class Main {
    public static void main(String[] args) {
        // Create Word Document
        DocumentFactory wordFactory = new WordFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        // Create PDF Document
        DocumentFactory pdfFactory = new PdfFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        // Create Excel Document
        DocumentFactory excelFactory = new ExcelFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}

//firstly made a common interface documnet
//different document classes = wordDocument , pdfDocument , ExcelDocument = every class will implement document interface
// abstract documentFactory class= its work is to open a document but which document that will be decided by another factory.
//make concrete factory:
//pdfFactory , wordFactory , ExcelFactory = every class will extend documentFactory class ans executes its operation to open document = returns pdfDocument , wordDocument , ExcelDocument