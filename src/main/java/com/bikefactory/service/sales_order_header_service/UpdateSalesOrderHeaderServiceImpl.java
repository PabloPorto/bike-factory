package com.bikefactory.service.sales_order_header_service;

import com.bikefactory.dto.SaveOrUpdateSalesOrderHeaderDto;
import com.bikefactory.exception.SalesOrderHeaderNotFoundException;
import com.bikefactory.model.SalesOrderHeader;
import com.bikefactory.repository.SalesOrderHeaderRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;

@Service
public class UpdateSalesOrderHeaderServiceImpl implements UpdateSalesOrderHeaderService {

    @Autowired
    private SalesOrderHeaderRepository salesOrderHeaderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void update (SaveOrUpdateSalesOrderHeaderDto saveOrUpdateSalesOrderHeaderDto, Integer orderId) throws ParseException {
        SalesOrderHeader salesOrderHeader = salesOrderHeaderRepository.findById(orderId)
                .orElseThrow(SalesOrderHeaderNotFoundException::new);
        String datePatter = "yyyy-MM-dd";

        salesOrderHeader.setOrderDate(new SimpleDateFormat(datePatter).parse(saveOrUpdateSalesOrderHeaderDto.getOrderDate()));
        salesOrderHeader.setDueDate(new SimpleDateFormat(datePatter).parse(saveOrUpdateSalesOrderHeaderDto.getDueDate()));
        salesOrderHeader.setShipDate(new SimpleDateFormat(datePatter).parse(saveOrUpdateSalesOrderHeaderDto.getShipDate()));
        salesOrderHeader.setModifiedDate(Date.from(Instant.now()));

        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(saveOrUpdateSalesOrderHeaderDto,salesOrderHeader);
        salesOrderHeaderRepository.save(salesOrderHeader);
    }
}
