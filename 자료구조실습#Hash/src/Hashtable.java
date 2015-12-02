
public class Hashtable {
	/*
	 * ���̰� 6�� linkedlist�� array �� ����� �ʱ�ȭ�� �Ѵ�.
	 * */
	LinkedList[] value = new LinkedList[6];
	Hashtable(){
		for(int i = 0 ; i < 6; i++){
			value[i] = new LinkedList();
		}
	}
	
	
	
	int hashFunction(String key){
		
		return key.length()%6;
	}
	String getValue(int index){
		if(hasValue(index)){
			return "["+index+","+value[index].getKey()+","+value[index].getValue()+"]";
		}else{
			return "�������� ����!";
		}
		
	}
	/*
	 * Ű���� �ް� �ش� hashFunction�� hasValue�� value[index]�� linkedlist�� ����ִ��� �ƴ��� Ȯ���Ѵ�.
	 * ����ְų� key������ �˻��Ͽ� ���� value�� null �̸� "�������� ����!"�� return.
	 * ����� ã�Ҵٸ�, ���Ŀ� ���� ����.
	 */
	String getValue(String key){
		int index = 0;
		if(hasValue((index = hashFunction(key)))){
			if(value[index].getValue(key) == null){
				return "�������� ����!";
			}else{
				return "["+index+","+key+","+value[index].getValue(key)+"]";
			}
		}else{
			return "�������� ����!";
		}
	}
	/*
	 * key�� value�� key�� �ش��ϴ� hash�ڵ带 index�� �޾� this.value[index]�� insert(key,value)
	 * */
	
	void setValue(String key,String value){
		int index = hashFunction(key);
		this.value[index].insert(key, value);
	}
	boolean hasValue(int index){
		if(value[index].isEmpty()){
			return false;
		}else{
			return true;
		}
	}
	void showAll(){
		for(int i = 0 ; i < value.length ; i ++){
			System.out.print(value[i].print_list(i));
		}
	}
}
