package com.kk.portal.client.app.ui.wireframe.decksholder;

import java.util.List;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.allen_sauer.gwt.dnd.client.drop.HorizontalPanelDropController;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.kk.portal.client.app.ui.widgets.DeckBox;
import com.kk.portal.client.app.ui.wireframe.FrameView;

public class DecksHolderView extends Composite implements FrameView<DecksHolderPresenter> {

	interface TabBarViewUiBinder extends UiBinder<AbsolutePanel, DecksHolderView> {}

	private static final TabBarViewUiBinder uiBinder = GWT.create(TabBarViewUiBinder.class);

	private DecksHolderPresenter presenter;

	@UiField
	AbsolutePanel wrapper;
	@UiField
	HorizontalPanel deckHolder;

	private final PickupDragController dragController;
	
	@UiConstructor
	public DecksHolderView() {
		wrapper = uiBinder.createAndBindUi(this);
		
		dragController = new PickupDragController(wrapper, false);
		dragController.setBehaviorConstrainedToBoundaryPanel(true);
		
		final HorizontalPanelDropController dropController = new HorizontalPanelDropController(deckHolder);
		dragController.registerDropController(dropController);
		
		initWidget(wrapper);
	}


	@Override
	public void setPresenter(final DecksHolderPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void initLayout() {
	}

	public void addTabs(final List<String> tabs) {
		DeckBox deckBox;
		for (final String tab : tabs) {
			final int index = tabs.indexOf(tab);
			
			deckBox = new DeckBox(tab);
			deckBox.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					presenter.handleTabSelection(index);
				}
			});
			deckHolder.add(deckBox);
			dragController.makeDraggable(deckBox, deckBox.getDragHandle());
		}
	}

	public void selectTab(final int selectedIndex) {
//		tabBar.selectTab(selectedIndex);
	}
}
