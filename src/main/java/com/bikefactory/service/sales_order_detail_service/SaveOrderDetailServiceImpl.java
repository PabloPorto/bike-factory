package com.bikefactory.service.sales_order_detail_service;

import com.bikefactory.dto.SaveOrUpdateSalesOrderDetailDto;
import com.bikefactory.exception.SalesOrderDetailNotFoundException;
import com.bikefactory.model.SalesOrderDetail;
import com.bikefactory.repository.SalesOrderDetailRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

@Service
public class SaveOrderDetailServiceImpl implements SaveOrderDetailService{

    @Autowired
    private SalesOrderDetailRepository salesOrderDetailRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(SaveOrUpdateSalesOrderDetailDto saveOrUpdateSalesOrderDetailDto) {
        SalesOrderDetail lastRow = salesOrderDetailRepository.findFirstByOrderByRowGuideDesc()
                .orElseThrow(SalesOrderDetailNotFoundException::new);
        String rowGuide = UUID.randomUUID().toString();

        SalesOrderDetail salesOrderDetail = new SalesOrderDetail();
        salesOrderDetail.setSalesOrderDetailId(lastRow.getSalesOrderDetailId()+1);
        salesOrderDetail.setSalesOrderId(lastRow.getSalesOrderId()+1);
        salesOrderDetail.setModifiedDate(Date.from(Instant.now()));
        salesOrderDetail.setRowGuide(rowGuide);

        modelMapper.map(saveOrUpdateSalesOrderDetailDto,rowGuide);
        salesOrderDetailRepository.save(salesOrderDetail);
    }
}
