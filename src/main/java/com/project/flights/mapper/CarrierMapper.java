package com.project.flights.mapper;

import com.project.flights.domain.Carrier;
import com.project.flights.domain.dto.CarrierDto;
import com.project.flights.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarrierMapper {


    public Carrier mapToCarrier(final CarrierDto carrierDto) {
        return new Carrier(
                carrierDto.getId(),
                carrierDto.getName());
    }

    public CarrierDto mapToCarrierDto(final Carrier carrier) {
        return new CarrierDto(
                carrier.getId(),
                carrier.getName());
    }

    public List<CarrierDto> mapToCarrierDtoList(List<Carrier> carrierList) {
        return carrierList.stream()
                .map(this::mapToCarrierDto)
                .collect(Collectors.toList());
    }
}
