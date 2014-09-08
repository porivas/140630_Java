package org.thinker.fs.UI;

public class ExitStoreUI extends AbstractUI {

	@Override
	public void doJob() throws Exception {
		System.out.println("진짜 종료하시겠습니까?");
		String oper = scanner.nextLine();
		
		if(oper.equals("EXIT")){
			System.out.println("종료했습니다.");
			System.exit(-1);
		}
	}

}



