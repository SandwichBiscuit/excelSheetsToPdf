package com.github.caryyu.excelpdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.junit.Test;

import com.github.caryyu.excel2pdf.Excel2Pdf;
import com.github.caryyu.excel2pdf.ExcelObject;
import com.itextpdf.text.DocumentException;

public class SimpleTests {

	@Test
    public void testCase1OfSingle() throws IOException, DocumentException {
        String fileIn = "sample1/case1.xls";

        InputStream in = this.getClass().getResourceAsStream(fileIn);
        Excel2Pdf excel2Pdf = new Excel2Pdf(Arrays.asList(
                new ExcelObject(in)
        ), new FileOutputStream(fileOut(fileIn)));
        excel2Pdf.convert();
    }
	 
    private File fileOut(String fileIn) {
        String uri = this.getClass().getResource(fileIn).getPath();
        String fileOut = uri.replaceAll(".xls$|.xlsx$",".pdf");
        File file = new File(fileOut);
        return file;
    }
}
