package com.stockManagement.sampleProject.service;

import com.stockManagement.sampleProject.dto.DtoOrder;
import com.stockManagement.sampleProject.dto.DtoOrderDetails;
import com.stockManagement.sampleProject.entity.Order;
import com.stockManagement.sampleProject.entity.OrderDetails;
import com.stockManagement.sampleProject.repository.*;
import com.stockManagement.sampleProject.service.serviceInterfaces.ServiceOrderIMPL;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ServiceOrder implements ServiceOrderIMPL {

    @Autowired
    private RepoAdmin repoAdmin;
    @Autowired
    private RepoCustomer repoCustomer;
    @Autowired
    private RepoOrder repoOrder;
    @Autowired
    private RepoOrderDetails repoOrderDetails;
    @Autowired
    private RepoItem repoItem;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public String addOrder(DtoOrder dtoOrder) {

        Order order = new Order(
           repoAdmin.getById(dtoOrder.getAdmin()),
           repoCustomer.getById(dtoOrder.getCustomer()),
           dtoOrder.isOrderActiveState(),
           dtoOrder.getOrderDate(),
           dtoOrder.getOrderTotal()
        );
        repoOrder.save(order);

        if (repoOrder.existsById(order.getOrderId())){

            List<OrderDetails> orderDetails =modelMapper.map(dtoOrder.getOrderDetails(),new TypeToken<List<OrderDetails>>(){}.getType());

            for(int i = 0; i<orderDetails.size(); i++){
                orderDetails.get(i).setOrders(order);
                orderDetails.get(i).setItems(repoItem.getById(dtoOrder.getOrderDetails().get(i).getItems()));
            }
            if (orderDetails.size()>0){
                repoOrderDetails.saveAll(orderDetails);
            }
        }
        return "Save Order !";
    }
}
