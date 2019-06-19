package com.bridgelabz.fundooApp.service;

import com.bridgelabz.fundooApp.dto.LabelDto;
import com.bridgelabz.fundooApp.response.Response;

public interface LabelService {

	Response createLabel(String token,LabelDto labelDto);
	Response updateLabel(String token, String labeId,LabelDto labelDto);
	Response deleteLabel(String token,String labelId);
}
