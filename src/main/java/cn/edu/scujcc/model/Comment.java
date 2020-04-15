package cn.edu.scujcc.model;

import java.time.LocalDateTime;

/**
 * ���۶���
 * @author 13696281798
 *
 */
public class Comment {
    /**
     * ��������
     */
	private String author;
	/**
	 * ��������
	 */
	private String content;
	/**
	 * ��������ʱ��
	 */
	private LocalDateTime dt = LocalDateTime.now();
	/**
	 * ���۵�������
	 */
	private int star;
	public String getAuthor() {
		return author;
	}
	
	@Override
	public String toString() {
		return "Comment [author=" + author + ", content=" + content + ", dt=" + dt + ", star=" + star + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((dt == null) ? 0 : dt.hashCode());
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
		Comment other = (Comment) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (dt == null) {
			if (other.dt != null)
				return false;
		} else if (!dt.equals(other.dt))
			return false;
		return true;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getDt() {
		return dt;
	}
	public void setDt(LocalDateTime dt) {
		this.dt = dt;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
