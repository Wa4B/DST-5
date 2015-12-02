
public class Hashtable {
	/*
	 * 길이가 6인 linkedlist의 array 를 만들어 초기화를 한다.
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
			return "존재하지 않음!";
		}
		
	}
	/*
	 * 키값을 받고 해당 hashFunction과 hasValue로 value[index]의 linkedlist가 비어있는지 아닌지 확인한다.
	 * 비어있거나 key값으로 검색하여 나온 value가 null 이면 "존재하지 않음!"을 return.
	 * 제대로 찾았다면, 형식에 맞춰 리턴.
	 */
	String getValue(String key){
		int index = 0;
		if(hasValue((index = hashFunction(key)))){
			if(value[index].getValue(key) == null){
				return "존재하지 않음!";
			}else{
				return "["+index+","+key+","+value[index].getValue(key)+"]";
			}
		}else{
			return "존재하지 않음!";
		}
	}
	/*
	 * key와 value를 key에 해당하는 hash코드를 index에 받아 this.value[index]에 insert(key,value)
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
