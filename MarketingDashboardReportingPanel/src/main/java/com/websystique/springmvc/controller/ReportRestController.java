package com.websystique.springmvc.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.websystique.springmvc.model.CampaignData;
import com.websystique.springmvc.model.Reports;
import com.websystique.springmvc.service.ReportService;

//Application code - b7

@RestController
public class ReportRestController {

	
	//Controller receives data from Service API and generates a JSON feed to feed into visualisation component.
	//API format <Report/Reportcode/Daterange/CampaignId, as campaignId is specified after daterange, selected campaign is picked and campaign report is shown channel wise.	
	
	
	@Autowired
	ReportService reportService;  //Service which will do all data retrieval/manipulation work

	//-------------------Retrieve Report with Id--------------------------------------------------------
	@RequestMapping(value = "/report/{QueryField}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin
	public ResponseEntity<String> getReport(@PathVariable("QueryField") String queryfield,
			@RequestParam("dateRange") String dateRange,
			@RequestParam(value = "metric", required = false) String metric,
			@RequestParam(value = "campaign_id", required = false) String campaignId,
			@RequestParam(value = "channel", required = false) String channel,
			@RequestParam(value= "aggregated") String aggregate
			) {
		
		System.out.println("Fetching Report with"+queryfield);
		String report = reportService.extractReports(queryfield,metric,dateRange,campaignId,channel,aggregate);
		if (report == null) {
			System.out.println("Report with with"+queryfield+ " not found");
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(report, HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/report/getCuberootCampaignIds", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin
	public ResponseEntity<List<CampaignData>> getReport(@RequestParam("dateRange") String dateRange) {
	
		List<CampaignData> report = reportService.extractCuberootCampaignIds(dateRange);
		if (report == null) {
			
			return new ResponseEntity<List<CampaignData>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<CampaignData>>(report, HttpStatus.OK);
	}

	@RequestMapping(value = "/report/getCampaignIds", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin
	public ResponseEntity<List<CampaignData>> getReport(@RequestParam("dateRange") String dateRange,@RequestParam("cuberootCampaignId") String cuberootCampaignId) {
	
		List<CampaignData> report = reportService.extractCampaignIds(dateRange,cuberootCampaignId);
		if (report == null) {
			
			return new ResponseEntity<List<CampaignData>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<CampaignData>>(report, HttpStatus.OK);
	}
	
	
	
}
