
public class Run {
	public static void main(String args[]){
		
		AVLT avlt = new AVLT();
		
		int ins[] = {10,15,20,25,23,5,1,18,19};
		
		for(int i = 0; i < ins.length ; i++){
			avlt.insert(ins[i]);
			
		}
		avlt.print_preorder();
		avlt.print_preorder_diff();
		avlt.delete(1);
		avlt.print_preorder_diff();
		avlt.delete(10);
		avlt.print_preorder_diff();
		avlt.delete(5);
		avlt.print_preorder_diff();
		avlt.delete(30);
		avlt.print_preorder_diff();
		avlt.delete(18);
		avlt.print_preorder_diff();
		
		
		
		
		
		
		
	}
}
