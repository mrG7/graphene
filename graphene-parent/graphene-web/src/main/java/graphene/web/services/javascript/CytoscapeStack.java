/**
 * 
 */
package graphene.web.services.javascript;

import java.util.Collections;
import java.util.List;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.func.F;
import org.apache.tapestry5.func.Mapper;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.AssetSource;
import org.apache.tapestry5.services.javascript.JavaScriptStack;
import org.apache.tapestry5.services.javascript.StylesheetLink;
import org.got5.tapestry5.jquery.JQuerySymbolConstants;
import org.got5.tapestry5.jquery.utils.JQueryUtils;

/**
 * @author djue
 * 
 */
public class CytoscapeStack implements JavaScriptStack {
	public static final String STACK_ID = "CytoscapeStack";
	private final List<Asset> javaScriptStack;
	private final List<StylesheetLink> cssStack;
	
	public CytoscapeStack(
			@Symbol(JQuerySymbolConstants.USE_MINIFIED_JS) final boolean minified,
			final AssetSource assetSource) {

		final Mapper<String, Asset> pathToAsset = new Mapper<String, Asset>() {
			public Asset map(String path) {
				return assetSource.getExpandedAsset(path);
			}
		};
		
		javaScriptStack = F.flow(
			"context:core/js/libs/cytoscape.js-2.3.9/cytoscape.js",
			"context:core/js/libs/cytoscape.js-2.3.9/lib/arbor.js",
			"context:core/js/libs/cytoscape-plugins/cytoscape.js-cxtmenu.js"
			//"context:core/js/libs/cytoscape/jquery.cytoscape-navigator.js",
			//"context:core/js/libs/cytoscape/jquery.cytoscape-edgehandles.js",
			//"context:core/js/libs/cytoscape/jquery.cytoscape-panzoom.js"
		)
		.append("context:core/js/t5/T5CytoscapeGraph.js")
		.map(pathToAsset).toList();

		final Mapper<String, StylesheetLink> pathToStylesheetLink = F.combine(
			pathToAsset, JQueryUtils.assetToStylesheetLink
		);
		
		cssStack = F.flow(
			"context:core/css/cytoscapeT5.css"
			//"context:core/js/libs/cytoscape/jquery.cytoscape-navigator.css",
			//"context:core/js/libs/cytoscape/jquery.cytoscape-panzoom.css"
		)
		.map(pathToStylesheetLink).toList();
	}

	public String getInitialization() {
		return null;
	}

	public List<Asset> getJavaScriptLibraries() {
		return javaScriptStack;
	}

	public List<StylesheetLink> getStylesheets() {
		return cssStack;
	}

	public List<String> getStacks() {
		return Collections.emptyList();
	}
}
