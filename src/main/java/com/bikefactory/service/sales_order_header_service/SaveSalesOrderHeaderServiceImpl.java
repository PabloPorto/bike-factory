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
import java.util.UUID;

@Service
public class SaveSalesOrderHeaderServiceImpl implements SaveSalesOrderHeaderService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SalesOrderHeaderRepository salesOrderHeaderRepository;

    @Override
    public void insertNewSalesOrderHeader(SaveOrUpdateSalesOrderHeaderDto saveOrUpdateSalesOrderHeaderDto) throws ParseException {
        SalesOrderHeader lastInserted = salesOrderHeaderRepository.findFirstByOrderBySalesOrderIdDesc()
                .orElseThrow(SalesOrderHeaderNotFoundException::new);
        String rowGuide = UUID.randomUUID().toString();
        String datePatter = "yyyy-MM-dd";

        SalesOrderHeader salesOrderHeader = new SalesOrderHeader();
        salesOrderHeader.setSalesOrderId(lastInserted.getSalesOrderId()+1);
        salesOrderHeader.setOrderDate(new SimpleDateFormat(datePatter).parse(saveOrUpdateSalesOrderHeaderDto.getOrderDate()));
        salesOrderHeader.setDueDate(new SimpleDateFormat(datePatter).parse(saveOrUpdateSalesOrderHeaderDto.getDueDate()));
        salesOrderHeader.setShipDate(new SimpleDateFormat(datePatter).parse(saveOrUpdateSalesOrderHeaderDto.getShipDate()));
        salesOrderHeader.setModifiedDate(Date.from(Instant.now()));
        salesOrderHeader.setRowGuide(rowGuide);

        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(saveOrUpdateSalesOrderHeaderDto,salesOrderHeader);
        salesOrderHeaderRepository.save(salesOrderHeader);

    }
}
