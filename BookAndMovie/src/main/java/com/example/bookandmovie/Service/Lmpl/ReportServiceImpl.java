package com.example.bookandmovie.Service.Lmpl;

import com.example.bookandmovie.Dao.ReportDao;
import com.example.bookandmovie.Entity.Report;
import com.example.bookandmovie.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportDao reportDao;
    @Override
    public void addReport(Report report){reportDao.addReport(report);}
    @Override
    public List<Report> listReport(){return reportDao.listReport();}
    @Override
    public void solveReport(int mid, int op){reportDao.solveReport(mid, op);}
}
