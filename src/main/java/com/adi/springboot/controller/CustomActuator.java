package com.adi.springboot.controller;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="customActuator")
public class CustomActuator {
	
Map<String,List<String>> releaseNoteMap=new LinkedHashMap<>();
	
	@PostConstruct
	public void initNotes() {
		releaseNoteMap.put("v1", Arrays.asList("v1","v1 release note"));
		releaseNoteMap.put("v2", Arrays.asList("v2","v2 release note"));
	}
	
	//http://localhost:8081/adiActuator/customActuator
	@ReadOperation
	public Map<String,List<String>> getReleaseNotes(){
		return releaseNoteMap;
	} 
	
	//get type
	//http://localhost:8081/adiActuator/customActuator/v1
	@ReadOperation  
	public List<String> getReleaseNotesByVersion(@Selector String version){
		return releaseNoteMap.get(version);
	}

	//Post Type
	@WriteOperation 
	public void addReleaseNote(@Selector String version,String data) {
		List<String> notes=Arrays.stream(data.split(",")).collect(Collectors.toList());
		releaseNoteMap.put(version,notes);
	}
	
	@DeleteOperation
	public void deleteNotes(@Selector String version) {
		releaseNoteMap.remove(version);
	}

}
