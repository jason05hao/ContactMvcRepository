package com.contactMvc.web;

import com.britesnow.snow.web.param.annotation.PathVar;
import com.britesnow.snow.web.param.annotation.WebUser;
import com.britesnow.snow.web.rest.annotation.WebGet;
import com.britesnow.snow.web.rest.annotation.WebPost;
import com.britesnow.snow.web.param.annotation.WebModel;
import com.britesnow.snow.web.param.annotation.WebParam;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import com.contactMvc.entity.Contact;
import java.util.List;
import com.contactMvc.AppException;
/**
 * <p>This is the generic Data Access Service layer from the server.</p>
 *
 * <p><strong>Note:</strong> Non parameterized @WebRest (i.e. @WebGet("/das-get-Project") will take precedence over
 * parameterized ones (i.e. @WebGet("das-get-{entity}"). Therefore, this GenericDasWebRest can been seen as a fall back
 * fall back when no specialized DasWebRest methods are handling specific entity.</p>
 *
 * <p><strong>Best Practice:</strong> Often, when starting a new project, this is a great and and simple way to start connecting
 * your client to those Web[REST] APIs. As the application becomes more sophisticated, you can override those generic bindings with
 * more specifics ones (e.g., for added security and business rules) without ever changing the UI code.</p>
 *
 */
@Singleton
public class ContactDasWebRest {

	@WebPost("/das-create-Contact")
	public WebResponse createContact(@WebModel Contact contact){
		Contact entity = new Contact(1L, "Jason", "Hao", "jason05.hao@gmail.com", "", "647-947-9366", "19 Selwyn road", "Richmond Hill", "Ontario", "Canada");
		// Copy contact to entity
		return WebResponse.success(entity);
	}

	@WebGet("/das-get-Contact")
	public WebResponse getContact(@WebParam("id") Long id){
		// read the contact
		Contact entity = new Contact(id, "Jason" + id, "Hao", "jason05" + id + ".hao@gmail.com", "", "647-947-9366" + id, "19 Selwyn road", "Richmond Hill", "Ontario", "Canada");

		return WebResponse.success(entity);
	}

	@WebGet("/das-list-Contact")
	public WebResponse listContact(){
		// retrieve contact list
		List<Contact> list = new ArrayList<Contact>();
		list.add(new Contact(1L, "Jason1", "Hao", "jason051.hao@gmail.com", "", "647-947-93661", "191 Selwyn road", "Richmond Hill", "Ontario", "Canada"));
		list.add(new Contact(2L, "Jason2", "Hao", "jason052.hao@gmail.com", "", "647-947-93662", "192 Selwyn road", "Richmond Hill", "Ontario", "Canada"));
		list.add(new Contact(3L, "Jason3", "Hao", "jason053.hao@gmail.com", "", "647-947-93663", "193 Selwyn road", "Richmond Hill", "Ontario", "Canada"));
		list.add(new Contact(4L, "Jason4", "Hao", "jason054.hao@gmail.com", "", "647-947-93664", "194 Selwyn road", "Richmond Hill", "Ontario", "Canada"));
		list.add(new Contact(5L, "Jason5", "Hao", "jason055.hao@gmail.com", "", "647-947-93665", "195 Selwyn road", "Richmond Hill", "Ontario", "Canada"));
		list.add(new Contact(6L, "Jason6", "Hao", "jason056.hao@gmail.com", "", "647-947-93666", "196 Selwyn road", "Richmond Hill", "Ontario", "Canada"));
		list.add(new Contact(7L, "Jason7", "Hao", "jason057.hao@gmail.com", "", "647-947-93667", "197 Selwyn road", "Richmond Hill", "Ontario", "Canada"));
		list.add(new Contact(8L, "Jason8", "Hao", "jason058.hao@gmail.com", "", "647-947-93668", "198 Selwyn road", "Richmond Hill", "Ontario", "Canada"));
		return WebResponse.success(list);
	}

	@WebPost("/das-update-Contact")
	public WebResponse updateEntity(@WebModel Contact contact){
		Contact entity = new Contact(contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getWebsite(), contact.getPhoneNumber(), contact.getAddress(), contact.getCity(), contact.getState(), contact.getCountry());
		return WebResponse.success(entity);
	}


	@WebPost("/das-delete-Contact-{id}")
	public WebResponse deleteContact(@PathVar("id") Long id){
		if (id > 0 && id < 9){
			return WebResponse.success(id);
		}else{
			return WebResponse.fail(new AppException("Cannot delete Contact with id " + id));
		}
	}
}