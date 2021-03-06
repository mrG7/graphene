package graphene.web.components.user;

import graphene.dao.UserDAO;
import graphene.model.idl.G_User;
import graphene.model.idl.G_UserDataAccess;

import java.util.List;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Events;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.slf4j.Logger;

/**
 * This component will trigger the following events on its container (which in
 * this example is the page):
 * {@link UserList.web.components.examples.ajax.gracefulcomponentscrud.PersonList#SELECTED}
 * (Long personId).
 */
// @Events is applied to a component solely to document what events it may
// trigger. It is not checked at runtime.
@Events({ UserList.SELECTED })
public class UserList {
	public static final String SELECTED = "selected";

	// Parameters

	@Parameter(required = true)
	@Property
	private String partialName;

	@Parameter(required = true)
	@Property
	private String selectedUsername;

	// Screen fields

	@Property
	private G_User current;

	// Generally useful bits and pieces

	@Inject
	private G_UserDataAccess userDataAccess;

	@Inject
	private ComponentResources componentResources;

	@Inject
	private Request request;

	// The code

	@Inject
	private UserDAO uDao;

	// Handle event "selected"

	@Inject
	private Logger logger;

	// Getters

	public String getLinkCSSClass() {
		if ((current != null) && current.getUsername().equals(selectedUsername)) {
			return "active";
		} else {
			return "";
		}
	}

	public boolean isAjax() {
		return request.isXHR();
	}

	public List<G_User> list() {
		logger.debug("Updating list of users");
		return uDao.getAll();
	}

	boolean onSelected(final Long personId) {
		// Return false, which means we haven't handled the event so bubble it
		// up.
		// This method is here solely as documentation, because without this
		// method the event would bubble up anyway.
		return false;
	}

	boolean onSuccessFromFilterForm() {
		// Trigger new event "filter" which will bubble up.
		componentResources.triggerEvent("filter", null, null);
		// We don't want "success" to bubble up, so we return true to say we've
		// handled it.
		return true;
	}
}
