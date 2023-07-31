package cn.edu.guet.insuranceteam.bean;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

import java.math.BigDecimal;

/**
 * excel导出模板
 * @author lgl
 */
public class InsuranceSummaryModel {

    @ExcelProperty(value = "地州")
    @ColumnWidth(14)
    private String prefecture;

    @ExcelProperty(value = "总数量")
    @ColumnWidth(10)
    private int total;

    @ExcelProperty(value = "1月")
    @ColumnWidth(7)
    private int january;

    @ExcelProperty(value = "2月")
    @ColumnWidth(7)
    private int february;

    @ExcelProperty(value = "3月")
    @ColumnWidth(7)
    private int march;

    @ExcelProperty(value = "4月")
    @ColumnWidth(7)
    private int april;

    @ExcelProperty(value = "5月")
    @ColumnWidth(7)
    private int may;

    @ExcelProperty(value = "6月")
    @ColumnWidth(7)
    private int june;

    @ExcelProperty(value = "7月")
    @ColumnWidth(7)
    private int july;

    @ExcelProperty(value = "8月")
    @ColumnWidth(7)
    private int august;

    @ExcelProperty(value = "9月")
    @ColumnWidth(7)
    private int september;

    @ExcelProperty(value = "10月")
    @ColumnWidth(7)
    private int october;

    @ExcelProperty(value = "11月")
    @ColumnWidth(7)
    private int november;

    @ExcelProperty(value = "12月")
    @ColumnWidth(7)
    private int december;

    @ExcelProperty(value = "总金额（元）")
    @ColumnWidth(20)
    private BigDecimal totalAmount;



    public String getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getJanuary() {
        return january;
    }

    public void setJanuary(int january) {
        this.january = january;
    }

    public int getFebruary() {
        return february;
    }

    public void setFebruary(int february) {
        this.february = february;
    }

    public int getMarch() {
        return march;
    }

    public void setMarch(int march) {
        this.march = march;
    }

    public int getApril() {
        return april;
    }

    public void setApril(int april) {
        this.april = april;
    }

    public int getMay() {
        return may;
    }

    public void setMay(int may) {
        this.may = may;
    }

    public int getJune() {
        return june;
    }

    public void setJune(int june) {
        this.june = june;
    }

    public int getJuly() {
        return july;
    }

    public void setJuly(int july) {
        this.july = july;
    }

    public int getAugust() {
        return august;
    }

    public void setAugust(int august) {
        this.august = august;
    }

    public int getSeptember() {
        return september;
    }

    public void setSeptember(int september) {
        this.september = september;
    }

    public int getOctober() {
        return october;
    }

    public void setOctober(int october) {
        this.october = october;
    }

    public int getNovember() {
        return november;
    }

    public void setNovember(int november) {
        this.november = november;
    }

    public int getDecember() {
        return december;
    }

    public void setDecember(int december) {
        this.december = december;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
