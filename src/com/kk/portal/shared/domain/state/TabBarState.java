package com.kk.portal.shared.domain.state;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TabBarState {

	@JsonProperty
	private List<String> tabs;
	
	@JsonProperty
	private int selectedIndex;

	public List<String> getTabs() {
		return tabs;
	}

	public void setTabs(List<String> tabs) {
		this.tabs = tabs;
	}

	public int getSelectedIndex() {
		return selectedIndex;
	}

	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = selectedIndex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + selectedIndex;
		result = prime * result + ((tabs == null) ? 0 : tabs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TabBarState other = (TabBarState) obj;
		if (selectedIndex != other.selectedIndex)
			return false;
		if (tabs == null) {
			if (other.tabs != null)
				return false;
		} else if (!tabs.equals(other.tabs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TabBar [tabs=" + tabs + ", selectedIndex=" + selectedIndex + "]";
	}
}
