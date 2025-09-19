package com.sporty.formula1bet.mapper;

import com.sporty.formula1bet.model.Driver;
import com.sporty.formula1bet.service.OpenF1.dto.DriverDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DriverMapper {

    Driver toDriver(DriverDto driverDto);

    List<Driver> toDrivers(List<DriverDto> driverDtos);
}
