package com.bridgelabz.fundooApp.service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundooApp.dto.NoteDto;
import com.bridgelabz.fundooApp.model.Note;
import com.bridgelabz.fundooApp.model.User;
import com.bridgelabz.fundooApp.repository.NoteRepository;
import com.bridgelabz.fundooApp.repository.UserRepository;
import com.bridgelabz.fundooApp.response.Response;
import com.bridgelabz.fundooApp.utility.JWTTokenGenerator;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private JWTTokenGenerator tokenGenerator;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private NoteRepository noteRepository;

	@Override
	public Response createNote(NoteDto noteDto, String token) {
		String userId = tokenGenerator.verifyToken(token);
		Optional<User> optUser = userRepository.findByUserId(userId);
		if (optUser.isPresent()) {
			Note note = modelMapper.map(noteDto, Note.class);
			note.setCreationtTime(LocalTime.now());
			note.setUserId(userId);
			noteRepository.save(note);
			return new Response(200, "note created ", null);

		} else {
			return new Response(204, "unsuccess", null);
		}
	}

	@Override
	public Response updateNote(NoteDto noteDto, String noteId, String token) {
		String userId = tokenGenerator.verifyToken(token);
		Optional<User> optUser = userRepository.findByUserId(userId);
		if (optUser.isPresent()) {
			Optional<Note> optNote = noteRepository.findById(noteId);
			if (optNote.isPresent()) {
				Note note = optNote.get();

				note.setUpdateTime(LocalTime.now());

				note.setTitle(noteDto.getTitle());
				note.setDescription(noteDto.getDescription());
				noteRepository.save(note);
				return new Response(200, "updated note", null);

			} else {
				return new Response(202, "note doesnt exist", null);
			}
		} else {
			return new Response(202, "unsuccess", null);
		}

	}

	@Override
	public Response deleteNote(String noteId, String token) {
		String userId = tokenGenerator.verifyToken(token);
		Optional<User> optUser = userRepository.findByUserId(userId);
		if (optUser.isPresent()) {
			Optional<Note> optNote = noteRepository.findById(noteId);
			if (optNote.isPresent()) {
				Note note = optNote.get();
				note.setTrash(true);
				noteRepository.save(note);
				return new Response(200, "deleted note", null);
			} else {
				return new Response(202, "note doesn't exist", null);

			}
		} else {
			return new Response(202, "unsuccess", null);
		}
	}

	@Override
	public Note getNote(String noteId, String token) {

		String userId = tokenGenerator.verifyToken(token);
		Optional<User> optUser = userRepository.findByUserId(userId);
		if (optUser.isPresent()) {
			Optional<Note> optNote = noteRepository.findById(noteId);
			if (optNote.isPresent()) {
				Note note = optNote.get();
				return note;
			} else {
				return null;
			}
		} else {
			return null;
		}

	}

	@Override
	public List<Note> getAllNote(String token) {

		String userId = tokenGenerator.verifyToken(token);
		List<Note> note = noteRepository.findByUserId(userId);
		List<Note> noteslist=note.stream().collect(Collectors.toList());
		/*
		 * List<NoteDto> noteslist = new ArrayList<NoteDto>(); for (Note userNotes :
		 * note) { NoteDto noteDto = modelMapper.map(userNotes, NoteDto.class);
		 * noteslist.add(noteDto);
		 * 
		 * } return noteslist;
		 */
		return noteslist;
	}

	@Override
	public List<Note> getTrash(String token) {
		String userId = tokenGenerator.verifyToken(token);
		List<Note> notes = noteRepository.findByUserId(userId);
		List<Note> noteslist=notes.stream().filter(data->data.isTrash()==true).collect(Collectors.toList());
		/*
		 * List<NoteDto> noteslist = new ArrayList<NoteDto>(); for (Note note : notes) {
		 * NoteDto noteDto = modelMapper.map(note, NoteDto.class);
		 * 
		 * if (note.isTrash() == true) { noteslist.add(noteDto); } } return noteslist;
		 */
		return noteslist;
	}

	@Override
	public List<Note> getArchive(String token) {

		String userId = tokenGenerator.verifyToken(token);
		User user = userRepository.findById(userId).get();
		List<Note> noteslist = user.getNoteList().stream().filter(data -> data.isArchive() == true)
				.collect(Collectors.toList());

		return noteslist;
	}

	@Override
	public Response archiveNote(String noteId, String token) {
	
		String userId=tokenGenerator.verifyToken(token);
		Optional<User> optUser=userRepository.findById(userId);
		if(optUser.isPresent())
		{
			Optional<Note> optNote=noteRepository.findById(noteId);
			if(optNote.isPresent())
			{
				Note note=optNote.get();
				note.setArchive(true);
				
			}
		}
		return null;
	}

}
