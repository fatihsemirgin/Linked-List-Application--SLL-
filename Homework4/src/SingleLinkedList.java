import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SingleLinkedList {
	Node head;
	public void add(Object dataToAdd) {  			/// To add data in alphabetical order.
		if (head == null) { /// Ýlk elemaný ekleme
			Node newnode = new Node(dataToAdd);
			head = newnode;
		} else if ((dataToAdd.toString()).compareTo(head.getData().toString())<=-1) { /// Baþa ekleme(add to front)
			Node newnode = new Node(dataToAdd);
			newnode.setLink(head);
			head = newnode;
		}
		else {
			Node temp = head;
			Node previous=null;
			
			while(temp!=null && (dataToAdd.toString()).compareTo(temp.getData().toString())>=1){	///
				previous=temp;
				temp=temp.getLink();
			}
			if(temp==null) {	/// Listenin sonuna ekleme
				Node newnode = new Node(dataToAdd);
				previous.setLink(newnode);
			}
			else {		/// Listenin ortasýna ekleme
				Node newnode = new Node(dataToAdd);
				newnode.setLink(temp);
				previous.setLink(newnode);
			}		
		}
	}
	
	public void addtext(Object dataToAdd,Object point) {	///  To add the score and name obtained at the end of the game to the list.
		if (head == null) { /// Ýlk elemaný ekleme
			Node newnode = new Node(dataToAdd,point);
			head = newnode;
		} else if (Integer.parseInt(point.toString())  >= Integer.parseInt(head.getPoint().toString())) { /// Baþa ekleme(add to front)
			Node newnode = new Node(dataToAdd,point);
			newnode.setLink(head);
			head = newnode;
		}
		else {
			Node temp = head;
			Node previous=null;		
			while(temp!=null && Integer.parseInt(point.toString())<=Integer.parseInt(temp.getPoint().toString())){
				previous=temp;
				temp=temp.getLink();
			}
			if(temp==null) {	/// Listenin sonuna ekleme
				Node newnode = new Node(dataToAdd,point);
				previous.setLink(newnode);
			}
			else {		/// Listenin ortasýna ekleme
				Node newnode = new Node(dataToAdd,point);
				newnode.setLink(temp);
				previous.setLink(newnode);
			}
			
		}
	}
	
	public void add2(Object dataToAdd) {	///  To add to the end regardless of size or smallness.(Ex: Wheel list)
		if (head == null) { /// Ýlk elemaný ekleme
			Node newnode = new Node(dataToAdd);
			head = newnode;
		}
		else {
			Node temp = head;
			while(temp.getLink()!=null)
				temp=temp.getLink();
			Node newnode = new Node(dataToAdd);
			temp.setLink(newnode);
		}	
	}
	public void add3(int i,String s) {		///  To place the guessed letter in its place in the closed word.
		int count=1;
		Node temp=head;
		while(temp!=null) {
			if(i==count) {
				temp.setData(s);
			}
			temp=temp.getLink();
			count++;
		}
	}
	public void delete(Object dataToDelete,Object pointToDelete) {	/// To delete an element from the list.
		if(head==null)
			System.out.println("Linked List Empty!");
		else {
			if(pointToDelete!=null) {
				while(head!=null&&head.getData().toString().equalsIgnoreCase(dataToDelete.toString())&& head.getPoint().toString().equalsIgnoreCase(pointToDelete.toString())) {
					head=head.getLink();
				}
			}
			else {
				while(head!=null&&head.getData().toString().equalsIgnoreCase(dataToDelete.toString())) {
					head=head.getLink();
				}
			}		
			Node temp=head;
			Node previous=null;
			while(temp!=null) {
				if(pointToDelete!=null) {
					if(temp.getData().toString().equalsIgnoreCase(dataToDelete.toString()) && temp.getPoint().toString().equalsIgnoreCase(pointToDelete.toString())) {
						previous.setLink(temp.getLink());
						temp=previous;
					}
				}
				else {
					if(temp.getData().toString().equalsIgnoreCase(dataToDelete.toString())) {
						previous.setLink(temp.getLink());
						temp=previous;
					}
				}		
				previous=temp;
				temp=temp.getLink();
			}
		}
	}
	public void deletelast() {		///  To delete the last element in the list.(Ex:SLL5)For top 10 score.
		if(head==null)
			System.out.println("Linked List Empty!");
		else {
			Node temp=head;
			Node temp2 = null;
			Node previous=null;
			while(temp!=null) {
				temp2=temp;			
				temp=temp.getLink();
			}
			temp=head;
			while(temp!=null) {
				if(temp2==temp) {
					previous.setLink(temp.getLink());
					temp=previous;
				}
				previous=temp;
				temp=temp.getLink();
			}
		}
	}
	public void printList() {		/// To print list.
		if(head==null)
			System.out.println("Linked List Empty!");
		else {
			Node temp=head;
			while(temp!=null) {
				if(temp.getPoint()!=null) {		
					System.out.print(temp.getData()+"	"+temp.getPoint()+"\n");	/// If node has a point.
				}
				else
					System.out.print(temp.getData()+"  ");
				temp=temp.getLink();
			}
		}
	}
	
	public String lastelement(String rcv) {		/// Returns the data or point of the last element of the list.
		Node temp = null;						/// I stopped using this method due to changes in code.
		String temp2 = null;
		if(head==null)
			System.out.println("Linked List Empty!");
		else {
			temp=head;
			if(temp.getPoint()!=null) {
				while(temp!=null) {
					if(rcv.equalsIgnoreCase("data"))
						temp2=temp.getData().toString();
					else if(rcv.equalsIgnoreCase("point"))
						temp2=temp.getPoint().toString();
					temp=temp.getLink();
				}
			}
			else {
				while(temp!=null) {
					temp2=temp.getData().toString();
					temp=temp.getLink();
				}
			}			
		}
		return   temp2;
	}
	public int size() {		/// For the size of the list. 
		int count=0;
		if(head==null)
			System.out.println("Linked List Empty!");
		else {
			Node temp=head;
			while(temp!=null) {
				count++;
				temp=temp.getLink();
			}
			return count;
		}
		return 0;
	}
	public String searching(int item) {		/// To select random element from the list.
		Node temp=null;						/// The random position(number) taken as a parameter takes the data at that position in the list.
		int count=1;
		if(head==null)
			System.out.println("Linked list is empty!");
		else {
			temp=head;
			while(temp!=null) {
				if(item==count)
					break;
				temp=temp.getLink();
				count++;			
			}
		}
		return (String) temp.getData();
	}
	public int searching2(String ch) {		///  Returns the position of the random letter in the closed word.
		int count=0;
		int count2=-1;						///  -1 means there are no predictive letters in the word.
		if(head==null)
			System.out.println("Linked list is empty!");
		else {
			Node temp=head;
			while(temp!=null){
				count++;
				if(ch.equalsIgnoreCase(temp.getData().toString())) {
					count2=count;
					temp.setData("_"); 	/// For the case of more than one same letter in the word.
					break;
				}
				temp=temp.getLink();
			}
		}
		return count2;
	}
	public int sameNumberCount(String ch) {		///	Returns the total number of random letters in the closed word.
		int count=0;
		if(head==null)
			System.out.println("Linked list is empty!");
		else {
			Node temp=head;
			while(temp!=null) {
				if(ch.equalsIgnoreCase(temp.getData().toString()))
					count++;
				temp=temp.getLink();
			}
		}
		return count;
	}
	public String combination() {		///  To check that the closed word is the same as the word that needs to be guessed by combining the word when it is completed.(For the end game) 
		String combination=""; 			
		if(head==null)
			System.out.println("Linked list is empty!");
		else {
			Node temp=head;
			while(temp!=null) {
				combination+=temp.getData();
				temp=temp.getLink();
			}
		}
		return combination;
	}
	
	public void writeToFile(String path) throws IOException {		///  To write the list of names and scores to the file.(Ex: SLL3)
		File file = new File(path);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fileWriter = new FileWriter(file, false);
		BufferedWriter bWriter = new BufferedWriter(fileWriter);
		if(head==null)
			System.out.println("Linked list is empty!");
		else {
			Node temp = head;
			while(temp!=null) {
				bWriter.write(temp.getData().toString());
				bWriter.newLine();
				bWriter.write(temp.getPoint().toString());		
				temp=temp.getLink();
				if(temp!=null)
					bWriter.newLine();		
			}
		}	
		bWriter.close();
	}
}
