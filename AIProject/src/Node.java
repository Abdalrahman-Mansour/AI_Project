
public class Node implements Comparable<Node> {
	int id, driveRoute;
	Node parent;

	Node(int id, int driveRoute) {
		this.id = id;
		this.driveRoute = driveRoute;
	}

	@Override
	public String toString() {
		return id + " " + driveRoute;
	}

	@Override
	public int compareTo(Node node) {
		return driveRoute - node.driveRoute;
	}
}
