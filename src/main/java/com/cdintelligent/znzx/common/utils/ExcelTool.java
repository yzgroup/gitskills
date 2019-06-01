package com.cdintelligent.znzx.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * <p>Title: ExcelTool.java</p>
 * <p>Description:XLS工具类 </p>
 * <p>Copyright:Copyright(c)2011</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:2014-12-8</p>
 * @author zhangdalong
 * @version 1.0
 **/
public class ExcelTool {

    /** 标题 */
    private int titleRow;

    // /** 数据起始行 */
    // private int dataRow= 1;

    /** 每页最大行 */
//    private static int maxPageRows = 15000;

    private static int maxPageRows = 65000;
    
    /** 记录数据索引 */
    int nowdatasindex;

    /**
     * 创建excecl
     * @author zhangdalong
     * @creaetime 2014-12-8
     * @param title 表格标题名
     * @param headers 表格属性列名数组
     * @param dataset 需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象
     * @param out 与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
     */
    @SuppressWarnings("rawtypes")
    public void createExl(String title, String[] headers, List dataset, OutputStream out) {

        // 生成一个表格
        HSSFSheet sheet = null;
        HSSFRichTextString richString = null;
        // 单元格
        HSSFCell cell = null;
        // 行
        HSSFRow row = null;
        HSSFRichTextString text = null;

        // 声明一个工作薄

        HSSFWorkbook workbook = new HSSFWorkbook();
        
        //设置单元格样式
        HSSFCellStyle style = workbook.createCellStyle();     // 建立新的cell样式  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);       // 左右居中  
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);       
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);   //边框
        style.setFillForegroundColor(new HSSFColor.PALE_BLUE()     
                        .getIndex());     
        style.setFillBackgroundColor(new HSSFColor.PALE_BLUE()     //设置边框颜色
                        .getIndex());     
        style.setFillPattern(HSSFCellStyle.SPARSE_DOTS);   

        // //创建样式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);// 左对齐

        // 建立一个工作薄
        sheet = workbook.createSheet("title");
        // 设置表格默认列宽度为40个字节
        sheet.setDefaultColumnWidth(30);
        // 创建一个DataFormat对象
        HSSFDataFormat format = workbook.createDataFormat();
        // 这样才能真正的控制单元格格式，@就是指文本型
        cellStyle.setDataFormat(format.getFormat("@"));

        // 建立标题
        row = sheet.createRow(this.titleRow);
        // 创建标题
        for (int i = 0; i < headers.length; i++) {
            cell = row.createCell(i);
            text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
            cell.setCellStyle(style); 
        }

        //如果集合不为为空，写入数据
        if(!Tools.isEmpty(dataset)){
        	// 写入内容
        	// 不能超过最大行数，且当前数据统计量不能超过数据集的大小
        	Object obj = null;
        	for (int j = 0; j < maxPageRows; j++) {
        		
        		// 创建数据行数
        		row = sheet.createRow(j + 1);
        		// 获取一个对象
        		if ( nowdatasindex <= dataset.size() - 1 ) {
        			obj = dataset.get(nowdatasindex);
        			nowdatasindex++;
        		}
        		else {
        			obj = dataset.get(dataset.size() - 1);
        		}
        		
        		// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
        		try {
        			Field[] fields = obj.getClass().getDeclaredFields();
        			
        			// 通过得到的get方法取得相应的值
        			for (int k = 0; k < fields.length; k++) {
        				// 创建单元格
        				cell = row.createCell(k);
        				cell.setCellStyle(cellStyle);// 设置样式
        				// 得到方法名称
        				final Field field = fields[k];
        				AccessController.doPrivileged(new PrivilegedAction<Object>() {
        					@Override
        					public Object run() {
        						field.setAccessible(true);
        						return null;
        					}
        					
        				});
        				
        				// String getMethodName = this.getFieldName(field);
        				// 获取属性值
        				Object value = field.get(obj); 
        				// 判断值的类型后进行强制类型转换
        				String textValue = null;
        				// 判断是否为日期类型
        				if ( value instanceof Date ) {
        					Date date = (Date) value;
        					textValue = new SimpleDateFormat("yyyy-MM-dd").format(date);
        				}
        				else {
        					// 其它数据类型都当作字符串简单处理
        					if ( null == value ) {
        						textValue = "";
        					}
        					else {
        						textValue = String.valueOf(value);
        					}
        				}// end if
        				
        				// 判断属性值的有效性，并做相应处理
        				if ( textValue != null ) {
        					// 用正则表达式判断textValue是否全部由数字组成
        					// Pattern p = Pattern.compile("^\\d+(\\.\\d+)?$");
        					// Matcher matcher = p.matcher(textValue);
        					// if ( matcher.matches() ) {
        					// // 是数字当作double处理
        					// cell.setCellValue(Double.parseDouble(textValue));
        					// }
        					// else {
        					richString = new HSSFRichTextString(textValue);
        					cell.setCellValue(richString);
        					// }
        				}
        			}
        		}
        		catch (Exception e) {
        		}
        		
        		// 判断当前循环完毕后是否处理到集合中最后一个数据
        		if ( nowdatasindex == dataset.size() ) {
        			break;
        		}
        	}
        }
        try {
            workbook.write(out);
        }
        catch (IOException e) {
           e.printStackTrace();
        }
    }
    @SuppressWarnings("rawtypes")
    public void createExl2(String title, String[] headers, List<Map<String, Object>> dataset, OutputStream out) {

        // 生成一个表格
        HSSFSheet sheet = null;
        HSSFRichTextString richString = null;
        // 单元格
        HSSFCell cell = null;
        // 行
        HSSFRow row = null;
        HSSFRichTextString text = null;

        // 声明一个工作薄

        HSSFWorkbook workbook = new HSSFWorkbook();
        
        //设置单元格样式
        HSSFCellStyle style = workbook.createCellStyle();     // 建立新的cell样式  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);       // 左右居中  
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);       
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);   //边框
        style.setFillForegroundColor(new HSSFColor.PALE_BLUE()     
                        .getIndex());     
        style.setFillBackgroundColor(new HSSFColor.PALE_BLUE()     //设置边框颜色
                        .getIndex());     
        style.setFillPattern(HSSFCellStyle.SPARSE_DOTS);   

        // //创建样式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);// 左对齐

        // 建立一个工作薄
        sheet = workbook.createSheet("title");
        // 设置表格默认列宽度为40个字节
        sheet.setDefaultColumnWidth(30);
        // 创建一个DataFormat对象
        HSSFDataFormat format = workbook.createDataFormat();
        // 这样才能真正的控制单元格格式，@就是指文本型
        cellStyle.setDataFormat(format.getFormat("@"));

        // 建立标题
        row = sheet.createRow(this.titleRow);
        // 创建标题
        for (int i = 0; i < headers.length; i++) {
            cell = row.createCell(i);
            text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
            cell.setCellStyle(style); 
        }

//        //如果集合不为为空，写入数据
        if(!Tools.isEmpty(dataset)){
        	// 写入内容
        	// 不能超过最大行数，且当前数据统计量不能超过数据集的大小
        	Object obj = null;
        	for (int j = 0; j < dataset.size(); j++) {
        		
        		// 创建数据行数
        		row = sheet.createRow(j + 1);
        		// 获取一个对象
        		Map<String, Object> map = dataset.get(j);
        		try {
        			
        			for (int k = 0; k < headers.length; k++) {
        				String value = null;
        				if (headers[k].equals("受理编号")) {
        					value =(String) map.get("acceptCode");
        					
						}else if (headers[k].equals("样品名称")) {
							value =(String) map.get("sampleName");
						}
        				else {
							value =(String) map.get(headers[k]);
						}
        				
        					String textValue = value;
        					if ( textValue != null ) {
        						// 创建单元格
                				cell = row.createCell(k);
                				cell.setCellStyle(cellStyle);
            					richString = new HSSFRichTextString(textValue);
            					cell.setCellValue(richString);
            				}
        			}
        		}
        		catch (Exception e) {
        		}
        		
        		// 判断当前循环完毕后是否处理到集合中最后一个数据
        		if ( nowdatasindex == dataset.size() ) {
        			break;
        		}
        	}
        }
        try {
            workbook.write(out);
        }
        catch (IOException e) {
           e.printStackTrace();
        }
    }
    // }

    /**
     * 获取Get方法名称
     * @author zhangdalong
     * @creaetime 2014-12-8
     * @param field 方法
     * @return Get方法名称
     */
    public String getFieldName(Field field) {
        String fieldName = field.getName();
        String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase(Locale.ENGLISH) + fieldName.substring(1);
        return getMethodName;
    }


    /**
     * 计算总共分多少个exl
     * @author zhangdalong
     * @creaetime 2014-12-8
     * @param size 数据集合大小
     * @return exl个数
     */
    public int getExlNum(int size) {
        // 计算工作薄的数量
        int maxPage = size / ExcelTool.maxPageRows == 0 ? 1 : (size % ExcelTool.maxPageRows == 0 ? size
                / ExcelTool.maxPageRows : (size / ExcelTool.maxPageRows) + 1);// 计算最大能分几页
        return maxPage;
    }

    /**
     * 读取xls文件，并把数据封装成map,
     * 目前只支持一个sheet
     * key:遍历的索引
     * value:装数据的map集合k:单元号默认从0开始，v：值
     * @author zhangdalong
     * @creaetime 2014-12-8
     * @param xlsFile xls文件
     * @return 封装数据的map集合
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Map<Integer, Object> readExl(File xlsFile) {
//        Map<Integer, Object> objMap = new HashMap<Integer, Object>();
        Map<Integer, Object> objMap = new LinkedHashMap<Integer, Object>();
        FileInputStream fileInputStream = null;
        try {
            // 创建对Excel工作簿文件的引用
            fileInputStream = new FileInputStream(xlsFile);
            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

            // 得到第一个sheet，并判断有效性
            if ( null != workbook.getSheetAt(0) ) {

                HSSFSheet aSheet = workbook.getSheetAt(0);// 获得一个sheet

                HSSFRow topRow = aSheet.getRow(0);// 得到一行数据，标题行

                int cellNum = topRow.getLastCellNum();// 记录单元数，与标题数相等

                // 计算有多少行数据，从0开始计数
                int iRowNum = aSheet.getLastRowNum();

                // 遍历行数,从第二行开始
                HSSFRow aRow = null;
                HSSFCell aCell = null;
                for (int rowNumOfSheet = 0; rowNumOfSheet <= iRowNum; rowNumOfSheet++) {

                    // 得到一行数据，并判断有效性

                    aRow = aSheet.getRow(rowNumOfSheet);// 得到一行数据

                    // 判断这一行的有效性
                    Map<Integer, Object> valueMap = null;// 存储单元数据
                    Object value = null;// 存储值
                    if ( null != aRow ) {

                        // 遍历一行中的单元数据
                        valueMap = new HashMap();
                        for (int cellNumOfRow = 0; cellNumOfRow < cellNum; cellNumOfRow++) {
                            // 判断单元格是否为空
                            aCell = aRow.getCell(cellNumOfRow);
                            if ( null != aRow.getCell(cellNumOfRow) ) {

                                int cellType = aCell.getCellType();

                                // 判断格式
                                switch (cellType) {
                                    case 0:// Numeric默认double
                                    	//处理日期格式，时间格式
                                    	if(HSSFDateUtil.isCellDateFormatted(aCell)){
                                    		SimpleDateFormat sdf = null;
                                    		if (aCell.getCellStyle().getDataFormat() == HSSFDataFormat  
                                                    .getBuiltinFormat("h:mm")) {  
                                                sdf = new SimpleDateFormat("HH:mm");  
                                            } else {// 日期  
                                                sdf = new SimpleDateFormat("yyyy-MM-dd");  
                                            }  
                                    		 Date date = aCell.getDateCellValue();  
                                             value = sdf.format(date); 
                                    	}else{
                                    		value = Double.valueOf(aCell.getNumericCellValue());
                                    	}
                                        break;
                                    case 1:// String
                                           // value = new
                                           // String(aCell.getStringCellValue());
                                        value = aCell.getStringCellValue();
                                        break;
                                    default:// 其它格式的数据
                                        // value = new
                                        // String(aCell.getStringCellValue());
                                        value = aCell.getStringCellValue();
                                }
                            }
                            else {
                                value = "";
                            } // end if null != aRow.getCell(cellNumOfRow)
                            valueMap.put(cellNumOfRow, value);// 记录每行的值
                        }
                        objMap.put(rowNumOfSheet, valueMap);// 记录sheet中的值
                    }
                    else {
                        objMap.put(rowNumOfSheet, null);// 记录空值
                    }// end if null != aSheet.getRow(rowNumOfSheet)
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if ( null != fileInputStream ) {
                try {
                    fileInputStream.close();
                }
                catch (IOException e) {
                  e.printStackTrace();
                }
            }
        }
        return objMap;
    }

    /**
     * 读取xlsx格式的excel
     * @author zhangdalong
     * @creaetime 2014-12-8
     * @param xlsFile xlsx文件
     * @return 封装数据的map集合
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Map<Integer, Object> readExl07(File xlsFile) {
        Map<Integer, Object> objMap = new HashMap<Integer, Object>();
        FileInputStream fileInputStream = null;
        try {
            // 创建对Excel工作簿文件的引用
            fileInputStream = new FileInputStream(xlsFile);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            // HSSFWorkbook workbook = new HSSFWorkbook();

            // 得到第一个sheet，并判断有效性
            if ( null != workbook.getSheetAt(0) ) {

                XSSFSheet aSheet = workbook.getSheetAt(0);// 获得一个sheet
                XSSFRow topRow = aSheet.getRow(0);// 得到一行数据，标题行

                int cellNum = topRow.getLastCellNum();// 记录单元数，与标题数相等

                // 计算有多少行数据，从0开始计数
                int iRowNum = aSheet.getLastRowNum();

                // 遍历行数,从第二行开始
                XSSFRow aRow = null;
                XSSFCell aCell = null;
                for (int rowNumOfSheet = 0; rowNumOfSheet <= iRowNum; rowNumOfSheet++) {

                    // 得到一行数据，并判断有效性

                    aRow = aSheet.getRow(rowNumOfSheet);// 得到一行数据

                    // 判断这一行的有效性
                    Map<Integer, Object> valueMap = null;// 存储单元数据
                    Object value = null;// 存储值
                    if ( null != aRow ) {

                        // 遍历一行中的单元数据
                        valueMap = new HashMap();
                        for (int cellNumOfRow = 0; cellNumOfRow < cellNum; cellNumOfRow++) {
                            // 判断单元格是否为空
                            aCell = aRow.getCell(cellNumOfRow);
                            if ( null != aRow.getCell(cellNumOfRow) ) {

                                int cellType = aCell.getCellType();

                                // 判断格式
                                switch (cellType) {
                                    case 0:// Numeric默认double
                                    	//处理日期格式，时间格式
                                    	if(HSSFDateUtil.isCellDateFormatted(aCell)){
                                    		SimpleDateFormat sdf = null;
                                    		if (aCell.getCellStyle().getDataFormat() == HSSFDataFormat  
                                                    .getBuiltinFormat("h:mm")) {  
                                                sdf = new SimpleDateFormat("HH:mm");  
                                            } else {// 日期  
                                                sdf = new SimpleDateFormat("yyyy-MM-dd");  
                                            }  
                                    		 Date date = aCell.getDateCellValue();  
                                             value = sdf.format(date); 
                                    	}else{
                                    		value = Double.valueOf(aCell.getNumericCellValue());
                                    	}
                                        // + aCell.getNumericCellValue());
                                        break;
                                    case 1:// String
                                           // value = new
                                           // String(aCell.getStringCellValue());
                                        value = aCell.getStringCellValue();
                                        // String strCell2 = aCell
                                        // .getStringCellValue();
                                        break;
                                    default:// 其它格式的数据
                                        // value = new
                                        // String(aCell.getStringCellValue());
                                        value = aCell.getStringCellValue();
                                        // String strCell3 = aCell
                                        // .getStringCellValue();
                                }
                            }
                            else {
                                value = "";
                            } // end if null != aRow.getCell(cellNumOfRow)
                            valueMap.put(cellNumOfRow, value);// 记录每行的值
                        }
                        objMap.put(rowNumOfSheet, valueMap);// 记录sheet中的值
                    } // end if null != aSheet.getRow(rowNumOfSheet)

                    // 从1开始

                }
            }
        }
        catch (Exception e) {
            // e.printStackTrace();
            // ExceptionAccess.operation(e, "ReadExcelError");
            e.printStackTrace();
        }
        finally {
            if ( null != fileInputStream ) {
                try {
                    fileInputStream.close();
                }
                catch (IOException e) {
                    // ExceptionAccess.operation(e, "");
                   e.printStackTrace();
                }
            }
        }
        return objMap;
    }

    /**
     * 根据文件类型选择解析excel的对象
     * @author zhangdalong
     * @creaetime 2014-12-8
     * @param file 要读取的excel文件
     * @param fileType 文件类型
     * @return Map
     */
    public Map<Integer, Object> getServcievalue(File file, String fileType) {
        ExcelTool tool = new ExcelTool();
        Map<Integer, Object> valusMap = null;
        // 判断文件类型
        if ( "xls".equals(fileType.trim()) ) {
            valusMap = tool.readExl(file);
        }
        else if ( "xlsx".equals(fileType.trim()) ) {
            valusMap = tool.readExl07(file);
        } // end if
          // if ( null != valusMap && 0 != valusMap.size() ) {
        if ( null != valusMap && !valusMap.isEmpty() ) {
            return valusMap;
        }
        return null;
    }

}
