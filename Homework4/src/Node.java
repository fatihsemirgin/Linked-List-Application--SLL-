
public class Node {
	private Object data;
	private Object point;
	private Node link;
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data=data;
	}
	public Node getLink() {
		return link;
	}
	public void setLink(Node link) {
		this.link=link;
	}
	public Object getPoint() {
		return point;
	}
	public void setPoint(Object point) {
		this.point = point;
	}
	
	public Node(Object dataToAdd) {
		this.data = dataToAdd;
		this.link=null;
	}
	public Node(Object dataToAdd,Object point) {
		this.data=dataToAdd;
		this.point=point;
		this.link=null;
	}
	
	
}
