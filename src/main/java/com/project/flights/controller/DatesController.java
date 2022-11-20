package com.project.flights.controller;

import com.project.flights.domain.Dates;
import com.project.flights.domain.dto.DatesDto;
import com.project.flights.exceptions.AllNotFoundException;
import com.project.flights.mapper.DatesMapper;
import com.project.flights.service.DbDatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/dates")
public class DatesController {

    private final DbDatesService dbDatesService;
    private final DatesMapper datesMapper;

    @GetMapping
    public ResponseEntity<List<DatesDto>> getDates() {
        List<Dates> dates = dbDatesService.getAllDates();
        return ResponseEntity.ok(datesMapper.mapToDatesDtoList(dates));
    }

    @GetMapping(value = "{datesId}")
    public ResponseEntity<DatesDto> getDates(@PathVariable Long datesId) throws AllNotFoundException {
        return ResponseEntity.ok(datesMapper.mapToDatesDto(dbDatesService.getDates(datesId)));
    }

    @PostMapping
    public ResponseEntity<Void> createDates(@RequestBody DatesDto datesDto) {
        Dates dates = datesMapper.mapToDates(datesDto);
        dbDatesService.saveDates(dates);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{datesId}")
    public ResponseEntity<Void> deleteDates(@PathVariable Long datesId) {
        dbDatesService.deleteDates(datesId);
        return ResponseEntity.ok().build();
    }
}
