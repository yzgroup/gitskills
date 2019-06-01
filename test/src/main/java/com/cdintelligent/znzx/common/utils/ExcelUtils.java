
package com.cdintelligent.znzx.common.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;

/**
 * <p>Description: excel读写工具类.</p>
 * <p>Copyright: Copyright(c) 2017.</p>
 * <p>Company: 成都四方.</p>
 * <p>CreateTime: 2017.10.31.</p>
 *
 * @author ngl
 * @version 1.0
 */
public final class ExcelUtils
{
    // private static final Logger logger = Logger.getLogger(ExcelUtils.class);

    /**
     * <p>Description: 读excel数据</p>
     * <p>Copyright: Copyright(c)2017</p>
     * <p>Company: 成都四方</p>
     * <p>CreateTime: 2017.10.30</p>
     *
     * @param wb Workbook
     * @param num 从多少行开始读
     * @return List<List<String>>
     * @author ngl
     * @version 1.0
     */
    public static List<List<String>> readExcelValue(Workbook wb, int num) throws IOException
    {
        List<List<String>> list = new ArrayList<List<String>>();

        // 得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        // 得到Excel的行数
        int totalRows = sheet.getPhysicalNumberOfRows();
        int totalCells = 0;
        // 得到Excel的列数(前提是有行数)
        if (totalRows >= 1 && sheet.getRow(0) != null)
        {
            totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        // 循环Excel行数
        for (int r = num; r < totalRows; r++)
        {
            Row row = sheet.getRow(r);
            if (row == null) continue;

            List<String> lineList = new ArrayList<String>();
            StringBuffer sb = new StringBuffer();
            // 循环Excel的列
            for (int c = 0; c < totalCells; c++)
            {
                String str = "";
                Cell cell = row.getCell(c);
                if (null != cell)
                {
                    switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                    str = String.valueOf(cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                    str = String.valueOf(cell.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                    str = NumberToTextConverter.toText(cell.getNumericCellValue());
                        // str = String.valueOf(cell.getNumericCellValue());
                        break;
                    case Cell.CELL_TYPE_BLANK:
                    str = "";
                        break;
                    case Cell.CELL_TYPE_FORMULA:
                    str = String.valueOf(cell.getCachedFormulaResultType());
                        break;
                    default:
                        break;
                    }
                    lineList.add(str);
                    sb.append(str);
                }
                else
                {
                    lineList.add("");
                }
            }
            // 判断空行跳出循环
            if (sb.length() <= 0)
            {
                break;
            }
            list.add(lineList);
        }
        return list;
    }

    /**
     * <p>Description: 写excel数据</p>
     * <p>Copyright: Copyright(c)2017</p>
     * <p>Company: 成都四方</p>
     * <p>CreateTime: 2017.10.30</p>
     *
     * @param list data
     * @param path 写入路径
     * @throws IOException
     * @author ngl
     * @version 1.0
     */
    public static void writeExcel(List<List<String>> list, String path) throws IOException
    {
        // 创建一个webbook，对应一个Excel文件
        @SuppressWarnings("resource")
        HSSFWorkbook wb = new HSSFWorkbook();
        // 在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("sheet");

        // 创建单元格，并设置值表头 设置表头居中
        // HSSFCellStyle style = wb.createCellStyle();
        // style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        for (int i = 0; i < list.size(); i++)
        {
            // 在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
            HSSFRow row = sheet.createRow(i);
            List<String> l = list.get(i);
            for (int j = 0; j < l.size(); j++)
            {
                HSSFCell cell = row.createCell(j);
                cell.setCellValue(l.get(j));
            }
        }
        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);
        fos.close();
    }
}
