package day9;

public class InheritanceTest {
	public static void main(String[] args){
		NotebookComp nc = new NotebookComp("�̼���", 5);
		TabletNotebook tn = new TabletNotebook("������", 5, "ISE-241-242");
		nc.movingCar();
		tn.write("ISE-241-242");
	}

}
