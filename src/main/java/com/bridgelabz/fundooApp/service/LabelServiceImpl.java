package com.bridgelabz.fundooApp.service;

import java.time.LocalTime;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundooApp.dto.LabelDto;
import com.bridgelabz.fundooApp.exception.UserException;
import com.bridgelabz.fundooApp.model.Label;
import com.bridgelabz.fundooApp.model.User;
import com.bridgelabz.fundooApp.repository.LabelRespository;
import com.bridgelabz.fundooApp.repository.UserRepository;
import com.bridgelabz.fundooApp.response.Response;
import com.bridgelabz.fundooApp.utility.JWTTokenGenerator;

@Service
public class LabelServiceImpl implements LabelService {

	@Autowired
	private JWTTokenGenerator tokenGenerator;
	@Autowired
	private LabelRespository labelRespository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Response createLabel(String token, LabelDto labelDto) {
		String userId = tokenGenerator.verifyToken(token);
		Optional<User> optUser = userRepository.findById(userId);
		if (optUser.isPresent()) {
			User user = optUser.get();
			Label label = modelMapper.map(labelDto, Label.class);
			label.setCreationTime(LocalTime.now());
			label.setUserId(user.getUserid());
			labelRespository.save(label);
			return new Response(200, "success", null);
		} else {
			throw new UserException("unsuccess");
		}

	}

	@Override
	public Response updateLabel(String token, String labeId, LabelDto labelDto) {
		String userId = tokenGenerator.verifyToken(token);
		Optional<User> optUser = userRepository.findById(userId);
		if (optUser.isPresent()) {

			Optional<Label> optLabel = labelRespository.findById(labeId);
			if (optLabel.isPresent()) {
				Label label = optLabel.get();
				label.setLabelName(labelDto.getLabelName());
				label.setUpdateTime(LocalTime.now());
				labelRespository.save(label);
				return new Response(200, "success", null);

			} else {
				return new Response(202, "label id doesnt match", null);
			}
		} else {
			return new Response(202, "unseccess", null);
		}
	}

	@Override
	public Response deleteLabel(String token, String labelId) {

		String userId = tokenGenerator.verifyToken(token);
		Optional<User> optUser = userRepository.findById(userId);
		System.out.println(userId);
		if (optUser.isPresent()) {
			Optional<Label> optLabel = labelRespository.findById(labelId);
			System.out.println("LabelServiceImpl.deleteLabel()");
			if (optLabel.isPresent()) {
				System.out.println("LabelServiceImpl.deleteLabel()");
				Label label = optLabel.get();
				labelRespository.delete(label);

				return new Response(200, "label deleted", null);

			} else {
				return new Response(202, "label doesnt exist", null);
			}
		} else {
			return new Response(202, "user not found", null);
		}
	}

}
