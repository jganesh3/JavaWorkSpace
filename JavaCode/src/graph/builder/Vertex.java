package graph.builder;

/*
   Colors
   White : 0
   Grey  : 1
   Black :2
   
*/
 class Vertex implements Comparable<Vertex>{
	
	private String data;
	private int color;
	private int distance;
	private Vertex parent;
	
	public Vertex(String data){
		this.color=0;
		this.data=data;
		this.distance=0;
		parent=null;
		
	}
	
	
	
	
	@Override
	public String toString() {
		return "Vertex [data=" + data + ", color=" + color + ", distance="
				+ distance + ", parent=" + parent + "]";
	}




	public String getData(){
		return this.data;
	}
	
	
	public int getColor(){
		return this.color;
	}
	
	
	public void setParent(Vertex p){
		this.parent=p;
	}
	
	
	public int getDistance(){
		return this.distance;
	}
	
	
	public void setDistance(int d){
		this.distance=d;
	}
	
	
	public  void setColor(int c){
		this.color=c;
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}




	@Override
	public int compareTo(Vertex that) {
		return this.data.compareTo(that.data);
	}
	
	
	
	
	
	


}
