package classpackage;

public class BBS {
	int id;
	String title;
	String content;
	String writer;
	
	public void write(int id, String title, String content, String writer) {
		if(this.id == 0)
		{
			this.id = id;
			this.title = title;
			this.content = content;
			this.writer = writer;
		}
	}
	public void delete() {
		id = 0;
		title = null;
		content = null;
		writer = null;
	}
	public void read() {
		System.out.println(id + "\t" + title + "\t" + content + "\t" + writer);
	}
	public void modify(String title, String content, String writer) {
		if(id!=0) {
			this.title = title != null ? title : this.title;
			this.content = content != null ? content : this.content;
			this.writer = writer != null ? writer : this.writer;
		}
	}

}
