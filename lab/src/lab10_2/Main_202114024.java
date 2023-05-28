package lab10_2;

public class Main_202114024 {
	public static void main(String[] args) {
		System.out.println("lab10_2:최혜승");

		// 정점은 6개이고 간선은 없는 방향 그래프 생성
		ListGraph graph = new ListGraph(6);  

		// 7개의 간선 삽입 후 인접행렬 출력
		graph.insertEdge(0, 1);
		graph.insertEdge(0, 2);
		graph.insertEdge(0, 4);
		graph.insertEdge(0, 5);
		graph.insertEdge(3, 2);
		graph.insertEdge(5, 0);
		graph.insertEdge(5, 1);

		graph.printAdjList();
	}
}

// 인접행렬로 그래프를 구현하는 클래스 
class ListGraph {  
	private class Node{
		int vertex;
		Node link;
	}

	private Node[] list;
	private int n;

	public ListGraph(int n) { //생성자
		list = new Node[n];
		this.n = n;
	}

	public void insertEdge(int v1, int v2) { //간선 삽입
		Node newNode = new Node();
		newNode.vertex = v2;
		newNode.link = list[v1];
		list[v1] = newNode;
	}

	public void printAdjList() { // 인접 리스트를 모두 출력 
		for(int i=0; i<n; i++) {
			System.out.print("정점 " + i + "의 인접리스트"); for(Node temp = list[i]; temp != null; temp = temp.link) {
				System.out.print(" -> "+ temp.vertex); 
			}
			System.out.println(); 
		}
	}
}