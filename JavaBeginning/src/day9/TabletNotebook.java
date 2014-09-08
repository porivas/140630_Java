package day9;

class TabletNotebook extends NotebookComp{
	private String regstPenModel;
	public TabletNotebook(String name, int initChag, String pen){
		super(name, initChag);
		String regstPenModel = pen;
		//		regstPenModel = pen;
	}
	public void write(String penInfo){
		if(batteryCheck() == true){
			if(!regstPenModel.equals(penInfo)){
				System.out.println("등록된 펜이 아닙니다.");
			}
			else{
				System.out.println("필기내용을 처리합니다.");
				useBattery();
			}
		}
	}


}
