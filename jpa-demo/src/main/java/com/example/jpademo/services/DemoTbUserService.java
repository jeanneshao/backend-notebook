package com.example.jpademo.services;

import com.example.jpademo.dto.DemoTbUserDTO;
import com.example.jpademo.entity.DemoTbUser;
import com.example.jpademo.repository.DemoTbUserRepository;
import com.example.jpademo.vo.DemoTbUserQueryVO;
import com.example.jpademo.vo.DemoTbUserUpdateVO;
import com.example.jpademo.vo.DemoTbUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DemoTbUserService {

    @Autowired
    private DemoTbUserRepository demoTbUserRepository;

    public String save(DemoTbUserVO vO) {
        DemoTbUser bean = new DemoTbUser();
        BeanUtils.copyProperties(vO, bean);
        bean = demoTbUserRepository.save(bean);
        return bean.getId();
    }

    public void delete(String id) {
        demoTbUserRepository.deleteById(id);
    }

    public void update(String id, DemoTbUserUpdateVO vO) {
        DemoTbUser bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        demoTbUserRepository.save(bean);
    }

    public DemoTbUserDTO getById(String id) {
        DemoTbUser original = requireOne(id);
        return toDTO(original);
    }

    public Page<DemoTbUserDTO> query(DemoTbUserQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DemoTbUserDTO toDTO(DemoTbUser original) {
        DemoTbUserDTO bean = new DemoTbUserDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private DemoTbUser requireOne(String id) {
        return demoTbUserRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
