package com.example.bookandmovie.Service;

import com.example.bookandmovie.Entity.Report;

import java.util.List;

public interface ReportService {
    public void addReport(Report report);
    public List<Report> listReport();
    public void solveReport(int mid, int op);
}
