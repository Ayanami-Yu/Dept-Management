package com.example.myProject.controller;

import com.example.myProject.entity.Dept;
import com.example.myProject.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private DeptRepository deptRepository;

	@GetMapping("/findAll/{page}/{size}")
	public Page<Dept> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
		PageRequest request = PageRequest.of(page, size);
		return deptRepository.findAll(request);
	}

	@GetMapping("/findById/{deptNo}")
	public Dept findById(@PathVariable("deptNo") Integer deptNo) {
		return deptRepository.findById(deptNo).get();
	}

	@PostMapping("/save")
	public String save(@RequestBody Dept dept) {
		Dept result = deptRepository.save(dept);
		if (result != null){
			return "success";
		}else {
			return "error";
		}
	}

	@PutMapping("/update")
	public String update(@RequestBody Dept dept) {
		Dept result = deptRepository.save(dept);
		if (result != null) {
			return "success";
		}else {
			return "error";
		}
	}

	@DeleteMapping("/delete/{deptNo}")
	public void delete(@PathVariable("deptNo") Integer deptNo) {
		deptRepository.deleteById(deptNo);
	}
}
