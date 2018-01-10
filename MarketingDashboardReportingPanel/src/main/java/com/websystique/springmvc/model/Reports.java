package com.websystique.springmvc.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Reports {

	private String date;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCampaign_id() {
		return campaign_id;
	}

	public void setCampaign_id(String campaign_id) {
		this.campaign_id = campaign_id;
	}

	public String getImpressions() {
		return impressions;
	}

	public void setImpressions(String impressions) {
		this.impressions = impressions;
	}

	public String getClicks() {
		return clicks;
	}

	public void setClicks(String clicks) {
		this.clicks = clicks;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getAudience_segment() {
		return audience_segment;
	}

	public void setAudience_segment(String audience_segment) {
		this.audience_segment = audience_segment;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getDevice_type() {
		return device_type;
	}

	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}

	private String campaign_id;
	
	private String impressions;
	
	private String clicks;
	
	private String channel;
	
	private String brand;
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	public String getScreensize() {
		return screensize;
	}

	public void setScreensize(String screensize) {
		this.screensize = screensize;
	}

	private String income;
	
	private String incomecode;
	
	private String isp;
	
	private String ispcode;
	
	private String screensize;
	
	private String screensizecode;
	
	private String brandcode;
	
	public String getIncomecode() {
		return incomecode;
	}

	public void setIncomecode(String incomecode) {
		this.incomecode = incomecode;
	}

	public String getIspcode() {
		return ispcode;
	}

	public void setIspcode(String ispcode) {
		this.ispcode = ispcode;
	}

	public String getScreensizecode() {
		return screensizecode;
	}

	public void setScreensizecode(String screensizecode) {
		this.screensizecode = screensizecode;
	}

	public String getBrandcode() {
		return brandcode;
	}

	public void setBrandcode(String brandcode) {
		this.brandcode = brandcode;
	}

	public String getCuberootcampaignId() {
		return cuberootcampaignId;
	}

	public void setCuberootcampaignId(String cuberootcampaignId) {
		this.cuberootcampaignId = cuberootcampaignId;
	}

	private String cuberootcampaignId;
	
	private List<Reports> audience_segment_data = new ArrayList<Reports>();
	
	public List<Reports> getAudience_segment_data() {
		return audience_segment_data;
	}

	public void setAudience_segment_data(List<Reports> audience_segment_data) {
		this.audience_segment_data = audience_segment_data;
	}

	private String audience_segment;
	
	private String audiencesegmentcode;
	
	private String city;
	
	private String citycode;
	
	private String os;
	
	private String oscode;
	
	private String device_type;

	private String devicetypecode;
	
    private String conversions;
    
    private String reach;
   
    public String getReach() {
		return reach;
	}

	public void setReach(String reach) {
		this.reach = reach;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	private String age;
    
	private String agecode;
	
    private String gender;
    
    private String gendercode;
    
    public Double getCpm() {
		return cpm;
	}

	public void setCpm(Double cpm) {
		this.cpm = cpm;
	}

	public Double getCpc() {
		return cpc;
	}

	public void setCpc(Double cpc) {
		this.cpc = cpc;
	}

	public Double getCPConversion() {
		return cpconversion;
	}

	public void setCPConversion(Double cpconversion) {
		this.cpconversion = cpconversion;
	}

	private Double cpm;
    
    private Double cpc;
    
    private Double cpconversion;
    
    private Double cpp;
    
	
	public Double getCpp() {
		return cpp;
	}

	public void setCpp(Double cpp) {
		this.cpp = cpp;
	}

	public String getConversions() {
		return conversions;
	}

	public void setConversions(String conversions) {
		this.conversions = conversions;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	private String cost;
	
	public String getCitylatlong() {
		return citylatlong;
	}

	public void setCitylatlong(String citylatlong) {
		this.citylatlong = citylatlong;
	}

	public String getAudiencesegmentcode() {
		return audiencesegmentcode;
	}

	public void setAudiencesegmentcode(String audiencesegmentcode) {
		this.audiencesegmentcode = audiencesegmentcode;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getOscode() {
		return oscode;
	}

	public void setOscode(String oscode) {
		this.oscode = oscode;
	}

	public String getDevicetypecode() {
		return devicetypecode;
	}

	public void setDevicetypecode(String devicetypecode) {
		this.devicetypecode = devicetypecode;
	}

	public String getAgecode() {
		return agecode;
	}

	public void setAgecode(String agecode) {
		this.agecode = agecode;
	}

	public String getGendercode() {
		return gendercode;
	}

	public void setGendercode(String gendercode) {
		this.gendercode = gendercode;
	}

	private String citylatlong;
	
	private String duration;

	

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
}
