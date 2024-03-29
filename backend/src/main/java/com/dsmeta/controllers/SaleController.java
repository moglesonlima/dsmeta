package com.dsmeta.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dsmeta.entities.Sale;
import com.dsmeta.services.SaleService;
import com.dsmeta.services.SmsService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	@Autowired
	private SmsService smsService;
	
	@GetMapping
	public Page<Sale> getAllSalesPageable(Pageable pageable,
			@RequestParam(value="minDate", defaultValue = "") String minDate,
			@RequestParam(value="maxDate", defaultValue = "") String maxDate) {
		System.out.println("Min date: " + minDate + " Max date: " + maxDate);
		return saleService.getAllSalesPageable(pageable, minDate, maxDate);		
	}
	
	@GetMapping("{idParametre}/notification")
	public void notifySms(@PathVariable Long idParametre) {
		smsService.sendSms(idParametre);
	}
	
}
