package com.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.po.DiseaseLibrary;
import com.po.Doctor;
import com.util.DBUtil;



/**
 * 疾病库模块
 *@author FFFF
 *
 */
public class DiseaseService {
	
    
    //根据科室id查询所有疾病
    public List<String> queryDiseaseList(Integer sectionId) throws SQLException{
    	
    	String sql = "SELECT name FROM disease_library where section_id = "+ sectionId +"";
    	DBUtil dbUtil = new DBUtil(sql);
    	
    	
    	List<String> DiseaseList = new ArrayList<String>();
    	
    	ResultSet result = null;
		try {
    		result = dbUtil.pst.executeQuery();
    		
    		while(result.next()){
    			
    			String diseaseName = result.getString("name");
    			// Integer  id =  Integer.getInteger("id");
    			
    			DiseaseList.add(diseaseName);
    		}
    		return DiseaseList;
		} catch (Exception e) {
			e.getMessage();
		}finally {
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return DiseaseList;
    }
    
    
    
    
    //根据疾病名查询疾病详情
	public List<Object> queryDisease(String diseaseName) throws SQLException{
    	
    	String sql = " SELECT disease_library.id,disease_library.name,disease_library.bio,disease_library.user_icon,disease_library.user_name,disease_library.user_put_question,disease_library.doctor_icon, disease_library.doctor_name, disease_library.doctor_answer_question, disease_library.symptom, disease_library.cure, disease_library.prompt,section.name AS section_name,doctor.id as doctor_id, doctor.username as doctor_account, doctor.`name` as doctor_name1, doctor.icon, doctor.title, doctor.section, doctor.adept, doctor.chat_cost, doctor.hospital FROM disease_library left join section on disease_library.section_id = section.id left join doctor on disease_library.doctor_id = doctor.id WHERE disease_library.name = "+"'"+diseaseName+"'"+" ";
		DBUtil dbUtil = new DBUtil(sql);
    	
    	
    	ResultSet result = null;
    	
    	
    	List<Object> list = new ArrayList<Object>();
    	
		try {
    		result  = dbUtil.pst.executeQuery();
    		
    		while (result.next()) {
    			
    			Integer id = result.getInt("id");
    			String name = result.getString("name");
    			String bio = result.getString("bio");
    			String userIcon = result.getString("user_icon");
    			String userName = result.getString("user_name");
    			String userPutQuestion = result.getString("user_put_question");
    			String doctorIcon = result.getString("doctor_icon");
    			String doctorName = result.getString("doctor_name");
    			String doctorAnswerQuestion = result.getString("doctor_answer_question");
    			String symptom = result.getString("symptom");
    			String cure = result.getString("cure");
    			String prompt = result.getString("prompt");
    			String sectionName = result.getString("section_name");
    			Integer doctorId = result.getInt("doctor_id");
    			String doctorAccount = result.getString("doctor_account");
    			String doctorName1 = result.getString("doctor_name1");
    			String icon = result.getString("icon");
    			String title = result.getString("title");
    			String section = result.getString("section");
    			String adept = result.getString("adept");
    			String chatCost = result.getString("chat_cost");
    			String hospital = result.getString("hospital");
    			
    			DiseaseLibrary diseaseLibrary = new DiseaseLibrary();
    			diseaseLibrary.setId(id);
    			diseaseLibrary.setName(name);
    			diseaseLibrary.setBio(bio);
    			diseaseLibrary.setUserIcon(userIcon);
    			diseaseLibrary.setUserName(userName);
    			diseaseLibrary.setUserPutQuestion(userPutQuestion);
    			diseaseLibrary.setDoctorIcon(doctorIcon);
    			diseaseLibrary.setDoctorName(doctorName);
    			diseaseLibrary.setDoctorAnswerQuestion(doctorAnswerQuestion);
    			diseaseLibrary.setSymptom(symptom);
    			diseaseLibrary.setCure(cure);
    			diseaseLibrary.setPrompt(prompt);
    			diseaseLibrary.setSectionName(sectionName);
    			
    			Doctor doctor = new Doctor();
    			doctor.setId(doctorId);
    			doctor.setUsername(doctorAccount);
    			doctor.setName(doctorName1);
    			doctor.setIcon(icon);
    			doctor.setTitle(title);
    			doctor.setSection(section);
    			doctor.setAdept(adept);
    			doctor.setChatCost(chatCost);
    			doctor.setHospital(hospital);
    			
    			list.add(diseaseLibrary);
    			list.add(doctor);
			}
    		return list;
		} catch (Exception e) {
			e.getMessage();
		} finally {
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return list;
    }
    
	//管理后台获取所有疾病库内容
	public List<Map<String,Object>> quireDisease() throws SQLException{
		
		String sql = "select id,name,bio,symptom,cure,prompt,section_id,doctor_id from   disease_library"; 
		DBUtil dbUtil = new DBUtil(sql);
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		ResultSet result = null;
		try {
			result=dbUtil.pst.executeQuery();
			while(result.next()){
				
				Integer id = result.getInt("id");
				String name = result.getString("name");
				String bio = result.getString("bio");
				String symptom = result.getString("symptom");
				String cure = result.getString("cure");
				String prompt = result.getString("prompt");
				Integer section_id = result.getInt("section_id");
  				Integer doctor_id = result.getInt("doctor_id");
	            
  				Map<String,Object> map = new HashMap<String,Object>();
  				
  				map.put("id", id);
  				map.put("name", name);
  				map.put("bio", bio);
  				map.put("symptom", symptom);
  				map.put("cure", cure);
  				map.put("prompt", prompt);
  				map.put("section_id", section_id);
  				map.put("doctor_id", doctor_id);
  				
  				list.add(map);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			result.close();
			dbUtil.close();
		}
		return list;
	}
	//管理后台添加疾病
	public int insertdisease(DiseaseLibrary diseaseLibrary){
		
		String sql = " INSERT INTO disease_library(name,section_id, bio,user_name,user_icon, user_put_question, doctor_icon, doctor_name ,doctor_answer_question,symptom, cure, prompt,doctor_id) VALUES("+"'"+diseaseLibrary.getName()+"'"+","+diseaseLibrary.getSectionId()+","+"'"+diseaseLibrary.getBio()+"'"+","+"'"+diseaseLibrary.getUserName()+"'"+","+"'"+diseaseLibrary.getUserIcon()+"'"+","+"'"+diseaseLibrary.getUserPutQuestion()+"'"+","+"'"+diseaseLibrary.getDoctorIcon()+"'"+","+"'"+diseaseLibrary.getDoctorName()+"'"+","+"'"+diseaseLibrary.getDoctorAnswerQuestion()+"'"+","+"'"+diseaseLibrary.getSymptom()+"'"+","+"'"+diseaseLibrary.getCure()+"'"+","+"'"+diseaseLibrary.getPrompt()+"'"+","+diseaseLibrary.getDoctorId()+")";
		DBUtil dbUtil = new DBUtil(sql);
		
		
		try {
			dbUtil.pst.executeUpdate();
			return 1;//success
		} catch (SQLException e) {
			e.printStackTrace();
			return 2;//error
		} finally {
			if(dbUtil != null)dbUtil.close();
		}
	}
	//管理后台删除疾病
	public int deleteDieaseById(Integer id){
		
		String sql = " DELETE FROM disease_library WHERE id = "+id+" ";
		DBUtil dbUtil = new DBUtil(sql);
         			
		try {
			dbUtil.pst.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 2;
		} finally{
			if(dbUtil != null)dbUtil.close();
		}
	}
	//根据Id管理后台获取疾病
	public List<Map<String,Object>> findDiseaseById(Integer id) throws SQLException{
		String sql = "select id,name,bio,user_icon,user_name,user_put_question,doctor_icon,doctor_name,doctor_answer_question,symptom,cure,prompt,section_id,doctor_id  from   disease_library where id="+id+"";
		DBUtil dbUtil = new DBUtil(sql);
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		ResultSet result =null;
		try{
		result=dbUtil.pst.executeQuery();
		while(result.next()){
			
			Integer id1 = result.getInt("id");
			String name = result.getString("name");
			String bio = result.getString("bio");
			String user_icon = result.getString("user_icon");
			String user_name = result.getString("user_name");
			String user_put_question = result.getString("user_put_question");
			String doctor_icon = result.getString("doctor_icon");
			String doctor_name = result.getString("doctor_name");
			String doctor_answer_question = result.getString("doctor_answer_question");
			String symptom = result.getString("symptom");
			String cure = result.getString("cure");
			String prompt = result.getString("prompt");
			Integer section_id = result.getInt("section_id");
			Integer doctor_id = result.getInt("doctor_id");
            
			Map<String,Object> map = new HashMap<String,Object>();
			    map.put("id1", id1);
				map.put("name", name);
				map.put("bio", bio);
				map.put("user_icon", user_icon);
				map.put("user_name", user_name);
				map.put("user_put_question", user_put_question);
				map.put("doctor_icon", doctor_icon);
				map.put("doctor_name", doctor_name);
				map.put("doctor_answer_question", doctor_answer_question);
				map.put("symptom", symptom);
				map.put("cure", cure);
				map.put("prompt", prompt);
				map.put("section_id", section_id);
				map.put("doctor_id", doctor_id);
				
				list.add(map);
		}
		return list;
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		result.close();
		dbUtil.close();
	}
	return list;
	}
	//管理后台更新疾病
	public int updataDisease(Integer id,String name,String bio,String user_icon,String user_name,String user_put_question,String doctor_icon,String doctor_name,String doctor_answer_question,String symptom,String cure,String prompt,Integer section_id,Integer doctor_id){
		
		String sql = "UPDATE disease_library SET name = " + "'" +name+ "'" + " , bio = " + "'" +bio+ "'" + ",user_icon = " + "'" +user_icon+ "'" + ",user_name = " + "'" +user_name+ "'" + ",user_put_question="+"'"+user_put_question+"'"+",doctor_icon="+"'"+doctor_icon+"'"+",doctor_name="+"'"+doctor_name+"'"+",doctor_answer_question="+"'"+doctor_answer_question+"'"+",symptom="+"'"+symptom+"'"+",cure="+"'"+cure+"'"+",prompt="+"'"+prompt+"'"+",section_id="+section_id+",doctor_id="+doctor_id+" WHERE id= " + id + " ";
		DBUtil dbUtil = new DBUtil(sql);

		
		try {
			dbUtil.pst.executeUpdate();
			return 1;// 成功
		} catch (Exception e) {
			e.printStackTrace();
			return 2;// 失败

		} finally {
			if(dbUtil != null)dbUtil.close();
		}
	}
 
}
