
public class City implements Comparable<City> {
	int id;
	int cost;
	int evaluationFunc;
	City nextTo; // parent

	City() {
		super();
		// TODO Auto-generated constructor stub
	}

	City(int id, int cost, int evaluationFunc, City nextTo) {
		this.id = id;
		this.cost = cost;
		this.evaluationFunc = evaluationFunc;
		this.nextTo = nextTo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getevaluationFunc() {
		return evaluationFunc;
	}

	public void setevaluationFunc(int evaluationFunc) {
		this.evaluationFunc = evaluationFunc;
	}

	public City getNextTo() {
		return nextTo;
	}

	public void setNextTo(City nextTo) {
		this.nextTo = nextTo;
	}

	@Override
	public String toString() {
		return "[" + getCityName(id) + ", Cost=" + cost + ", F(n)=" + evaluationFunc
				+ (nextTo == null ? ", Start Point!" : ", Next To " + getCityName(nextTo.getId())) + "]";
	}

	@Override
	public int compareTo(City city) {
		// TODO Auto-generated method stub
		return evaluationFunc - city.evaluationFunc;
	}

	static String getCityName(int id) {
		switch (id) {
		case 0:
			return "Aka";
		case 1:
			return "Bethlehem";
		case 2:
			return "Dura";
		case 3:
			return "Haifa";
		case 4:
			return "Halhoul";
		case 5:
			return "Hebron";
		case 6:
			return "Jenin";
		case 7:
			return "Jericho";
		case 8:
			return "Jerusalem";
		case 9:
			return "Nablus";
		case 10:
			return "Nazareth";
		case 11:
			return "Qalqilya";
		case 12:
			return "Ramallah";
		case 13:
			return "Ramleh";
		case 14:
			return "Sabastia";
		case 15:
			return "Safad";
		case 16:
			return "Salfit";
		case 17:
			return "Tubas";
		case 18:
			return "Tulkarm";
		case 19:
			return "Yafa";

		}
		return null;
	}
}
