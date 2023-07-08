package com.example.jpademo.services;

import com.example.jpademo.dto.DemoCustomerDTO;
import com.example.jpademo.entity.DemoCustomer;
import com.example.jpademo.repository.DemoCustomerRepository;
import com.example.jpademo.vo.DemoCustomerQueryVO;
import com.example.jpademo.vo.DemoCustomerUpdateVO;
import com.example.jpademo.vo.DemoCustomerVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DemoCustomerService {

    @Autowired
    private DemoCustomerRepository demoCustomerRepository;

    public String save(DemoCustomerVO vO) {
        DemoCustomer bean = new DemoCustomer();
        BeanUtils.copyProperties(vO, bean);
        bean = demoCustomerRepository.save(bean);
        return bean.getId();
    }

    public void delete(String id) {
        demoCustomerRepository.deleteById(id);
    }

    public void update(String id, DemoCustomerUpdateVO vO) {
        DemoCustomer bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        demoCustomerRepository.save(bean);
    }

    public DemoCustomerDTO getById(String id) {
        DemoCustomer original = requireOne(id);
        return toDTO(original);
    }

    public Page<DemoCustomerDTO> query(DemoCustomerQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DemoCustomerDTO toDTO(DemoCustomer original) {
        DemoCustomerDTO bean = new DemoCustomerDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private DemoCustomer requireOne(String id) {
        return demoCustomerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
