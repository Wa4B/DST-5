
public class LinkedList {
	private Node head;
	private int count;
	private class Node{
		String key;
		String value;
		Node next;
		Node(String key,String value){
			this.key = key;
			this.value = value;
		}
	}
	
	public void insert(String key, String value){
		
		if(count == 0){				//pos가 0일때 head로 설정
			Node n1 = new Node(key,value);
			head = n1;
			count+=1;
		}else{
			Node s = head;
			Node nd = new Node(key,value);
			while(s.next != null){
				s = s.next;
			}
			s.next= nd;
			count+=1;
		}
	}
	
	public void delete(String key){
		Node sch = head;
		if(head.key == key){
			head = sch.next;
		}else{
			while(sch.next !=null&&sch.next.key != key ){
				sch = sch.next;
			}
			if(sch.next.key == key){
				sch.next = sch.next.next;
			}
		}
	}
	public String print_list(int index){
		Node s = head;
		String str = "";
		if(count == 0){
			str = "["+index+",null]";
		}else{
			for(int i = 0 ; i < count; i +=1){
				str += "["+index+","+s.key+","+s.value+"]";
				
				s = s.next;
			}
		}
		return str;
	}
	public void get_data(String key){
		Node s = head;
		for(int i = 0 ; i < count; i +=1){
			if(s.key == key){
				break;
			}
			s = s.next;
		}
		System.out.print(s.value);
	}
	public boolean isEmpty(){
		if(count >0){
			return false;
		}else{
			return true;
		}
	}
	public String getKey(){
		Node s = head;
		while(s.next != null)s = s.next;
		
		return s.key;
	}
	public String getValue(String key){
		Node s = head;
		while(s.next != null&&s.key != key)s = s.next;
		if(s.key == key){
			return s.value;
		}else{
			return null;
		}
	}
	public String getValue(){
		Node s = head;
		while(s.next != null)s = s.next;
		
		return s.value;
	}
	
	
	
}
