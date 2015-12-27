package com.kk.portal.client.app.ui.wireframe;

import com.google.gwt.user.client.ui.IsWidget;
import com.kk.portal.client.app.ui.ApplicationPresenter;

@SuppressWarnings("rawtypes")
public abstract class FramePresenter<T extends FrameView & IsWidget, H extends FrameService> extends ApplicationPresenter<T, H> {}
