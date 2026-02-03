package org.severstal.service;

import org.apache.logging.log4j.LogManager;
import org.severstal.dto.ReportDto;
import org.severstal.repository.DeliveryItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.Logger;

@Service
public class ReportService {
    private static final Logger log = LogManager.getLogger(ReportService.class);

    private final DeliveryItemRepository itemRepository;

    public ReportService(DeliveryItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ReportDto> getReport(LocalDate from, LocalDate to) {
        log.debug("Выполняем запрос в репозиторий: from={}, to={}", from, to);

        List<ReportDto> report = itemRepository.findReport(from, to);

        log.info("Отчёт сформирован. Строк: {}", report.size());
        return report;
    }
}
