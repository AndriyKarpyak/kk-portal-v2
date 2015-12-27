package com.kk.portal.client.app.ui.module;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.kk.portal.client.app.ui.ApplicationView;
import com.kk.portal.client.app.ui.ApplicationViewFactory;
import com.kk.portal.client.app.ui.module.empty.EmptyModulePresenter;
import com.kk.portal.client.app.ui.module.empty.EmptyModuleView;
import com.kk.portal.client.app.ui.module.graph.GraphModulePresenter;
import com.kk.portal.client.app.ui.module.graph.GraphModuleView;
import com.kk.portal.client.app.ui.module.test_dnd.DNDTestModulePresenter;
import com.kk.portal.client.app.ui.module.test_dnd.DNDTestModuleView;
import com.kk.portal.client.app.ui.wireframe.FrameViewFactory;

public class ModuleViewFactory extends ApplicationViewFactory {

	@Inject
	EmptyModulePresenter empty;

	@Inject
	DNDTestModulePresenter dndTest;
	
	@Inject
	GraphModulePresenter garph;

	@Override
	@SuppressWarnings("unchecked")
	public <T extends ApplicationView<?> & IsWidget> T view(Class<T> viewType) {

		if (EmptyModuleView.class.equals(viewType)) {
			return (T) build(empty).view();
		} else if (DNDTestModuleView.class.equals(viewType)) {
			return (T) build(dndTest).view();
		}  else if (GraphModuleView.class.equals(viewType)) {
			return (T) build(garph).view();
		}

		throw new IllegalArgumentException("Add support of " + viewType.getName() + " in " + FrameViewFactory.class.getName() + "#view(..).");
	}

}
