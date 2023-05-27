package hw10_1;

// 인접행렬로 구현한 그래프 연산
public class Main_202114024 {
	public static void main(String[] args) {
		System.out.println("hw10_1:최혜승");

		// (1)정점은 6개이고 간선은 없는 방향 그래프 생성
		MatrixGraph graph = new MatrixGraph(6);  

		// (2) 7개의 간선 삽입 후 인접행렬 출력
		graph.insertEdge(0, 1);
		graph.insertEdge(0, 2);
		graph.insertEdge(0, 4);
		graph.insertEdge(0, 5);
		graph.insertEdge(3, 2);
		graph.insertEdge(5, 0);
		graph.insertEdge(5, 1);

		graph.printAdjMatrix();
		
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
		System.out.println(graph.hasEdge(3, 2));
		
		// (5) 다음 4개의 간선 삭제
		graph.deleteEdge(0, 2);
		graph.deleteEdge(0, 1);
		graph.deleteEdge(0, 5);
		graph.deleteEdge(3, 2);
		
		// (6) 인접행렬 출력
		graph.printAdjMatrix();
	}
}

// 인접행렬로 그래프를 구현하는 클래스 
class MatrixGraph {  
	// 인스턴스 변수
	private int[][] matrix; // 인접행렬
	private int n;// vertex 정점의 개수

	// 생성자 - 정점이 n개이고, 간선이 없는 그래프 생성
	public MatrixGraph(int n) {
		this.matrix = new int[n][n]; // 정점 n개의 n * n 인접행렬(정방행렬 초기화)
		this.n = n; // 정점의 개수 초기화

	}

	// 그래프에 간선 <v1, v2> 삽입
	public void insertEdge(int v1, int v2) {   
		if(v1<0 || v1>=n || v2<0 || v2>=n)  // 정점이 0보다 작거나 정점이 존재하는 정점의 범위를 초과한다면
			System.out.println("그래프에 없는 정점입니다!"); //없는 정점이라고 출력
		else { // 그렇지 않다면
			matrix[v1][v2] = 1; // 인접행렬에 삽입(0에서 1로 변경)
		}
	}

	//진출 차수 : 매개변수 정점의 행의 합
	//	outDegree - 정점을 매개변수로 받아 진출차수를 리턴
	public int outDegree(int v1) {
		int outDegree = 0; // 진출 차수 초기화
		for(int i = 0; i < n; i ++) { // 매개변수 정점의 개수만큼 반복 
			outDegree += matrix[v1][i]; // 행의 합 구하기
		}
		return outDegree; //행의 합(진출 차수) 리턴
	}

	//	hasEdge - 간선을 매개변수로 받아 존재 여부(true/false)를 리턴
	public boolean hasEdge(int v1,int v2) {
		if(matrix[v1][v2] == 1) // 만약 매개변수로 받은 간선의 값이 1이라면
			return true; // 간선이 존재하는 것이므로 true를 리턴
		else return false; // 존재하지 않다면 false 리턴
	}

	//	deleteEdge - 간선을 매개변수로 받아 삭제
	public void deleteEdge(int v1, int v2) {
		matrix[v1][v2] = 0; // 매개변수로 받은 간선 삭제
		// 간선이 존재하면 1이므로 0을 대입
	}

	// 구현을 확인하기 위해 인접행렬 출력
	public void printAdjMatrix() {  
		for(int i=0; i<n; i++) { //정방행렬이므로 정점의 개수만큼 반복
			for(int j=0; j<n; j++) {  
				System.out.print(matrix[i][j] + " "); //인접 행렬 출력
			}
			System.out.println();
		}
	}
}