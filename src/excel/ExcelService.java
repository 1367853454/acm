//package excel;
//
//import com.ebaolife.bedrock.dto.ServiceException;
//import com.hcrm.mall.goods.dto.ProductStockRequest;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.stereotype.Service;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.math.BigDecimal;
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@Service
//@Slf4j
//public class ExcelService {
//
//    /**
//     * <!--读取excel文件-->
//     *         <dependency>
//     *             <groupId>org.apache.poi</groupId>
//     *             <artifactId>poi</artifactId>
//     *             <version>3.17</version>
//     *         </dependency>
//     *         <dependency>
//     *             <groupId>org.apache.poi</groupId>
//     *             <artifactId>poi-ooxml</artifactId>
//     *             <version>3.17</version>
//     *         </dependency>
//     * <!--其实只能支持.xlsx-->
//     */
//    /**
//     * 判断Excel文件后缀名，生成不同的Workbook
//     */
//    public Workbook createWorkbook(InputStream is, String excelFilename) throws IOException {
//        if(excelFilename.endsWith(".xls")) {
//            return new HSSFWorkbook(is);
//        } else if(excelFilename.endsWith(".xlsx")) {
//            return new XSSFWorkbook(is);
//        } else {
//            throw new ServiceException("错误的文件类型");
//        }
//    }
//
//    /**
//     * 根据sheet索引号获取对应的sheet
//     */
//    private Sheet getSheet(Workbook workbook, int sheetIndex) {
//        return workbook.getSheetAt(sheetIndex);
//    }
//
//    /**
//     * 获取String类型单元格数据
//     */
//    private String getStringCellValue(Row row, int cellIndex) {
//        Cell cell = row.getCell(cellIndex);
//        cell.setCellType(Cell.CELL_TYPE_STRING);
//        return cell.getStringCellValue();
//    }
//
//    /**
//     * 获取商品erp以及库存
//     */
//    public List<ProductStockRequest.ProductItem> getProductStockItem (InputStream is, String excelFilename) {
//        List<ProductStockRequest.ProductItem> items = new ArrayList<>();
//
//        try {
//            //创建工作簿
//            Workbook workbook = this.createWorkbook(is, excelFilename);
//            //创建工作表sheet
//            Sheet sheet = this.getSheet(workbook, 0);
//            //获取sheet中的数据的行数
//            int rows = sheet.getPhysicalNumberOfRows();
//
//            for(int i = 1; i < rows; i++) {//第一行为标题栏，从第二行开始取数据
//                ProductStockRequest.ProductItem item = new ProductStockRequest.ProductItem();
//
//                Row row = sheet.getRow(i);
//                //第一列为商品erpId
//                if(null != row.getCell(0)) {
//                    item.setErpProductId(getStringCellValue(row, 0));
//                    //第二列为商品库存
//                    if(null != row.getCell(1)) {
//                        try {
//                            item.setStockNum(new BigDecimal(getStringCellValue(row, 1)).setScale(0, BigDecimal.ROUND_DOWN).intValue());
//                            items.add(item);
//                        } catch (Exception e) {
//                            log.error("erpId为" + item.getErpProductId() + "的商品库存有误");
//                        }
//                    }
//                }
//            }
//        } catch (Exception e) {
//            throw new ServiceException(e.getMessage());
//        } finally {
//            try {
//                is.close();
//            } catch (Exception e) {
//                log.error(e.toString());
//            }
//        }
//
//        return items;
//    }
//
//    public List<String> genBarCodeList(InputStream is, String excelFilename) {
//        List<String> barCodes = new ArrayList<>();
//        try {
//            //创建工作簿
//            Workbook workbook = this.createWorkbook(is, excelFilename);
//            //创建工作表sheet
//            Sheet sheet = this.getSheet(workbook, 0);
//            //获取sheet中的数据的行数
//            int rows = sheet.getPhysicalNumberOfRows();
//            //第一行为标题栏，从第二行开始取数据
//            for(int i = 1; i < rows; i++) {
//                Row row = sheet.getRow(i);
//                //第一列为条形码
//                if(null == row.getCell(0)) {
//                    continue;
//                }
//                barCodes.add(getStringCellValue(row, 0));
//            }
//        } catch (Exception e) {
//            throw new ServiceException(e.getMessage());
//        } finally {
//            try {
//                is.close();
//            } catch (Exception e) {
//                log.error(e.toString());
//            }
//        }
//        return barCodes;
//    }
//
//    byte[] bytes = excelService.writeExcel(storeProductMap,storeDtoList);
//    HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentDispositionFormData("attachment",
//                new String((ExcelService.EXPORT_STORE_PRODUCT_FILE_NAME).getBytes(StandardCharsets.UTF_8),
//    StandardCharsets.ISO_8859_1));
//        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//
//        return new ResponseEntity(bytes, httpHeaders, HttpStatus.CREATED);
//
//    public byte[] writeExcel(Map<String, List<ExportProductDto>> map, List<StoreDto> storeDtoList) {
//
//        HSSFWorkbook wb = new HSSFWorkbook();
//
//        storeDtoList.forEach(k -> {
//            HSSFSheet sheet = wb.createSheet(k.getStoreName());
//
//            HSSFCellStyle style = wb.createCellStyle();
//            HSSFFont font = wb.createFont();
//            font.setColor(HSSFColor.RED.index);
//            style.setFont(font);
//
//            HSSFRow row = sheet.createRow(0);
//            row.createCell(0).setCellValue("序号");
//            row.createCell(1).setCellValue("条形码*");
//            row.createCell(2).setCellValue("商品名称");
//            row.createCell(3).setCellValue("库存*");
//            row.createCell(4).setCellValue("售价*");
//            row.createCell(5).setCellValue("所属类目*");
//            row.createCell(6).setCellValue("标签");
//            row.createCell(7).setCellValue("助记码");
//            row.createCell(8).setCellValue("erp商品编码");
//
//            row.getCell(1).setCellStyle(style);
//            row.getCell(3).setCellStyle(style);
//            row.getCell(4).setCellStyle(style);
//
//            HSSFDataFormat format = wb.createDataFormat();
//            style = wb.createCellStyle();
//            style.setDataFormat(format.getFormat("0.00"));
//            int rowIndex = 0;
//            for (ExportProductDto dto : map.get(k.getId())) {
//                rowIndex ++;
//                row = sheet.createRow(rowIndex);
//                row.createCell(0).setCellValue(rowIndex);
//                row.createCell(1).setCellValue(dto.getBarCode());
//                row.createCell(2).setCellValue(dto.getProductName());
//                row.createCell(3).setCellValue(dto.getStockNum().intValue());
//                row.createCell(4).setCellValue(dto.getSalePrice().floatValue());
//                row.createCell(5).setCellValue(dto.getCategory());
//                row.createCell(6).setCellValue(dto.getLabel());
//                row.createCell(7).setCellValue(dto.getMnemonicCode());
//                row.createCell(8).setCellValue(dto.getErpProductId());
//
//                row.getCell(4).setCellStyle(style);
//            }
//
//            for(int i=0; i<9; i++) {
//                sheet.autoSizeColumn(i);
//            }
//        });
//
//        try {
//            ByteArrayOutputStream os = new ByteArrayOutputStream();
//            wb.write(os);
//            os.flush();
//            os.close();
//            return os.toByteArray();
//        } catch (Exception e) {
//            log.error(e.toString());
//            return null;
//        }
//    }
//}
