package com.sporty.formula1bet.mapper;

import com.sporty.formula1bet.model.Driver;
import com.sporty.formula1bet.service.proxy.dto.DriverDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DriverMapper {

    List<Driver> toDrivers(List<DriverDto> driverDtos);

    Driver toDriver(DriverDto driverDto);
}
