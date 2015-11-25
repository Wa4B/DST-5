public class AVLT{

	private Node root;
	private class Node{
		private int height;
		private int key;
		private Node lchild;
		private Node rchild;
		Node (int key){
				this.key = key;
			}
		}
	
	
	private int balance(Node nd, Node ndP,int LR){//RL :nd�� ndP�� r���� l ���� ���� 0:�� 1:�� -1��Ʈ
		int height = 0;
		int heightR = 0;
		int heightL = 0;
		System.out.println(nd.key);
		if(nd.lchild != null){
			heightL = balance(nd.lchild,nd,0);
		}
		if(nd.rchild != null){
			heightR = balance(nd.rchild,nd,1);
		}
		
		if(heightR < heightL){
			height = heightL+1;
		}else{
			height = heightR+1;
		}
		
		
		if((LR == -1 &&nd  != root)||(LR == 0&&ndP.lchild != nd)||(LR == 1&&ndP.rchild != nd)){
			System.out.println("d");
			return height;
		}
		
		if(nd.height < height){
			nd.height = height;
		}
		
		if(heightL-heightR > 1){
			System.out.println(heightL+","+heightR+","+nd.key);
			Node ndT;
			if(nd.lchild.rchild != null&&nd.lchild.height == nd.lchild.rchild.height +1){
				
				ndT = nd.lchild.rchild;
				ndT.height +=1;
				nd.height -= 1;
				if(ndT.lchild != null){
					nd.lchild.rchild = ndT.lchild;
				}else{
					nd.lchild.rchild =null;
				}
				
				ndT.lchild = nd.lchild;
				if(ndT.rchild != null){
					nd.lchild = ndT.rchild;
				}else{
					nd.lchild =null;
				}
				ndT.rchild = nd;
				
				
			}else {
				
				ndT = nd.lchild;
				nd.height -=2;
				
				if(ndT.rchild != null){
					nd.lchild = ndT.rchild;
				}else{
					nd.lchild =null;
				}
				ndT.rchild = nd;
				
				
			}
			if(LR == -1){
				root = ndT;
			}else if(LR == 0){
				ndP.lchild = ndT;
			}else{
				ndP.rchild = ndT;
			}
		}else if(heightR - heightL > 1){
			System.out.println(heightL+","+heightR+","+nd.key);
			Node ndT;
			if(nd.rchild.lchild != null&&nd.rchild.height == nd.rchild.lchild.height +1){
				
				ndT = nd.rchild.lchild;
				ndT.height +=1;
				nd.height -= 1;
				if(ndT.rchild != null){
					nd.rchild.lchild = ndT.rchild;
				}else{
					nd.rchild.lchild =null;
				}
				
				ndT.rchild = nd.rchild;
				if(ndT.lchild != null){
					nd.rchild = ndT.lchild;
				}else{
					nd.rchild =null;
				}
				ndT.lchild = nd;
				
				
			}else {
				
				ndT = nd.rchild;
				nd.height -=2;
				
				if(ndT.lchild != null){
					nd.rchild = ndT.lchild;
				}else{
					nd.rchild =null;
				}
				ndT.lchild = nd;
				
				
			}
			nd = ndT;
			if(LR == -1){
				root = ndT;
			}else if(LR == 0){
				ndP.lchild = ndT;
			}else{
				ndP.rchild = ndT;
			}
		}
		
		
	
		
		return nd.height;
	}
	
	
	void insert(int key){
		Node nd = new Node(key);//���� key���� key������ �ϴ� ��� nd ����
		nd.height = 1;
		if(root == null){//��Ʈ�� null���϶� nd�� ��Ʈ�� ����
			root = nd;
		}else{
			Node sch = root;
			while(true){
				if(sch.key < nd.key){
					if(sch.rchild == null){
						sch.rchild = nd;
						break;
					}
					sch = sch.rchild;
					
				}else{
					if(sch.lchild == null){
						sch.lchild = nd;
						break;
					}
					sch = sch.lchild;
				}
			}
			balance(root,root,-1);
			
			
		}
	}
	/*
	private int insert_help(Node nd, Node newnode){
		int nheight = 1;
		if(nd.key < newnode.key){
			if(nd.rchild != null){
				nheight += insert_help(nd.rchild,newnode);
			}else{
				nd.rchild = newnode;
				if(nd.lchild == null){
					nheight += 1;
				}
			}
		}else{
			if(nd.lchild != null){
				nheight += insert_help(nd.lchild,newnode);
			}else{
				nd.lchild = newnode;
				if(nd.rchild == null){
					nheight += 1;
				}
			}
		}	
		if(nd.height < nheight){
			nd.height = nheight;
		}
		return nd.height;
	}
	*/
	void delete(int key){
		Node sch = root;//�˻��� ���1
		Node sch_parent = root;//�˻��� ���1�� �θ� ������ ���.
		Node nd;//������ ���
		boolean rl = false;//�¿� �˻�
		
		if(root.key == key){//������ ��尡 ��Ʈ���
			nd = delete_help(root);//�ش� �ڸ��� ���Ե� ��带 nd�� ����Ű�� �Ѵ�.
			
			if(root.rchild != nd){//�ڸ�����
				nd.rchild = root.rchild;
			}
			if(root.lchild != nd){
				nd.lchild = root.lchild;
			}
			root = nd;
		}else{//��Ʈ�� �ƴ϶��
			while(true){
				if( sch == null||sch.key == key ){
					break;
				}else if(sch.key < key){//sch�� Ű�� key�� ���Ͽ�, sch_parent��sch�� ����Ű�� ����, rl�� ����.
					sch_parent = sch;
					rl = false;
					sch = sch.rchild;
					
				}else{
					sch_parent = sch;
					rl = true;
					sch = sch.lchild;
				}
			}
			if(sch != null){//����Ʈ�� ��尡 �ִٸ�, �ش� ����� child�� ������ ���� ���� ������ ��带 �ش� ����� ��ġ�� �ű��.
				if(sch.rchild ==null &&sch.lchild == null){		
					if(rl){
						sch_parent.lchild = null;
					}else{
						sch_parent.rchild = null;
					}
				}else if((nd = delete_help(sch))!=null){
					
					if(sch.lchild != null &&sch.lchild.key != nd.lchild.key){
					
						nd.lchild = sch.lchild;
					}
					if( sch.rchild != null&&nd.rchild != null&&sch.rchild.key != nd.rchild.key){
						nd.rchild = sch.rchild;
					}		
					if(rl){
						sch_parent.lchild = nd;
					}else{	
						sch_parent.rchild = nd;
					}
				}
			}	
		}
		balance(root,root,-1);
	}
	
	private Node delete_help(Node nd){//��带 �޾� �ش� ����� lchild�� null�� �ƴϸ� lchild�� ���� ū child�� ����, lchild�� ������,rchild�� ���� ���� child�� ����.
		//���� �Ҷ� �ش� ����� �θ� ����� ������ �Ѵ�.
		Node sch_parent= nd;
		Node sch = nd;
		
		if(sch.lchild != null){
			
			sch = sch.lchild;
			while(true){
				
				if(sch.rchild != null){
					sch_parent = sch;
					sch = sch.rchild;
				}else{
					if(sch.lchild != null){
						if(sch_parent != nd){
							sch_parent.rchild = sch.lchild;
						}else{
							sch_parent.lchild = sch.lchild;
						}
						sch.lchild =null;
					}else{
						if(sch_parent != nd){
							sch_parent.rchild = null;
						}
					}
					break;
				}
			}
		}else if(sch.rchild != null){
		
			sch = sch.rchild;
			while(true){
				if(sch.lchild != null){
					sch_parent = sch;
					sch = sch.lchild;
				}else{
					if(sch.rchild != null){
						if(sch_parent != nd){
							sch_parent.lchild = sch.rchild;
						}else{
							sch_parent.rchild = sch.rchild;
						}
						sch.rchild =null;
					}else{
						if(sch_parent != nd){
							sch_parent.lchild = null;
						}
					}
					break;
				}
			}
		}else{
			sch = null;
		}
		
		return sch;
	}
	
	
	Node search(int key){
		Node sch = root;
		Node ret = null;
		
		while(true){
			if(sch == null){
				break;
			}
			if(sch.key == key){
				ret = sch;
				System.out.println(key + "����.");
				break;
			}else if(sch.key < key){
				sch = sch.rchild;
			}else{
				sch = sch.lchild;
			}
		}
		if(ret == null){
			System.out.println(key + "����.");
		}
		return ret;
	}
	
	private void order_tra(Node nd,int order,boolean diff){//��带 �ް� order(0: pre, 1:in, 2:post)�� �޾� ����Ʈ,
		if(nd != null){
			//System.out.print("("+nd.key+")");
			for(int i = 0 ; i < 3 ; i ++){
				if(order == i){
					System.out.print(nd.key);
					if(diff){
						int lh=0;
						int rh=0;
						if(nd.rchild != null){
							rh = nd.rchild.height;
						}
						if(nd.lchild != null){
							lh = nd.lchild.height;
						}
						
						System.out.print("("+lh+","+rh+")");
					}
					System.out.print(" ");
				}
				if(i ==0){
					order_tra(nd.lchild,order,diff);
				}else if(i == 1){
					order_tra(nd.rchild,order,diff);
				}
			}
		}
	}
	
	void print_preorder(){
		System.out.print("Preorder : ");
		order_tra(root,0,false);
		System.out.println();
	}
	void print_inorder(){
		System.out.print("Inorder : ");
		order_tra(root,1,false);
		System.out.println();
	}
	void print_postorder(){	
		System.out.print("Postorder : ");
		order_tra(root,2,false);
		System.out.println();
	}
	void print_preorder_diff(){
		System.out.print("Preorder_diff : ");
		order_tra(root,0,true);
		System.out.println();
	}
}