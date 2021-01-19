package com.twitter.demo.modules.core;

import com.nila.masterclass.modules.core.exception.Error;
import com.nila.masterclass.modules.core.exception.ErrorStatus;
import com.nila.masterclass.modules.core.exception.FieldErrorBuilder;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

public class BaseController<T extends BaseEntity> {

    protected BaseService<T> service;

    public BaseController(BaseService<T> service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<T> create(@Valid @RequestBody T t, BindingResult result) {
        if (result.hasErrors())
            throw new Error(ErrorStatus.VALIDATION, t.getClass().getSimpleName(), "VALIDATION ERROR", FieldErrorBuilder.map(result.getFieldErrors()));
        T r = service.create(t);
        return ResponseEntity.ok(r);
    }

    @PostMapping("/sequences")
    public ResponseEntity<Void> sequence(@RequestBody Map<Long, Integer> map) {
        service.sequence(map);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> find(@PathVariable long id) {
        T t = service.find(id);
        if (t == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(t);
    }

    @GetMapping
    public ResponseEntity<Page<T>> find(Pageable pageable) {
        Page<T> ts = service.find(pageable);
        return ResponseEntity.ok(ts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable long id, @Valid @RequestBody T t, BindingResult result) {
        if (result.hasErrors())
            throw new Error(ErrorStatus.VALIDATION, t.getClass().getSimpleName(), "VALIDATION ERROR", FieldErrorBuilder.map(result.getFieldErrors()));
        T r = service.update(id, t);
        return ResponseEntity.ok(r);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<T>> findByIds(@RequestParam List<Long> ids) {
        List<T> list = service.find(ids);
        return ResponseEntity.ok(list);
    }

}
