package org.severstal.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.severstal.dto.ReportDto;
import org.severstal.service.ReportService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private static final Logger log = LogManager.getLogger(ReportController.class);

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public List<ReportDto> report(
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate from,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate to
    ) {
        log.info("Запрос отчёта: from={}, to={}", from, to);
        List<ReportDto> result = reportService.getReport(from, to);
        log.info("Результат отчёта size={}", result.size());
        return result;
    }
}
