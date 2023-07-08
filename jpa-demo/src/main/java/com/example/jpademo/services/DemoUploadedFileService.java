package com.example.jpademo.services;

import com.example.jpademo.dto.DemoUploadedFileDTO;
import com.example.jpademo.entity.DemoUploadedFile;
import com.example.jpademo.repository.DemoUploadedFileRepository;
import com.example.jpademo.vo.DemoUploadedFileQueryVO;
import com.example.jpademo.vo.DemoUploadedFileUpdateVO;
import com.example.jpademo.vo.DemoUploadedFileVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DemoUploadedFileService {

    @Autowired
    private DemoUploadedFileRepository demoUploadedFileRepository;

    public Long save(DemoUploadedFileVO vO) {
        DemoUploadedFile bean = new DemoUploadedFile();
        BeanUtils.copyProperties(vO, bean);
        bean = demoUploadedFileRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        demoUploadedFileRepository.deleteById(id);
    }

    public void update(Long id, DemoUploadedFileUpdateVO vO) {
        DemoUploadedFile bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        demoUploadedFileRepository.save(bean);
    }

    public DemoUploadedFileDTO getById(Long id) {
        DemoUploadedFile original = requireOne(id);
        return toDTO(original);
    }

    public Page<DemoUploadedFileDTO> query(DemoUploadedFileQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DemoUploadedFileDTO toDTO(DemoUploadedFile original) {
        DemoUploadedFileDTO bean = new DemoUploadedFileDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private DemoUploadedFile requireOne(Long id) {
        return demoUploadedFileRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
