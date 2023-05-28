package lab10_1;

public class Main_202114024 {
	public static void main(String[] args) {
		System.out.println("lab10_1:최혜승");

		// 정점은 6개이고 간선은 없는 방향 그래프 생성
		MatrixGraph graph = new MatrixGraph(6);  

		// 7개의 간선 삽입 후 인접행렬 출력
		graph.insertEdge(0, 1);
		graph.insertEdge(0, 2);
		graph.insertEdge(0, 4);
		graph.insertEdge(0, 5);
		graph.insertEdge(3, 2);
		graph.insertEdge(5, 0);
		graph.insertEdge(5, 1);
		graph.printAdjMatrix();
	}
}

// 인접행렬로 그래프를 구현하는 클래스 
class MatrixGraph {  
	// 인스턴스 변수
	private int[][] matrix;
	private int n;

	// 생성자 - 정점이 n개이고, 간선이 없는 그래프 생성
	public MatrixGraph(int n) {
		this.matrix = new int[n][n];
		this.n = n;

	}

	// 그래프에 간선 <v1, v2> 삽입
	public void insertEdge(int v1, int v2) {   
		if(v1<0 || v1>=n || v2<0 || v2>=n)  
			System.out.println("그래프에 없는 정점입니다!!");
		else {
				matrix[v1][v2] = 1;
			}
	}
	// 구현을 확인하기 위해 인접행렬 출력
	public void printAdjMatrix() {  
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {  
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}