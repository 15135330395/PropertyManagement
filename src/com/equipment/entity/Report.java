package com.equipment.entity;/*
 * @author :张
 * Date  : 2019/3/26
 * @Description: Report
 */


import java.util.Date;

public class Report {

    private int reportId;
    private String reportTitle;
    private Date reportDate;
    private String reportingUnit;
    private String reportContent;
    private Double reportCost;
    private String reportName;
    private int reportPhone;
    private String instructions;
    private String executiveResult;

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportingUnit() {
        return reportingUnit;
    }

    public void setReportingUnit(String reportingUnit) {
        this.reportingUnit = reportingUnit;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Double getReportCost() {
        return reportCost;
    }

    public void setReportCost(Double reportCost) {
        this.reportCost = reportCost;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public int getReportPhone() {
        return reportPhone;
    }

    public void setReportPhone(int reportPhone) {
        this.reportPhone = reportPhone;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getExecutiveResult() {
        return executiveResult;
    }

    public void setExecutiveResult(String executiveResult) {
        this.executiveResult = executiveResult;
    }

    public Report(int reportId, String reportTitle, Date reportDate, String reportingUnit, String reportContent, Double reportCost,
                  String reportName, int reportPhone, String instructions, String executiveResult) {
        this.reportId = reportId;
        this.reportTitle = reportTitle;
        this.reportDate = reportDate;
        this.reportingUnit = reportingUnit;
        this.reportContent = reportContent;
        this.reportCost = reportCost;
        this.reportName = reportName;
        this.reportPhone = reportPhone;
        this.instructions = instructions;
        this.executiveResult = executiveResult;
    }


    public Report() {
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportId=" + reportId +
                ", reportTitle='" + reportTitle + '\'' +
                ", reportDate=" + reportDate +
                ", reportingUnit='" + reportingUnit + '\'' +
                ", reportContent='" + reportContent + '\'' +
                ", reportCost=" + reportCost +
                ", reportName='" + reportName + '\'' +
                ", reportPhone=" + reportPhone +
                ", instructions='" + instructions + '\'' +
                ", executiveResult='" + executiveResult + '\'' +
                '}';
    }

}
