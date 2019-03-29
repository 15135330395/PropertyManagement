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

    public void setReport_id(int reportId) {
        this.reportId = reportId;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReport_title(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReport_date(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportingUnit() {
        return reportingUnit;
    }

    public void setReporting_unit(String reportingUnit) {
        this.reportingUnit = reportingUnit;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReport_content(String reportContent) {
        this.reportContent = reportContent;
    }

    public Double getReportCost() {
        return reportCost;
    }

    public void setReport_cost(Double reportCost) {
        this.reportCost = reportCost;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReport_name(String reportName) {
        this.reportName = reportName;
    }

    public int getReportPhone() {
        return reportPhone;
    }

    public void setReport_phone(int reportPhone) {
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

    public void setExecutive_result(String executiveResult) {
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
