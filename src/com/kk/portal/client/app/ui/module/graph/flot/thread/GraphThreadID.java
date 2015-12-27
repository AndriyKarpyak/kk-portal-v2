package com.kk.portal.client.app.ui.module.graph.flot.thread;

public class GraphThreadID {

	public final String firstKey;
	public final String secondKey;

	public GraphThreadID(final String firstKey, final String secondKey) {
		this.firstKey = firstKey;
		this.secondKey = secondKey;
	}

	@Override
	public String toString() {
		return "ThreadId [firstKey=" + firstKey + ", secondKey=" + secondKey + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstKey == null) ? 0 : firstKey.hashCode());
		result = prime * result + ((secondKey == null) ? 0 : secondKey.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final GraphThreadID other = (GraphThreadID) obj;
		if (firstKey == null) {
			if (other.firstKey != null)
				return false;
		} else if (!firstKey.equals(other.firstKey))
			return false;
		if (secondKey == null) {
			if (other.secondKey != null)
				return false;
		} else if (!secondKey.equals(other.secondKey))
			return false;
		return true;
	}
}
