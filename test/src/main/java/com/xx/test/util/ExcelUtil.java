package com.xx.test.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;


@Slf4j
public class ExcelUtil {

    /**
     * 生成excel工具类
     *
     * @param sheetTitle 页签名字
     * @param showTitle  是否显示标题
     * @param title      表头数组
     * @param list       数据数组
     * @return
     */
    public static byte[] export(String sheetTitle, boolean showTitle, String[] title, List<Object> list) {
        //创建excel表
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(sheetTitle);
        //设置默认行宽
        sheet.setDefaultColumnWidth(20);
        //表头样式（加粗，水平居中，垂直居中）
        HSSFCellStyle cellStyle = wb.createCellStyle();
        //水平居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置边框样式
        //下边框
//        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//        //左边框
//        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//        //上边框
//        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
//        //右边框
//        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        HSSFFont fontStyle = wb.createFont();
        //fontStyle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        cellStyle.setFont(fontStyle);
        //标题样式（加粗，垂直居中）
        HSSFCellStyle cellStyle2 = wb.createCellStyle();
        //垂直居中
        cellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle2.setFont(fontStyle);
        //设置边框样式
        //下边框
//        cellStyle2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//        //左边框
//        cellStyle2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//        //上边框
//        cellStyle2.setBorderTop(HSSFCellStyle.BORDER_THIN);
//        //右边框
//        cellStyle2.setBorderRight(HSSFCellStyle.BORDER_THIN);

        //字段样式（垂直居中）
        HSSFCellStyle cellStyle3 = wb.createCellStyle();
        //垂直居中
        cellStyle3.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置边框样式
        //下边框
//        cellStyle3.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//        //左边框
//        cellStyle3.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//        //上边框
//        cellStyle3.setBorderTop(HSSFCellStyle.BORDER_THIN);
//        //右边框
//        cellStyle3.setBorderRight(HSSFCellStyle.BORDER_THIN);
        int statRow = 0;
        if (showTitle) {
            //创建表头
            HSSFRow row = sheet.createRow(0);
            //行高
            row.setHeightInPoints(20);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue(sheetTitle);
            cell.setCellStyle(cellStyle);
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, (title.length - 1)));
            statRow = 1;
        }
        //创建标题
        HSSFRow rowTitle = sheet.createRow(statRow);
        rowTitle.setHeightInPoints(20);

        HSSFCell hc;
        for (int i = 0; i < title.length; i++) {
            hc = rowTitle.createCell(i);
            hc.setCellValue(title[i]);
            hc.setCellStyle(cellStyle2);
        }
        byte result[] = null;
        ByteArrayOutputStream out = null;
        try {
            //创建表格数据
            Field[] fields;
            //标头行+1
            int i = statRow + 1;
            for (Object obj : list) {
                fields = obj.getClass().getDeclaredFields();
                HSSFRow rowBody = sheet.createRow(i);
                rowBody.setHeightInPoints(20);
                int j = 0;
                for (Field f : fields) {
                    String name = f.getName();
                    if (name.equals("serialVersionUID")) {
                        continue;
                    }
                    f.setAccessible(true);
                    Object va = f.get(obj);
                    if (null == va) {
                        va = "";
                    }
                    hc = rowBody.createCell(j);
                    hc.setCellValue(va.toString());
                    hc.setCellStyle(cellStyle3);
                    j++;
                }
                i++;
            }
            out = new ByteArrayOutputStream();
            wb.write(out);
            result = out.toByteArray();
        } catch (Exception ex) {
            log.debug("异常信息1:{}--{}", ExcelUtil.class.getName(), ex);
        } finally {
            try {
                if (null != out) {
                    out.close();
                }
            } catch (IOException ex) {
                log.debug("异常信息2:{}--{}", ExcelUtil.class.getName(), ex);
            } finally {
                try {
                    wb.close();
                } catch (IOException ex) {
                    log.debug("异常信息3:{}--{}", ExcelUtil.class.getName(), ex);
                }
            }
        }
        return result;
    }
}
