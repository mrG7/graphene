package ${package}.web.pages;

import graphene.business.commons.exception.DataAccessException;
import graphene.model.idl.G_Constraint;
import graphene.model.idl.G_SymbolConstants;
import graphene.model.idl.G_VisualType;
import graphene.util.validator.ValidationUtils;
import graphene.web.annotations.PluginPage;
import graphene.web.pages.CombinedEntitySearchPage;
import graphene.web.pages.SimpleBasePage;

import org.apache.tapestry5.Link;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.alerts.Duration;
import org.apache.tapestry5.alerts.Severity;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.Request;
import org.graphene.augment.mitie.dao.MitieDAO;
import org.graphene.augment.mitie.model.MitieEntity;
import org.graphene.augment.mitie.model.MitieResponse;
import org.slf4j.Logger;

@PluginPage(visualType = G_VisualType.TOP, menuName = "Entity Extraction", icon = "fa fa-lg fa-fw fa-cogs")
public class EntityExtraction extends SimpleBasePage {

	@Inject
	private Logger logger;
	@Inject
	private MitieDAO dao;
	@Property
	@Persist
	private String textReturnValue;

	@Property
	@Persist(PersistenceConstants.FLASH)
	private String textAreaValue;

	@Property
	@Persist
	private MitieResponse r;
	@Property
	@Persist
	private MitieEntity currentEntity;
	@Inject
	private AlertManager alertManager;

	@Component(id = "AugmentTextForm")
	private Form form;

	@Inject
	private Request request;

	@InjectComponent
	private Zone extractionZone;
	
	@InjectPage
	private CombinedEntitySearchPage searchPage;
	
	@Inject
	@Symbol(G_SymbolConstants.DEFAULT_MAX_SEARCH_RESULTS)
	private Integer defaultMaxResults;

	@OnEvent(value = "cancel")
	void cancel() {
		textAreaValue = null;
	}

	public String getNumberOfEntitiesExtracted() {
		int results = 0;
		if ((r != null) && (r.getEntities() != null)) {
			results = r.getEntities().size();
		}
		if (results == 0) {
			return "No entities extracted";
		} else if (results == 1) {
			return "One entity extracted";
		} else {
			return "" + results + " entities extracted";
		}
	}

	public String getStyleIcon() {
		String style;
		switch (currentEntity.getTag()) {

		case "ORGANIZATION":
			style = "fa fa-lg fa-fw fa-building";
			break;
		case "PERSON":
			style = "fa fa-lg fa-fw fa-user";
			break;
		case "LOCATION":
			style = "fa fa-lg fa-fw fa-map-marker";
			break;
		case "MISC":
			style = "fa fa-lg fa-fw fa-question-circle";
			break;
		default:
			style = "fa fa-lg fa-fw fa-question";
		}
		return style;
	}
	
	public Link getNamePivotLink(final String term) {
		// XXX: pick the right search type based on the link value
		final Link l = searchPage.set(null, "media", G_Constraint.COMPARE_EQUALS.name(), term, defaultMaxResults);
		return l;
	}

	Object onFailureFromAugmentTextForm() {
		r = null;
		currentEntity = null;
		return request.isXHR() ? extractionZone.getBody() : null;
	}

	Object onSuccessFromAugmentTextForm() {
		r = null;
		currentEntity = null;
		if (ValidationUtils.isValid(textAreaValue)) {
			try {
				textAreaValue = textAreaValue.trim();
				r = dao.augment(textAreaValue);
				logger.debug("Set value to " + textReturnValue);
			} catch (final DataAccessException e) {
				alertManager.alert(Duration.SINGLE, Severity.ERROR,
						e.getMessage());
			}
		} else {
			alertManager.alert(Duration.SINGLE, Severity.INFO,
					"Please enter text to extract entities from.");
		}
		return request.isXHR() ? extractionZone.getBody() : null;
	}

	void onValidateFromAugmentTextForm() {
		r = null;
		currentEntity = null;
		if (!ValidationUtils.isValid(textAreaValue)) {
			form.recordError("Please enter text to extract entities from.");
		}
	}

	public void setupRender() {

	}
}