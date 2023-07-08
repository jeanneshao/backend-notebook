package com.example.jpademo.services;

import com.example.jpademo.dto.DemoLobDemoDTO;
import com.example.jpademo.entity.DemoLobDemo;
import com.example.jpademo.repository.DemoLobDemoRepository;
import com.example.jpademo.vo.DemoLobDemoQueryVO;
import com.example.jpademo.vo.DemoLobDemoUpdateVO;
import com.example.jpademo.vo.DemoLobDemoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DemoLobDemoService {

    @Autowired
    private DemoLobDemoRepository demoLobDemoRepository;

    public Long save(DemoLobDemoVO vO) {
        DemoLobDemo bean = new DemoLobDemo();
        BeanUtils.copyProperties(vO, bean);
        bean = demoLobDemoRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        demoLobDemoRepository.deleteById(id);
    }

    public void update(Long id, DemoLobDemoUpdateVO vO) {
        DemoLobDemo bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        demoLobDemoRepository.save(bean);
    }

    public DemoLobDemoDTO getById(Long id) {
        DemoLobDemo original = requireOne(id);
        return toDTO(original);
    }

    public Page<DemoLobDemoDTO> query(DemoLobDemoQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DemoLobDemoDTO toDTO(DemoLobDemo original) {
        DemoLobDemoDTO bean = new DemoLobDemoDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private DemoLobDemo requireOne(Long id) {
        return demoLobDemoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
