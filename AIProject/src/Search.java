import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Search {
	public static ArrayList<City> orderOfCityExpansionList = new ArrayList<City>();
	static ArrayList<City> Path = new ArrayList<City>();
	static ArrayList<Integer> visitedIds = new ArrayList<Integer>();
	static City Goal = null;
	static Stack<City> reversePath = new Stack<>();

	public static ArrayList<City> Greedy(int startId, ArrayList<Integer> goalsId) {
		clearOldData(resetAll);
		PriorityQueue<City> Fringe = new PriorityQueue<>();
		City startCity = new City(startId, 0, minHeurestic(startId, goalsId), null);
		Fringe.add(startCity);
		visitedIds.add(startCity.getId());
		while (Fringe.size() > 0) {
			City current = Fringe.poll();
			orderOfCityExpansionList.add(current);
			if (goalsId.contains(current.getId())) {
				Goal = current;
				break;
			}
			for (int i = 0; i < Main.PathCost[current.getId()].size(); i++) {
				City newCity = new City(Main.PathCost[current.getId()].get(i).id,
						current.getCost() + Main.PathCost[current.getId()].get(i).driveRoute,
						minHeurestic(Main.PathCost[current.getId()].get(i).id, goalsId), current);
				Fringe.add(newCity);
				visitedIds.add(newCity.getId());
			}
		}
		return reversePathFound(Goal, Path);
	}

	public static ArrayList<City> IterativeDeepening(int startId, ArrayList<Integer> goalsId) {
		clearOldData(resetAll);
		Queue<City> Fringe = new LinkedList<>();
		Fringe.add(new City(startId, 0, minHeurestic(startId, goalsId), null));
		City current = Fringe.poll();
		orderOfCityExpansionList.add(current);
		int depth = 0;
		while (true) {
			Goal = DLS(current, depth, goalsId, Fringe);
			if (Goal != null)
				break;
			depth++;
			Fringe.clear();
		}
		return reversePathFound(Goal, Path);
	}

	static City DLS(City current, int depth, ArrayList<Integer> goalsId, Queue<City> Fringe) {
		if (depth == 0)
			for (int i = 0; i < goalsId.size(); i++)
				if (current.getId() == goalsId.get(i))
					return current;
		if (depth > 0) {
			for (int i = 0; i < Main.PathCost[current.getId()].size(); i++) {
				City city = new City(Main.PathCost[current.getId()].get(i).id,
						current.getCost() + Main.PathCost[current.getId()].get(i).driveRoute,
						minHeurestic(Main.PathCost[current.getId()].get(i).id, goalsId), current);
				Fringe.add(city);
				orderOfCityExpansionList.add(city);
				City Found = DLS(city, depth - 1, goalsId, Fringe);
				if (Found != null)
					return Found;
			}
		}
		return null;
	}

	public static ArrayList<City> Optimal1AllGoals(int startId, ArrayList<Integer> goalsId) {
		clearOldData(resetAll);
		ArrayList<City> overallPath = new ArrayList<City>();
		Queue<City> temp = new LinkedList<>();
		ArrayList<Integer> goalsIdTemp = new ArrayList<Integer>();
		goalsIdTemp.addAll(goalsId);
		int currentId = startId;
		int currentCost = 0;
		while (goalsIdTemp.size() != 0) {
			temp.clear();
			resetAll = false;
			temp.addAll(uniformCost(currentId, goalsIdTemp));
			if (!overallPath.isEmpty()) {
				temp.remove();
				currentCost = overallPath.get(overallPath.size() - 1).getCost();
			}
			while (!temp.isEmpty()) {
				temp.peek().setCost(temp.peek().getCost() + currentCost);
				currentId = temp.peek().getId();
				overallPath.add(temp.remove());
			}
			goalsIdTemp.remove(goalsIdTemp.indexOf(currentId));
		}
		return overallPath;
	}

	public static ArrayList<City> uniformCost(int startId, ArrayList<Integer> goalsId) {
		clearOldData(resetAll);
		PriorityQueue<City> Fringe = new PriorityQueue<>();
		City startCity = new City(startId, 0, 0, null);
		Fringe.add(startCity);
		visitedIds.add(startCity.getId());
		while (Fringe.size() > 0) {
			City current = Fringe.poll();
			if (resetAll)
				orderOfCityExpansionList.add(current);
			else
				resetAll = true;
			if (goalsId.contains(current.getId())) {
				Goal = current;
				break;
			}
			for (int i = 0; i < Main.PathCost[current.getId()].size(); i++) {
				City newCity = new City(Main.PathCost[current.getId()].get(i).id,
						current.getCost() + Main.PathCost[current.getId()].get(i).driveRoute,
						current.getCost() + Main.PathCost[current.getId()].get(i).driveRoute, current);
				Fringe.add(newCity);
				visitedIds.add(newCity.getId());
			}
		}
		return reversePathFound(Goal, Path);
	}

	public static ArrayList<City> AStar(int startId, ArrayList<Integer> goalsId) {
		clearOldData(resetAll);
		PriorityQueue<City> Fringe = new PriorityQueue<>();
		City startCity = new City(startId, 0, minHeurestic(startId, goalsId), null);
		Fringe.add(startCity);
		visitedIds.add(startCity.getId());
		while (Fringe.size() > 0) {
			City current = Fringe.poll();
			orderOfCityExpansionList.add(current);
			if (goalsId.contains(current.getId())) {
				Goal = current;
				break;
			}
			for (int i = 0; i < Main.PathCost[current.getId()].size(); i++) {
				City newCity = new City(Main.PathCost[current.getId()].get(i).id,
						current.getCost() + Main.PathCost[current.getId()].get(i).driveRoute,
						current.getCost() + Main.PathCost[current.getId()].get(i).driveRoute
								+ minHeurestic(Main.PathCost[current.getId()].get(i).id, goalsId),
						current);
				Fringe.add(newCity);
				visitedIds.add(newCity.getId());
			}
		}
		return reversePathFound(Goal, Path);
	}

	public static ArrayList<City> BFS(int startId, ArrayList<Integer> goalsId) {
		clearOldData(resetAll);
		Queue<City> Fringe = new LinkedList<>();
		City startCity = new City(startId, 0, minHeurestic(startId, goalsId), null);
		Fringe.add(startCity);
		visitedIds.add(startCity.getId());
		while (Fringe.size() > 0) {
			City current = Fringe.poll();
			orderOfCityExpansionList.add(current);
			if (goalsId.contains(current.getId())) {
				Goal = current;
				break;
			}
			for (int i = 0; i < Main.PathCost[current.getId()].size(); i++) {
				City newCity = new City(Main.PathCost[current.getId()].get(i).id,
						current.getCost() + Main.PathCost[current.getId()].get(i).driveRoute,
						minHeurestic(Main.PathCost[current.getId()].get(i).id, goalsId), current);
				Fringe.add(newCity);
				visitedIds.add(newCity.getId());
			}
		}
		return reversePathFound(Goal, Path);
	}

	public static ArrayList<City> DFS(int startId, ArrayList<Integer> goalsId) {
		clearOldData(resetAll);
		Stack<City> Fringe = new Stack<>();
		City startCity = new City(startId, 0, minHeurestic(startId, goalsId), null);
		Fringe.push(startCity);
		visitedIds.add(startCity.getId());
		while (Fringe.size() > 0) {
			City current = Fringe.pop();
			orderOfCityExpansionList.add(current);
			if (goalsId.contains(current.getId())) {
				Goal = current;
				break;
			}
			for (int i = Main.PathCost[current.getId()].size() - 1; i >= 0; i--) {
				if (visitedIds.contains(Main.PathCost[current.getId()].get(i).id))
					continue;
				City newCity = new City(Main.PathCost[current.getId()].get(i).id,
						current.getCost() + Main.PathCost[current.getId()].get(i).driveRoute,
						minHeurestic(Main.PathCost[current.getId()].get(i).id, goalsId), current);
				Fringe.push(newCity);
				visitedIds.add(newCity.getId());
			}
		}
		return reversePathFound(Goal, Path);
	}

	static ArrayList<City> reversePathFound(City Goal, ArrayList<City> Path) {
		while (Goal != null) {
			reversePath.push(Goal);
			Goal = Goal.nextTo;
		}
		while (reversePath.size() > 0)
			Path.add(reversePath.pop());
		return Path;
	}

	static int minHeurestic(int cityId, ArrayList<Integer> goalsId) {
		int min = Main.Heurestic[goalsId.get(0)].get(cityId);
		for (int i = 1; i < goalsId.size(); i++)
			if (Main.Heurestic[goalsId.get(i)].get(cityId) < min)
				min = Main.Heurestic[goalsId.get(i)].get(cityId);
		return min;
	}

	static Boolean resetAll = true;

	static void clearOldData(Boolean resetAll) {
		if (resetAll)
			orderOfCityExpansionList.clear();
		Path.clear();
		visitedIds.clear();
		Goal = null;
	}
}
