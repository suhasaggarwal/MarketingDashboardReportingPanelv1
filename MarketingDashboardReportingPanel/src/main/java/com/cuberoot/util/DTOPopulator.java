package com.cuberoot.util;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.websystique.springmvc.model.Reports;
import com.websystique.springmvc.service.ReportDAOImpl;

//Does computations for CPC,CPM,CPP and embeds in json response

/**
 * Utility for converting ResultSets into DTO
 */
public class DTOPopulator {
    /**
     * Populate a result set into DTO
     
     */
    public static List<Reports> populateDTO(ResultSet resultSet)
            throws Exception {
       
    	   List<Reports> report = new ArrayList<Reports>();
           Reports reportDTO = null;
    	   String name;
           while (resultSet.next()) {
        	
        	Double impressions = null;
           	Double clicks = null;
           	Double mediacost = null;
           	Double conversions = null;
           	Double reach = null;  
        	String city = null;
        	String citylatlong = null;
        	String [] parts = null;
        	String audiencesegmentcode = null;
        	String gendercode= null;
        	String agegroupcode = null;
        	String devicetypecode = null;
        	String citycode = null;
        	String oscode = null;
        	String brandcode= null;
        	String incomecode= null;
        	String screensizecode = null;
        	String ispcode = null;
        	int total_rows = resultSet.getMetaData().getColumnCount();
            
        	
        	Reports obj = new Reports();
            for (int i = 0; i < total_rows; i++) {
               name = resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase();
              
               if( name.equals("impression")){
                obj.setImpressions(resultSet.getObject(i + 1).toString());
                impressions = Double.parseDouble(resultSet.getObject(i + 1).toString());
               }
               
               if( name.equals("date"))
            	 obj.setDate(resultSet.getObject(i + 1).toString());
            
               if( name.equals("campaign_id"))
            	  obj.setCampaign_id(resultSet.getObject(i + 1).toString());
            
              if( name.equals("channel"))   
            	   obj.setChannel(resultSet.getObject(i + 1).toString());
            
            
              if( name.equals("clicks")){
                  obj.setClicks(resultSet.getObject(i + 1).toString());
                  clicks = Double.parseDouble(resultSet.getObject(i + 1).toString());
              }
                  
                  
              if( name.equals("conversion")){
                  obj.setConversions(resultSet.getObject(i + 1).toString());
                  conversions = Double.parseDouble(resultSet.getObject(i + 1).toString());
              }
              
              
              if( name.equals("reach")){
                  obj.setReach(resultSet.getObject(i + 1).toString());              
                  reach = Double.parseDouble(resultSet.getObject(i + 1).toString());
              }
              
              
              
              
              if( name.equals("cost")){
                  obj.setCost(resultSet.getObject(i + 1).toString());
                  mediacost = Double.parseDouble(resultSet.getObject(i + 1).toString());
              }   
            
              if( name.equals("audience_segment")){
                  obj.setAudience_segment(resultSet.getObject(i + 1).toString());
                  audiencesegmentcode = ReportDAOImpl.audienceSegmentMap.get(resultSet.getObject(i + 1).toString());
                  obj.setAudiencesegmentcode(audiencesegmentcode);
              }
              if( name.equals("city")){
                   parts = resultSet.getObject(i + 1).toString().split(",");
                	  obj.setCity(parts[0]);
                	  citycode = ReportDAOImpl.citycodeMap.get(parts[0]);                	  
                      obj.setCitycode(citycode);
                	  obj.setCitylatlong(parts[1]+","+parts[2]);
              }
              if( name.equals("device_type")){
                  obj.setDevice_type(resultSet.getObject(i + 1).toString());  
                  devicetypecode = ReportDAOImpl.devicecodeMap.get(resultSet.getObject(i + 1).toString());
                  obj.setDevicetypecode(devicetypecode);
              }
              if( name.equals("os")){
                  obj.setOs(resultSet.getObject(i + 1).toString());  
                  oscode = ReportDAOImpl.oscodeMap.get(resultSet.getObject(i + 1).toString());
                  obj.setOscode(oscode);
              
              }
              if(name.equals("age")){
                  obj.setAge(resultSet.getObject(i + 1).toString());  
                  agegroupcode = ReportDAOImpl.AgeMap.get(resultSet.getObject(i + 1).toString());
                  obj.setAgecode(agegroupcode);
              }
              if(name.equals("gender")){
                  obj.setGender(resultSet.getObject(i + 1).toString());  
                  gendercode = ReportDAOImpl.GenderMap.get(resultSet.getObject(i + 1).toString());
                  obj.setGendercode(gendercode);
              } 
              
              
              if(name.equals("income")){
                  obj.setIncome(resultSet.getObject(i + 1).toString());  
                  incomecode = ReportDAOImpl.IncomeMap.get(resultSet.getObject(i + 1).toString());
                  obj.setIncomecode(incomecode);
              } 
              
              
              if(name.equals("brand")){
                  obj.setBrand(resultSet.getObject(i + 1).toString());  
                  brandcode = ReportDAOImpl.BrandMap.get(resultSet.getObject(i + 1).toString());
                  obj.setBrandcode(brandcode);
              } 
              
              
              if(name.equals("serviceprovider")){
                  obj.setIsp(resultSet.getObject(i + 1).toString());  
                  ispcode = ReportDAOImpl.ispMap.get(resultSet.getObject(i + 1).toString());
                  obj.setIspcode(ispcode);
              } 
              
              if(name.equals("screensize")){
                  obj.setScreensize(resultSet.getObject(i + 1).toString());  
                  screensizecode = ReportDAOImpl.screensizeMap.get(resultSet.getObject(i + 1).toString());
                  obj.setScreensizecode(screensizecode);
              } 
              
              
              
              if(name.equals("duration"))
                  obj.setDuration(resultSet.getObject(i + 1).toString());  
              
              
              
              if(name.equals("cuberootcampaign_id"))
                  obj.setCuberootcampaignId(resultSet.getObject(i + 1).toString());  
              

              if(impressions !=null && mediacost !=null )
                  {
            	    
            	    if(impressions == 0.0 || mediacost == 0.0)
          	    	obj.setCpm(0.0);
            	    else{
            	    	double cpm = round(((mediacost/impressions)*1000),2);
            	    	obj.setCpm(round(cpm,2));
            	    }
            	    	
            	    }
               
                
                if(clicks !=null && mediacost !=null )
                 {
                	if(clicks == 0.0 || mediacost == 0.0)
            	     obj.setCpc(0.0);
                	else{
                	    double cpc = round((mediacost/clicks),2); 
                		obj.setCpc(round(cpc,2));
                 }
                 }
             
                if(conversions !=null && mediacost !=null )
                 {
                	
                	if(conversions == 0.0 || mediacost == 0.0 )
                	obj.setCPConversion(0.0);
                	else{
                		 double cvr = round(((mediacost/conversions)*1000),2);
                		obj.setCPConversion(round(cvr,2));
                 }
                 }
            
                if(reach !=null && mediacost !=null)
                {
                	if(reach == 0.0 ||  mediacost == 0.0)
                	obj.setCpp(0.0);
                	else{
                	    double cpp = round(((mediacost/reach)*1000),2);
                		cpp = round(cpp,2);
                	    obj.setCpp(cpp);
                	}
                }
            
            
            
            
            }
            report.add(obj);
        
        }
        return report;
    }
   
    
    
    public static String createdNestedDTOV1(List<Reports> report)
            throws Exception {
    
    	String out = "";
    	String cuberootcampId;
    	String campId;
    	
    	    
    	    Map<String, Set<HashMap<String,List<Reports>>>> cuberootcampaignIdMap = new HashMap<String, Set<HashMap<String,List<Reports>>>>();
    	    HashMap<String,List<Reports>> campIdMap = new HashMap<String,List<Reports>>();
    	    for(int i=0; i<report.size(); i++)
    	     {
    	        cuberootcampId = report.get(i).getCuberootcampaignId();
    	        Set<HashMap<String,List<Reports>>> reportDTO = cuberootcampaignIdMap.containsKey(cuberootcampId) ? cuberootcampaignIdMap.get(cuberootcampId) : new HashSet<HashMap<String,List<Reports>>>();
    	            
    	           campId = report.get(i).getCampaign_id();
    	           Reports obj = report.get(i);
    	           obj.setCuberootcampaignId(null);
    	           obj.setCampaign_id(null);
    	           if(campIdMap.get(campId)==null)
    	           {
    	        	   List<Reports>object = new ArrayList<Reports>();
    	        	   object.add(obj);
    	        	   campIdMap.put(campId,object);
    	           }
    	           else{
    	        	  List<Reports>object1=campIdMap.get(campId);
    	        	  object1.add(obj);
    	        	  campIdMap.put(campId,object1); 
    	        	   
    	           }
    	           reportDTO.add(campIdMap);
    	           cuberootcampaignIdMap.put(cuberootcampId, reportDTO);
    	     
    	     }
                   
    	   
	          
    	   
    	
    
    	out = new ObjectMapper().writeValueAsString(cuberootcampaignIdMap);
        return out;
    
    }
    
    
    
    
    public static String createdNestedDTO(List<Reports> report)
            throws Exception {
    
    	String out = "";
    	String cuberootcampId;
    	String campId;
    	
    	    
    	    Map<String, Set<Map<String,List<Reports>>>> cuberootcampaignIdMap = new HashMap<String, Set<Map<String,List<Reports>>>>();
    	    HashMap<String,List<Reports>> campIdMap = new HashMap<String,List<Reports>>();
    	    for(int i=0; i<report.size(); i++)
    	     {
    	        cuberootcampId = report.get(i).getCuberootcampaignId();
    	       // Set<HashMap<String,List<Reports>>> reportDTO = cuberootcampaignIdMap.containsKey(cuberootcampId) ? cuberootcampaignIdMap.get(cuberootcampId) : new HashSet<HashMap<String,List<Reports>>>();
    	            
    	           campId = report.get(i).getCampaign_id();
    	           Reports obj = report.get(i);
    	           obj.setCuberootcampaignId(null);
    	           obj.setCampaign_id(null);
    	           if(campIdMap.get(cuberootcampId + ":" +campId)==null)
    	           {
    	        	   List<Reports>object = new ArrayList<Reports>();
    	        	   object.add(obj);
    	        	   campIdMap.put(cuberootcampId + ":" +campId,object);
    	           }
    	           else{
    	        	  List<Reports>object1=campIdMap.get(cuberootcampId + ":"+ campId);
    	        	  object1.add(obj);
    	        	  campIdMap.put(cuberootcampId + ":"+ campId,object1); 
    	        	   
    	           }
    	         //  reportDTO.add(campIdMap);
    	         //  cuberootcampaignIdMap.put(cuberootcampId, reportDTO);
    	     
    	     }
              
    	   
    	   
    	    
    	    for(Map.Entry<String,List<Reports>> entry : campIdMap.entrySet())
   	     {
	          String cIds = entry.getKey();
	          List<Reports> reportv1 = entry.getValue();
   	          String [] parts = cIds.split(":");
   	          Map<String,List<Reports>> reportDTO = new HashMap<String,List<Reports>>();
   	          reportDTO.put(parts[1],reportv1);
   	          Set<Map<String,List<Reports>>> reportDTOV1 = cuberootcampaignIdMap.containsKey(parts[0]) ? cuberootcampaignIdMap.get(parts[0]) : new HashSet<Map<String,List<Reports>>>();
   	          reportDTOV1.add(reportDTO);
   	          cuberootcampaignIdMap.put(parts[0], reportDTOV1);
   	          
   	    }
    	
    
    	out = new ObjectMapper().writeValueAsString(cuberootcampaignIdMap);
        return out;
    
    }
    
    
    
    public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
    
    
    
    
    
    
    
    
    
    
    
    
}