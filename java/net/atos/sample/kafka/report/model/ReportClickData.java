package net.atos.sample.kafka.report.model;

import java.io.Serializable;

public class ReportClickData implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tagType;

	private String content;

	public String getTagType() {
		return tagType;
	}

	public void setTagType(String tagType) {
		this.tagType = tagType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ReportClickData{" + "tagType='" + tagType + '\'' + ", content='" + content + '\'' + '}';
	}
}
