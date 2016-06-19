/**
 * 
 */
package com.vedaan.lenden.app.endpoint;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.vedaan.lenden.app.service.ILoginService;
import com.vedaan.lenden.model.bo.User;
import com.vedaan.lenden.model.request.LoginRequest;
import com.vedaan.lenden.model.response.GenericResponse;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * @author mayank
 *
 */
@Controller
@Path("/")
@Api("Login Controller")
public class LoginController {

	private static final ResponseBuilder STATUS_OK = Response.status(Response.Status.OK);
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	@Qualifier("loginService")
	ILoginService loginService;

	@POST
	@Path("/user/register")
	@Produces({ javax.ws.rs.core.MediaType.APPLICATION_JSON })
	@Consumes({ javax.ws.rs.core.MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Register a user", response = GenericResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Registered successfully", response = GenericResponse.class) })
	public Response registerUser(@Valid User registerRequest) throws Exception {
		LOGGER.info("Entering registerUser at {}", System.currentTimeMillis());
		GenericResponse genericResponse = loginService.registerUser(registerRequest);
		Response response = STATUS_OK.entity(genericResponse).build();
		return response;
	}

	@POST
	@Path("/user/login")
	@Produces({ javax.ws.rs.core.MediaType.APPLICATION_JSON })
	@Consumes({ javax.ws.rs.core.MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Login a user", response = GenericResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Login successfully", response = GenericResponse.class) })
	public Response loginUser(@Valid LoginRequest loginRequest) throws Exception {
		LOGGER.info("Entering registerUser at {}", System.currentTimeMillis());
		GenericResponse genericResponse = loginService.loginUser(loginRequest);
		Response response = STATUS_OK.entity(genericResponse).build();
		return response;
	}

}
