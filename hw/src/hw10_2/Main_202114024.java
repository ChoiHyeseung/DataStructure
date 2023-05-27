package hw10_2;

public class Main_202114024 {
	public static void main(String[] args) {
		System.out.println("hw10_2: 최혜승");

		// (1)정점은 6개이고 간선은 없는 방향 그래프 생성
		ListGraph graph = new ListGraph(6);  

		// (2)7개의 간선 삽입 후 인접행렬 출력
		graph.insertEdge(0, 1);
		graph.insertEdge(0, 2);
		graph.insertEdge(0, 4);
		graph.insertEdge(0, 5);
		graph.insertEdge(3, 2);
		graph.insertEdge(5, 0);
		graph.insertEdge(5, 1);

		graph.printAdjList();
		
		// (3) 그래프 모든 정점에 대해 각 정점의 진출차수 출력
		for(int i = 0; i < 6; i++) {
			System.out.print(graph.outDegree(i) + " ");
		}

		System.out.println();

		// (4) 다음 7개의 간선에 대해 간선의 존재 여부 출력
		System.out.print(graph.hasEdge(5, 1) + " ");
		System.out.print(graph.hasEdge(1, 2) + " ");
		System.out.print(graph.hasEdge(0, 3) + " ");
		System.out.print(graph.hasEdge(0, 2) + " ");
		System.out.print(graph.hasEdge(0, 1) + " ");
		System.out.print(graph.hasEdge(0, 5) + " ");
		System.out.print(graph.hasEdge(3, 2) + " ");
		
		// (5) 다음 6개의 간선 삭제
		graph.deleteEdge(0, 3);
		graph.deleteEdge(1, 2);
		graph.deleteEdge(0, 2);
		graph.deleteEdge(0, 1);
		graph.deleteEdge(0, 5);
		graph.deleteEdge(3, 2);

		System.out.println();
		
		// (6) 인접리스트 출력
		graph.printAdjList();
	}
}

// 인접행렬로 그래프를 구현하는 클래스 
class ListGraph {  
	private class Node{ //단순 연결 리스트 노드 구조
		int vertex; // 정점필드
		Node link; // 다음 노드를 가르키며 간선을 표현할 링크 필드
	}
	
	private Node[] list; // 인접리스트를 표현하는 노드형 변수 배열
	private int n; // 정점의 개수
	
	// 생성자 : 정점이 n개이고, 간선이 없는 그래프 생성
	public ListGraph(int n) { 
		this.n = n; // 매개변수로 받은 정점의 개수 초기화
		list = new Node[n]; // 정점의 개수 만큼의 노드형 변수 배열 생성
	}

	// 간선을 매개변수 받아 그래프에 간선 <v1, v2> 삽입
	public void insertEdge(int v1, int v2) {   
		Node newNode = new Node(); // 새로운 노드 생성
		newNode.vertex = v2; // 새 노드에 정점필드에 v2 대입
		
		/* 정점 v1에 해당하는 노드형 배열에 대한 간선을 표현하기 위해, 
		위에서 만든 새 노드의 링크필드에 v1리스트를 대입하고
	 	v1리스트가 그 노드를 가르키면서 맨 앞에 삽입 */
		newNode.link = list[v1]; 
		list[v1] = newNode;
	}

	// 정점을 매개변수로 받아 진출차수 리턴
	// 정점에 대한 리스트의 노드 개수가 진출차수(out-degree)
	public int outDegree(int v1) {
		Node temp = new Node(); //연결리스트를 순회할 임시 노드 변수 생성
		temp = list[v1]; //temp는 매개변수로 받은 정점의 리스트를 가르킴
		int count = 0; //진출 차수를 세는 count 변수 초기화
		while(temp != null) { //연결리스트의 끝까지 반복
			count++; //count 증가
			temp = temp.link; //다음 노드를 가르킴
		}
		return count; //진출 차수 리턴
	}
	
	// 간선을 매개변수로 받아 존재 여부(true/false) 리턴
	public boolean hasEdge(int v1, int v2) {
		Node temp = new Node(); //연결리스트를 순회할 임시 노드형 변수 temp 생성 
		temp = list[v1]; //매개변수로 받은 정점의 리스트를 가르킴
		while(temp != null) { //연결리스트 끝까지 반복
			if(temp.vertex == v2) { //만약 노드의 정점 필드가 매개변수로 받은 정점과 일치한다면
				return true; //간선이 존재하는 것이므로 true를 리턴
			}
			else {
				temp = temp.link; //같지 않다면 다음 노드를 가르킴
			}

		}
		return false; //끝까지 탐색해도 해당 간선이 존재하지 않는다면 false리턴

	}

	// 없으면 삭제하지 말아야함
	// 직전 노드가 없을 수도 있음
	// 간선을 매개변수로 받아 삭제
	public void deleteEdge(int v1, int v2) {
	    Node old = list[v1]; //삭제할 노드를 가르킬 old 노드변수는 매개변수로 받은 정점의 리스트를 가르킴
	    Node pre = null; // 삭제할 노드의 직전 노드를 가르킬 pre 변수는 null로 초기화

	    while (old != null) { //연결리스크 끝까지 반복
	        if (old.vertex == v2) { //삭제할 노드의 정점필드가 매개변수로 받은 정점과 일치한다면
	            if (pre == null) { // 삭제할 노드가 맨 앞 노드라면
	                list[v1] = old.link; // 리스트는 삭제할 노드의 다음 노드를 가르킴
	            } else { //삭제할 노드가 맨 앞노드가 아니라면
	                pre.link = old.link; //삭제할 노드의 직전 노드가 삭제할 노드의 다음 노드를 가르킴(old가 가르키는 노드는 연결 끊김)
	            }
	            break; // 해당 간선을 찾았으므로 반복문 종료
	        }
	        // 현재 old가 가르키는 노드의 정점 필드가 삭제할 간선이 아니라면
	        pre = old; // 직전 노드는 현재 old가 가르키는 노드를 가르킴
	        old = old.link; // 삭제할 노드를 탐색하기 위해 다음 노드로 이동하고 반복
	    }
	    // 해당 간선을 찾지 못했다면 아무 일도 일어나지 않음
	}

	// 구현을 확인하기 위해 인접행렬 출력
	public void printAdjList() {  
		for(int i=0; i<n; i++) { // 정점의 개수만큼 반복
			System.out.print("정점 " + i + "의 인접리스트"); //정점 출력
			// 연결리스트를 순회할 temp 변수는 각 정점의 리스트를 가르키고 temp가 연결리스트의 끝까지 반복
			for(Node temp = list[i]; temp!=null; temp = temp.link) { 
				System.out.print("-> " + temp.vertex); // 간선 정보를 출력, 출력이 끝나면 다음 temp는 다음 노드를 가르키고 반복
			}
			System.out.println();
		}
	}
}