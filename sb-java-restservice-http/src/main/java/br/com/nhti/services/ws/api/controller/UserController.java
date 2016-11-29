package br.com.nhti.services.ws.api.controller;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.nhti.services.ws.api.model.User;

@RestController
public class UserController {

	private static BigInteger nextId;
	private static Map<BigInteger, User> mapUsers;

	private static User save(User newUser) {
		if (mapUsers == null) {
			mapUsers = new HashMap<BigInteger, User>();
			nextId = BigInteger.ONE;
		}

		mapUsers.put(newUser.getId(), newUser);

		System.out.println(newUser.toString());
		System.out.println(mapUsers.size());
		
		return newUser;
	}

	static {

		User u1 = new User(new BigInteger("1"), "Charlie", "IT Architect");
		save(u1);

		User u2 = new User(new BigInteger("2"), "Chuck", "IT Support");
		save(u2);

		User u3 = new User(new BigInteger("3"), "John", "HelpDesk");
		save(u3);

	}

	@RequestMapping(value = "/api/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<User>> getUsers() {

		//System.out.println("Valores: " + mapUsers.values().toString());

		Collection<User> users = mapUsers.values();

		return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);

	}

}
