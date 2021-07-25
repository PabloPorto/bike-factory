package com.bikefactory.service.sales_order_detail_service;

import com.bikefactory.dto.SaveOrUpdateSalesOrderDetailDto;
import com.bikefactory.exception.SalesOrderDetailNotFoundException;
import com.bikefactory.model.SalesOrderDetail;
import com.bikefactory.repository.SalesOrderDetailRepository;
import com.bikefactory.util.SalesOrderDetailRelationshipId;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;

@Service
public class UpdateOrderDetailServiceImpl implements UpdateOrderDetailService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SalesOrderDetailRepository salesOrderDetailRepository;


    @Override
    public void updateOrderDetail(SaveOrUpdateSalesOrderDetailDto saveOrUpdateSalesOrderDetailDto,
                                  Integer orderId, Integer orderDetailId) {
        SalesOrderDetailRelationshipId id = new SalesOrderDetailRelationshipId(orderId,orderDetailId);
        SalesOrderDetail salesOrderDetail = salesOrderDetailRepository.findById(id)
                .orElseThrow(SalesOrderDetailNotFoundException::new);

        salesOrderDetail.setModifiedDate(Date.from(Instant.now()));
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(saveOrUpdateSalesOrderDetailDto,salesOrderDetail);

        salesOrderDetailRepository.save(salesOrderDetail);
    }
}
