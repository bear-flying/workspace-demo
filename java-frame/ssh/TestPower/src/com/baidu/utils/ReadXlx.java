package com.baidu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.baidu.entity.User;


public class ReadXlx {

	public static List<User> readXls(InputStream is) throws IOException, Exception { 
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is); 
        User bean = null; 
        List<User> list = new ArrayList<User>(); 
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        // 循环工作表Sheet
      
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0); 
             
            // 循环行Row 
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) { 
                HSSFRow hssfRow = hssfSheet.getRow(rowNum); 
                if (hssfRow == null) { 
                    continue; 
                } 
                bean = new User(); 
                

             // 用户名
                HSSFCell username = hssfRow.getCell(0); 
                if (username == null) { 
                    continue; 
                } 
                bean.setName(getValue(username)); 
             // 密码
                HSSFCell password = hssfRow.getCell(1); 
                if (password == null) { 
                    continue; 
                } 
                bean.setPassword(getValue(password));
             // 年龄
                HSSFCell age = hssfRow.getCell(2); 
                if (age == null) { 
                    continue; 
                }
                Float age1 = Float.valueOf(getValue(age));
                int age2 = (int) Math.ceil(age1);
                bean.setAge(age2);
          
                
                HSSFCell birthday = hssfRow.getCell(3); 
                if (birthday == null) { 
                	continue; 
                }
                
                String v = getValue(birthday);
                Date parse = df.parse(v);
               //bean.setBirthday(parse);
               
               
                
            
                
                list.add(bean); 
            } 
         
        return list; 
    } 
  
    /** 
     * 得到Excel表中的值 
     *  
     * @param hssfCell 
     *            Excel中的每一个格子 
     * @return Excel中每一个格子中的值 
     */
    @SuppressWarnings("static-access") 
    private static String getValue(HSSFCell hssfCell) { 
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) { 
            // 返回布尔类型的值 
            return String.valueOf(hssfCell.getBooleanCellValue()); 
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) { 
            // 返回数值类型的值 
            return String.valueOf(hssfCell.getNumericCellValue()); 
        } else { 
            // 返回字符串类型的值 
            return String.valueOf(hssfCell.getStringCellValue()); 
        } 
    } 
  
}