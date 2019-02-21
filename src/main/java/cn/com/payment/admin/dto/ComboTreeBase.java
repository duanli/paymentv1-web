package cn.com.payment.admin.dto;

import java.util.List;

public class ComboTreeBase {
	private String id;

	private String text;

	private String state;

	private List<ComboTreeBase> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<ComboTreeBase> getChildren() {
		return children;
	}

	public void setChildren(List<ComboTreeBase> children) {
		this.children = children;
	}

}
